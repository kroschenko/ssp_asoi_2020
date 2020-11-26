package com.company;

import com.company.exceptions.FileEmptyException;
import com.company.exceptions.FileExistsException;
import com.company.exceptions.NoDirectoryException;
import com.company.exceptions.NoPlaceException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {

    int storageSize = 1440000;

    short[] storageData = new short[storageSize];

    ArrayList<FileInfo> files = new ArrayList<FileInfo>();

    ArrayList<MemorySegment> freeSegments = new ArrayList<MemorySegment>();
    ArrayList<MemorySegment> occupiedSegments = new ArrayList<MemorySegment>();

    public Storage()
    {
        //добавляем корневую папку
        FileInfo root = new FileInfo();
        root.setIsDirectory(true);
        root.setName("root");
        files.add(root);

        //добавляем в свободные сегменты все пространство гибкого диска
        MemorySegment segment = new MemorySegment();
        segment.setStartIndex(0);
        segment.setEndIndex(storageSize-1);
        freeSegments.add(segment);
    }



    public void writeFile(String path, String directory) throws Exception
    {
        //если записать нужно не в корень
        if(!directory.equals("root"))
        {

            //проверяем, есть ли такая директория
            boolean isValidDirectory = false;

            for(int i=0; i<files.size(); i++)
                if(files.get(i).isDirectory() && files.get(i).getName().equals(directory))
                {
                    isValidDirectory = true;
                    break;
                }

            if(!isValidDirectory)
                throw new NoDirectoryException();
        }

        File file = new File(path);

        if(!file.exists())
            throw new FileNotFoundException();

        if(file.length()>storageSize)
            throw new NoPlaceException();

        if(file.length() == 0)
            throw new FileEmptyException();

        int fileSize = (int)file.length();

        int writedSegmentIndex = -1;

        //подбираем подходящий сегмент для записи
        for(int i=0; i<freeSegments.size(); i++)
            if(freeSegments.get(i).getSize()>=fileSize)
            {
                writedSegmentIndex = i;
                break;
            }

        if(writedSegmentIndex == -1)
            throw new NoPlaceException();

        //записываем данные из файла в буфер
        short[] fileData = new short[fileSize];

        Scanner scanner = new Scanner(file);

        for(int i=0; scanner.hasNextByte(); i++)
            fileData[i] = scanner.nextByte();

        //заполняем класс fileInfo
        FileInfo fileInfo = new FileInfo();
        fileInfo.setSize(fileSize);

        String[] subSplitted = path.split("/");

        //получаем расширение файла
        String[] splitted = subSplitted[subSplitted.length-1].split("\\.");

        String fileName, fileExtension;

        //если разбить не удалось, у файла нет расширения
        if(splitted.length == 0)
        {
            fileName = path;
            fileExtension = null;
        }
        else
        {
            fileExtension = splitted[splitted.length-1];
            splitted[splitted.length-1] = "";
            fileName = String.join(".", splitted);
        }

        //проверяем, существует ли такой файл
        for(int i=0; i<files.size(); i++)
            if(!files.get(i).isDirectory() && files.get(i).getPath().equals(directory)
                    && files.get(i).getName().equals(fileName) && files.get(i).getExtension().equals((fileExtension)))
                throw new FileExistsException();

        fileInfo.setName(fileName);
        fileInfo.setExtension(fileExtension);
        fileInfo.setPath(directory);

        //получаем записываемый сегмент
        MemorySegment memorySegment = freeSegments.get(writedSegmentIndex);

        //удаляем его из списка свободных сегментов
        freeSegments.remove(writedSegmentIndex);
        int startIndex = memorySegment.getStartIndex();

        //если сегмент на всю длину файла
        if(memorySegment.getSize() == fileSize)
            occupiedSegments.add(memorySegment);
        //если он больше длины файла
        else
        {
            MemorySegment occupiedSegment = memorySegment.clone();

            //возвращаем свободную часть сегмента в список свободных сегментов
            memorySegment.setStartIndex(startIndex + fileSize);
            freeSegments.add(memorySegment);

            unionContactFreeSegments();

            //добавляем в список занятых сегментов часть, в которую будем писать файл
            occupiedSegment.setEndIndex(startIndex + fileSize - 1);
            occupiedSegments.add(occupiedSegment);
        }


        fileInfo.setStartIndex(startIndex);

        //добавляем в список файлов
        files.add(fileInfo);

        //записываем непосредственно данные
        for(int i=startIndex; i<startIndex+fileSize; i++)
            storageData[i] = fileData[i-startIndex];

    }

    public void createDirectory(String parentPath, String name) throws  Exception
    {
        //если такая директория существует
        for(int i=0; i<files.size(); i++)
            if(files.get(i).isDirectory() && files.get(i).getPath().equals(parentPath+"/"+name))
                throw new FileExistsException();

        FileInfo fileInfo = new FileInfo();
        fileInfo.setName(parentPath+"/"+name);
        fileInfo.setIsDirectory(true);

        files.add(fileInfo);
    }

    public void unionContactFreeSegments()
    {
        for(int i=0; i<freeSegments.size(); i++)
        {
            for(int j=0; j<freeSegments.size(); j++)
            {
                //если нашлись два касающихся друг друга свободных сегмента, объединяем их
                if(i!=j && freeSegments.get(i).getEndIndex() == freeSegments.get(j).getStartIndex()-1)
                {
                    MemorySegment segment = new MemorySegment();

                    segment.setStartIndex(freeSegments.get(i).getStartIndex());
                    segment.setEndIndex(freeSegments.get(j).getEndIndex());

                    //т.к. индексы меняются после удаления первого элемента
                    int startIndexRemoved = freeSegments.get(j).getStartIndex();
                    freeSegments.remove(i);
                    for(int k=0; k<freeSegments.size(); k++)
                        if(freeSegments.get(k).getStartIndex()==startIndexRemoved) {
                            freeSegments.remove(k);
                            break;
                        }

                    freeSegments.add(segment);

                    unionContactFreeSegments();
                    return;
                }
            }

        }
    }

    public void removeFile(String path) throws Exception
    {
        //получаем имя файла, его расширение и путь
        String[] splitted = path.split("/");
        String fileName = splitted[splitted.length-1];
        String fileExtension = "";
        String[] splitextension = fileName.split("\\.");
        if(splitextension.length!=0)
        {
            fileExtension = splitextension[splitextension.length-1];
            splitextension[splitextension.length-1] = "";
            fileName = String.join(".", splitextension);
        }

        splitted[splitted.length-1] = "";

        String filePath = String.join("/", splitted);
        filePath = filePath.substring(0, filePath.length()-1);

        boolean removed = false;

        //ищем файл и если нашли, удаляем
        for(int i=0; i<files.size(); i++)
            if(files.get(i).getName().equals(fileName) && files.get(i).getPath().equals(filePath)
                    && files.get(i).getExtension().equals(fileExtension) &&!files.get(i).isDirectory())
            {
                for(int j=0; j<occupiedSegments.size(); j++)
                    if(occupiedSegments.get(j).getStartIndex()==files.get(i).getStartIndex())
                    {
                        MemorySegment segment = occupiedSegments.get(j).clone();
                        occupiedSegments.remove(j);
                        freeSegments.add(segment);
                        unionContactFreeSegments();

                        break;
                    }

                files.remove(i);

                removed = true;
                break;
            }

        if(!removed)
            throw new FileNotFoundException();
    }

    public void removeDirectory(String path){

        if(path.equals("root")||path.equals("root/"))
            return;

        for(int i=0; i<files.size(); i++)
        {
            if(!files.get(i).isDirectory())
            {
                //если файл, ищем совпадения по пути
                if(files.get(i).getPath().indexOf(path)==0)
                {
                    for(int j=0; j<occupiedSegments.size(); j++)
                        if(occupiedSegments.get(j).getStartIndex()==files.get(i).getStartIndex())
                        {
                            MemorySegment segment = occupiedSegments.get(j).clone();
                            occupiedSegments.remove(j);
                            freeSegments.add(segment);
                            unionContactFreeSegments();
                            break;
                        }

                    files.remove(i);
                    i=0;
                }
            }
            else
            {
                //если папка, ищем совпадения по имени
                if(files.get(i).getName().indexOf(path)==0)
                {
                    files.remove(i);
                    i=0;
                }
            }
        }
    }

    public void printFiles(){
        for(int i=0; i<files.size(); i++)
            System.out.println(files.get(i).toString());
    }

    public void printFreeSegments(){
        for(int i=0; i<freeSegments.size(); i++)
            System.out.println(freeSegments.get(i).toString());
    }

    public void printOccupiedSegments(){
        for(int i=0; i<occupiedSegments.size(); i++)
            System.out.println(occupiedSegments.get(i).toString());
    }

}
