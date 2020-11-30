public class Car {
    private String ID;
    private String mark;
    private String model;
    private String yearIssue;
    private String color;
    private String price;
    private String registrationNumber;
    private String numberCar;
    private String personRented;
    private String pasportID;


    public Car(String ID, String mark, String model, String yearIssue, String color,
               String price, String registrationNumber,String numberCar, String personRented, String pasportID) {
        this.ID = ID;
        this.mark = mark;
        this.model = model;
        this.yearIssue = yearIssue;
        this.color = color;
        this.price = price;
        this.registrationNumber = registrationNumber;
        this.numberCar = numberCar;
        this.personRented = personRented;
        this.pasportID = pasportID;
    }

    public String getCar(){
        return "Car{" +
                "ID=" + ID +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", yearIssue=" + yearIssue +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", numberCar=" + numberCar +
                '}';
    }

    @Override
    public String toString() {
        return "Car{" +
                "ID='" + ID + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", yearIssue='" + yearIssue + '\'' +
                ", color='" + color + '\'' +
                ", price='" + price + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", numberCar='" + numberCar + '\'' +
                ", personRented='" + personRented + '\'' +
                ", pasportID='" + pasportID + '\'' +
                '}';
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearIssue() {
        return yearIssue;
    }

    public void setYearIssue(String yearIssue) {
        this.yearIssue = yearIssue;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getNumberCar() {
        return numberCar;
    }

    public void setNumberCar(String numberCar) {
        this.numberCar = numberCar;
    }

    public String getPersonRented() {
        return personRented;
    }

    public void setPersonRented(String personRented) {
        this.personRented = personRented;
    }

    public String getPasportID() {
        return pasportID;
    }

    public void setPasportID(String pasportID) {
        this.pasportID = pasportID;
    }
}
