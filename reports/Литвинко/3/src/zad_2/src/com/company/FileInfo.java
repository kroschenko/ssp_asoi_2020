package com.company;

public class FileInfo {

    private int size = -1;
    private String name = "";
    private String extension = "";
    private boolean isDirectory = false;
    private String path = "";
    private int startIndex = -1;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setIsDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public String toString(){
        if(!isDirectory)
            return path+"/"+name+extension+"; size="+size+"; startIndex="+startIndex;
        else
            return name+"/"+ " (directory)";
    }
}
