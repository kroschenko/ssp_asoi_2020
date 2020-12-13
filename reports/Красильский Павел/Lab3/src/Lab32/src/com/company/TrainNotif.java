package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Train {
        private String number;
        private String fromStantion;
        private String toStantion;
        private String fromTime;
        private String toTime;
        private boolean commonPlaces;

        public Train() {
        }

        public void print() {
            if (commonPlaces)
                System.out.println("Номер:" + number + ", от станции: " + fromStantion + ", до станции: " + toStantion + ", отправление: " + fromTime + ", прибытие: " + toTime + ", наличие общих мест: есть");
            else
                System.out.println("Номер:" + number + ", от станции: " + fromStantion + ", до станции: " + toStantion + ", отправление: " + fromTime + ", прибытие: " + toTime + ", наличие общих мест: нету");
        }

         public boolean haveCommonPlaces() {
            return commonPlaces;
        }

        public void setCommonPlaces(boolean commonPlaces) {
            this.commonPlaces = commonPlaces;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getFromStantion() {
            return fromStantion;
        }

        public void setFromStantion(String fromStantion) {
            this.fromStantion = fromStantion;
        }

        public String getToStantion() {
            return toStantion;
        }

        public void setToStantion(String toStantion) {
            this.toStantion = toStantion;
        }

        public String getFromTime() {
            return fromTime;
        }

        public void setFromTime(String fromTime) {
            this.fromTime = fromTime;
        }

        public String getToTime() {
            return toTime;
        }

        public void setToTime(String toTime) {
            this.toTime = toTime;
        }
    }

public class TrainNotif {
        private ArrayList<Train> trains = new ArrayList<Train>();
    public boolean loadFromFile(String path) throws FileNotFoundException {
        ArrayList<Train> tempList = new ArrayList<Train>();
        File file = new File(path);

        Scanner scanner = new Scanner(file, "utf-8");;

        while(scanner.hasNextLine()) {
            String[] values = scanner.nextLine().split(" ");

            if (values.length != 6)
                return false;

            Train train = new Train();

            try {
                train.setNumber(values[0]);
                train.setFromStantion(values[1]);
                train.setToStantion(values[2]);
                train.setFromTime(values[3]);
                train.setToTime(values[4]);
                train.setCommonPlaces(values[5].equals("Да") || values[5].equals("да"));
                tempList.add(train);
            }
            catch(Exception e) {
                return false;
            }

        }

        scanner.close();

        trains = tempList;

        return true;
    }

    public void printTrains()
    {
        for (Train train : trains)
            train.print();
    }

    public void printTrainByNumber(String number) {
        for (Train train : trains)
            if (train.getNumber().equals(number))
                train.print();
    }

    public void printTrainsByToStation(String toStation) {
        for (Train train : trains)
            if (train.getToStantion().equals(toStation))
                train.print();
    }

    public void printTrainsByToStationAndFromTime(String toStation, String fromTime) {
        String[] fT = fromTime.split(":");
        int fTHour = Integer.parseInt(fT[0]);
        int fTMinutes = Integer.parseInt(fT[1]);
        for (Train train : trains) {
            if (train.getToStantion().equals(toStation)) {
                String[] fTForCheck = train.getFromTime().split(":");
                int fTHourForCheck = Integer.parseInt(fTForCheck[0]);
                int fTMinutesForCheck = Integer.parseInt(fTForCheck[1]);
                if (fTHour < fTHourForCheck) {
                    train.print();
                }
                if (fTHour == fTHourForCheck) {
                    if (fTMinutes < fTMinutesForCheck) {
                        train.print();
                    }
                }
            }
        }
    }

    public void printTrainsByToStationAndCP(String toStation) {
        for (Train train : trains) {
            if (train.getToStantion().equals(toStation)) {
                if (train.haveCommonPlaces())
                    train.print();
            }
        }
    }

    public void printtrainFromTime(String fromTime) {
        String[] fT = fromTime.split(":");
        int fTHour = Integer.parseInt(fT[0]);
        int fTMinutes = Integer.parseInt(fT[1]);
        for (Train train : trains) {
            String[] fTForCheck = train.getFromTime().split(":");
            int fTHourForCheck = Integer.parseInt(fTForCheck[0]);
            int fTMinutesForCheck = Integer.parseInt(fTForCheck[1]);
            if (fTHour == fTHourForCheck) {
                if (fTMinutes+3 == fTMinutesForCheck) {
                    System.out.println("Через 3 минуты отправляется поезд: ");
                    train.print();
                }
                if (fTMinutes+5 == fTMinutesForCheck) {
                    System.out.println("Через 5 минут отправляется поезд: ");
                    train.print();
                }
                if (fTMinutes+10 == fTMinutesForCheck) {
                    System.out.println("Через 10 минут отправляется поезд: ");
                    train.print();
                }
            }
        }
    }
}
