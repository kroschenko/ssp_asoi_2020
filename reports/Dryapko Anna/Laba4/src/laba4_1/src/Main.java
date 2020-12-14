
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        RecordBook recordBook = new RecordBook();
        ArrayList<RecordBook.Session.SessionField> data = new ArrayList<RecordBook.Session.SessionField>();
        data.add(new RecordBook().new Session().new SessionField(1,"БиБД",9,"Экзамен"
        ,"Буров А.А"));
        data.add(new RecordBook().new Session().new SessionField(2,"ГиМС",7,"Зачет",
                "Студнева Г.И."));
        recordBook.sessionsList.add(new RecordBook().new Session(1,data));
        data.clear();
        data.add(new RecordBook().new Session().new SessionField(1,"МС",10,"Экзамен",
                "Маргулис И.Н."));
        data.add(new RecordBook().new Session().new SessionField(3,"СПО",9,"Зачет",
                "Климова Л.С."));
        recordBook.sessionsList.add(new RecordBook().new Session(2,data));
        recordBook.showRecordBook();
    }
}
