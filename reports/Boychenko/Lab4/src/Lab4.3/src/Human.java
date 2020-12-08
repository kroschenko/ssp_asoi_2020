public abstract class Human {
    protected String name;
    protected Integer age;

    protected Human(String name, Integer age)
    {
        if (name.isBlank()|| age < 0)
            throw new RuntimeException("You must declare both name and age");
        this.name = name;
        this.age = age;
    }
}
