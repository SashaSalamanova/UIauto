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
    //Метод, одинаковый для любого человека
    public void sayHi(){
        System.out.println("Имя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
   }
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
};
class Mother extends Parent{
    public Mother(String name, int age, String gender){
    super(name, age, gender);
    }
};
class Child extends Person{
    //Конструктор
    public Child(String name, int age, String gender){
        super(name, age, gender);
    }
};
