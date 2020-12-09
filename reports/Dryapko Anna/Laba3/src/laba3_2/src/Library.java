public class Library {
    private String numberUdk;
    private String SurnameInit;
    private String title;
    private String year;
    private String numberExampleInLibrary;
    private String numberPages;
    private String numberVolume;
    private String fio;
    private String timeToPass;

    public Library(String numberUdk, String surnameInit, String title, String year, String numberExsampleInLibrary, String numberPages, String numberVolume) {
        this.numberUdk = numberUdk;
        SurnameInit = surnameInit;
        this.title = title;
        this.year = year;
        this.numberExampleInLibrary = numberExsampleInLibrary;
        this.numberPages = numberPages;
        this.numberVolume = numberVolume;

    }

    public Library(String numberUdk, String surnameInit, String title, String year, String numberExampleInLibrary, String numberPages, String numberVolume, String fio, String timeToPass) {
        this.numberUdk = numberUdk;
        SurnameInit = surnameInit;
        this.title = title;
        this.year = year;
        this.numberExampleInLibrary = numberExampleInLibrary;
        this.numberPages = numberPages;
        this.numberVolume = numberVolume;
        this.fio = fio;
        this.timeToPass = timeToPass;
    }



    public String getBook() {
        return
                "numberUdk='" + numberUdk + '\'' +
                ", SurnameInit='" + SurnameInit + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", numberExampleInLibrary='" + numberExampleInLibrary + '\'' +
                ", numberPages='" + numberPages + '\'' +
                ", numberVolume='" + numberVolume + '\'' ;
    }


    public String getAllInfo() {
        return
                "numberUdk='" + numberUdk + '\'' +
                ", SurnameInit='" + SurnameInit + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", numberExampleInLibrary='" + numberExampleInLibrary + '\'' +
                ", numberPages='" + numberPages + '\'' +
                ", numberVolume='" + numberVolume + '\'' +
                ", fio='" + fio + '\'' +
                ", timeToPass='" + timeToPass + '\''
                ;
    }

    public String getNumberUdk() {
        return numberUdk;
    }

    public String getSurnameInit() {
        return SurnameInit;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getNumberExampleInLibrary() {
        return numberExampleInLibrary;
    }

    public String getNumberPages() {
        return numberPages;
    }

    public String getNumberVolume() {
        return numberVolume;
    }

    public String getFio() {
        return fio;
    }

    public String getTimeToPass() {
        return timeToPass;
    }
}
