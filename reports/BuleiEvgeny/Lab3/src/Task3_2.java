import java.io.*;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Car> list;
    public static void main(String[] args){
        list = new ArrayList<>();
        fillList(list);
        System.out.println("All cars");
        outputData(list);
        System.out.println("Cars mark bmw");
        carMark(list,"bmw");
        System.out.println("Cars model q7, yers explotion more 1 year");
        carModelAndYear(list,"q7",1);
        System.out.println("Cars year issue 2018 and prise more 250000");
        carYearAndPrice(list,2018,250000);
        System.out.println("Cars what was rented");
        retnedCar(list);
        System.out.println("Cars what was rented with information about man");
        retnedCarAndInformation(list);
    }

    public static void fillList(ArrayList<Car> list){
        try {
            File file = new File("car.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            Car car;
            while(line!=null){
                String[] words = line.split("\t");
                car = new Car(words[0],words[1],words[2],words[3],words[4],
                            words[5],words[6],words[7],words[8],words[9]);
                list.add(car);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void outputData(ArrayList<Car> list){
        for(Car car : list){
            System.out.println(car.getCar());
        }
    }

    public static void carMark(ArrayList<Car> list, String mark){
        for(Car car : list){
            if(car.getMark().equals(mark)){
                System.out.println(car.getCar());
            }
        }
    }

    public static void carModelAndYear(ArrayList<Car> list, String model, int year){
        for(Car car : list){
            int yearIssue = 2020 - Integer.parseInt(car.getYearIssue());
            if(car.getModel().equals(model) && yearIssue>year){
                System.out.println(car.getCar());
            }
        }
    }

    public  static void carYearAndPrice(ArrayList<Car> list, int year, int price){
        String yearIssue = Integer.toString(year);
        for(Car car : list){
            if(car.getYearIssue().equals(yearIssue) && Integer.parseInt(car.getPrice())>price){
                System.out.println(car.getCar());
            }
        }
    }

    public static void retnedCar(ArrayList<Car> list){
        for(Car car : list){
            if(!car.getPersonRented().equals("-")){
                System.out.println(car.getCar());
            }
        }
    }

    public static void retnedCarAndInformation(ArrayList<Car> list){
        for(Car car : list){
            if(!car.getPersonRented().equals("-")){
                System.out.println(car.toString());
            }
        }
    }
}
