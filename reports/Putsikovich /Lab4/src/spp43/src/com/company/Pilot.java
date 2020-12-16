package com.company;

public class Pilot extends Worker {

    private Administrator administrator = null;
    private Cruise cruise = null;

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public void setCruise(Cruise cruise) {
        this.cruise = cruise;
    }

    public void callAdministratorChangeAeroportDestination(Aeroport destinationAeroport){
        if(administrator!=null&&cruise!=null){
            administrator.askChangeDestinationAeroport(cruise, destinationAeroport);
        }
    }

    public void work(){
        System.out.println("Пилот работает!");
    }

    public void show(){
        System.out.println("Пилот:");
        super.show();
    }

    public Pilot(int id, String fio, Administrator administrator){
        super(id, fio);
        this.administrator = administrator;
    }
}
