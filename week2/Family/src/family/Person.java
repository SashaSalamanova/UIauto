package family;

public abstract class Person {
    private String name;
    private int age;
    private String gender;
    //Конструктор
    public Person(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
    abstract public void sayHi();
};

abstract class Parent extends Person{
    public Parent(String name, int age, String gender){
        super(name, age, gender);
    }
};    

class Father extends Parent{
    public Father(String name, int age, String gender){
    super(name, age, gender);
}
    @Override
    public void sayHi(){
        System.out.println("Папа:\nИмя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
    }
};

class Mother extends Parent{
    public Mother(String name, int age, String gender){
    super(name, age, gender);
    }
    @Override
    public void sayHi(){
        System.out.println("Мама:\nИмя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
    }
};

class Child extends Person{
    //Конструктор
    public Child(String name, int age, String gender){
        super(name, age, gender);
    }
    @Override
    public void sayHi(){
        System.out.println("Ребенок:\nИмя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
    }
};