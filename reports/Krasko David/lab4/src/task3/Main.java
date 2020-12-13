class Main {
  public static void main(String[] args) {
    StationManager manager = new StationManager();
    User<String> abonent = new User<>("+8800553535", false);
    User admin = new User("+8800880000", true);
    abonent.setMeta("This user is good");

    manager.addUser(abonent);
    manager.addUser(admin);
    manager.print(abonent);

    manager.pay(abonent, -10);
    manager.deactiveUser(admin, abonent);
    manager.print(abonent);
    manager.pay(abonent, 20);
    manager.print(abonent);

    manager.changeNumber(abonent, abonent, "+7700777777");
    manager.changeNumber(admin, abonent, "+7700777777");
    manager.print(abonent);

    manager.addService(admin, abonent, "Online TV", 5.3);
    manager.print(abonent);

    manager.deleteService(admin, abonent, "Online TV");
    manager.deleteService(admin, abonent, "Online TV");
    manager.print(abonent);
  }
}

/*
Построить модель программной системы с применением отношений (обобщения, агрегации, ассоциации, реализации) между классами. Задать атрибуты и методы классов. Реализовать (если необходимо) дополнительные классы. Продемонстрировать работу разработанной системы.

Система Телефонная станция. 
Абонент оплачивает Счет за разговоры и Услуги, может попросить Администратора сменить номер и отказаться от услуг.
Администратор изменяет номер, Услуги и временно отключает Абонента за неуплату.

Station manager
User(Abonent, Admin)
Service(tele, additional)

*/
