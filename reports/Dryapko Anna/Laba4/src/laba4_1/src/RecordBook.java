
import java.util.ArrayList;

public class RecordBook {

    public  ArrayList<Session> sessionsList = new ArrayList<Session>();

    public void showRecordBook() {
        for(Session item : sessionsList) {
            System.out.println("\nСессия " + item.sessionId);
            for(Session.SessionField item2 : item.sessionFieldsList) {
                System.out.print(item2.fieldType+"\n");
                System.out.print("Номер предмета: "+item2.fieldId+"\t");
                System.out.print("Предмета: "+item2.fieldSubject+"\t");
                System.out.print("Оценка: "+item2.fieldMark+"\n");
                System.out.print("Преподаватель: "+item2.lecturer+"\n");
            }
        }
    }


    public class Session {


        public int sessionId;
        public  ArrayList<SessionField> sessionFieldsList = new ArrayList<SessionField>();


        public Session(int id, ArrayList<SessionField> testList) {
            this.sessionId = id;
            this.sessionFieldsList = testList;
        }

        public Session() {
        }


        public class SessionField {

            public int fieldId;
            public String fieldSubject;
            public int fieldMark;
            public String fieldType;
            public String lecturer;


            public SessionField(int fieldId, String fieldSubject, int fieldMark, String fieldType, String lecturer) {
                this.fieldId = fieldId;
                this.fieldSubject = fieldSubject;
                this.fieldMark = fieldMark;
                this.fieldType = fieldType;
                this.lecturer=lecturer;
            }
        }
    }
}

