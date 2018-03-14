package family;

public abstract class Person {
    String name;
    int age;
    String gender;
    
    
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getGender(){
        return gender;
    }
}
class Father extends Person{
    //Конструктор
    public Father(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    };
    public void printInfo(){
        System.out.println("Имя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
   }
};
class Mother extends Person{
     //Конструктор
    public Mother(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void printInfo(){
        System.out.println("Имя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
   }
};
class Child extends Person{
    //Конструктор
    public Child(String name, int age, String gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    public void printInfo(){
        System.out.println("Имя:"+ getName() );
        System.out.println("Возраст:" + getAge() );
        System.out.println("Пол:" + getGender() );
   }
};
