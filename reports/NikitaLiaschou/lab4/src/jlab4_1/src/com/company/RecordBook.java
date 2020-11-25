package com.company;

import java.util.ArrayList;

public class RecordBook {
    //Поля и методы внешнего класса Зачетная книжка
    public  ArrayList<Session> sessionsList = new ArrayList<Session>();

    public void showRecordBook() {
        for(Session item : sessionsList) {
            System.out.println("\nСессия №" + item.sessionId+"\n"+"--------------------------");
            for(Session.SessionField item2 : item.sessionFieldsList) {
                System.out.print("Тип :"+item2.fieldType+"\n");
                System.out.print("Номер предмета :"+item2.fieldId+"\t");
                System.out.print("Имя предмета :"+item2.fieldSubject+"\t");
                System.out.print("Оценка по предмету :"+item2.fieldMark+"\n");
            }
        }
    }

    //        public void add(int id) {
//            boolean isExist = false;
//            Session temp;
//            for(Session item : sessionsList) {
//               if(item.sessionId == id) {
//                   isExist = true;
//                   temp = item;
//                   break;
//               }
//           }
//            if(isExist) {
//                System.out.println("Сессия с таким id уже существует");
//                return;
//            } else {
//                temp = new Session(id);
//                sessionsList.add(temp);
//            }
//        }

    //Внутренний класс Сессия
    public class Session {
        //Поля и методы внутреннего класса Сессия
        public int sessionId;
        public  ArrayList<SessionField> sessionFieldsList = new ArrayList<SessionField>();

        //Конструктор класса Сессия
        public Session(int id, ArrayList<SessionField> testList) {
            this.sessionId = id;
            this.sessionFieldsList = testList;
        }

        public Session() {
        }

        //Внутренний класс Поле Сессии
        public class SessionField {
            //Поля и методы внутреннего класса Поле Сессии
            public int fieldId;
            public String fieldSubject;
            public int fieldMark;
            public String fieldType;

            //Конструктор класса Поле Сессии
            public SessionField(int fieldId, String fieldSubject, int fieldMark, String fieldType) {
                this.fieldId = fieldId;
                this.fieldSubject = fieldSubject;
                this.fieldMark = fieldMark;
                this.fieldType = fieldType;
            }
        }
    }
}



