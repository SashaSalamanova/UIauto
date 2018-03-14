package MainPackage;

import java.util.ArrayList;

/**
 * Created by User on 13.03.2018.
 */
public class Person {
    private String name;
    private int age;
    private boolean gender; //true - male; false - female;
    private Person father;
    private Person mother;
    private ArrayList<Person> children = new ArrayList<Person>();




    public String getName() {
        return this.name;
    }
    public int getAge() {
        return this.age;
    }
    public boolean getGender(){
        return this.gender;
    }

    public Person getFather(){
        return this.father;
    }

    public Person getMother(){
        return this.mother;
    }

    public ArrayList<Person> getChildren(){
        return this.children;
    }

    public void printChildren(ArrayList<Person> children) {
        for (int i = 0; i < children.size(); i++) {
            System.out.print("Ребенок" + i + " - " + children.get(i) + " ");
        }
    }

    public void addChild(Person child){
        this.children.add(child);
    }



    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(boolean gender){
        this.gender = gender;
    }

    public void setFather(Person father){
        this.father = father;
    }

    public void setMother(Person mother){
        this.mother = mother;
    }

    public void setChildren(ArrayList<Person> children){
        this.children = children;
    }

    public Person(String name, int age, boolean gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(String name, int age, boolean gender, ArrayList<Person> children){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.children = children;
    }

    public Person(String name, int age, boolean gender, Person parent) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        if (parent.getGender())
            this.father = parent;
        else
            this.mother = parent;
    }

    public Person(String name, int age, boolean gender, Person parent1, Person parent2) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        if (parent1.getGender()) {
            this.father = parent1;
            this.mother = parent2;
        }
        else {
            this.mother = parent1;
            this.father = parent2;
        }
    }

    public void getInfo() {
        System.out.println("Имя: " + this.getName());
        System.out.println("Возраст: " + this.getAge());

        if (this.getGender())
            System.out.println("Пол: М");
        else
            System.out.println("Пол: Ж");

        if (this.getFather() != null) {
            System.out.println("Отец: " + this.getFather().getName());
        }

        if (this.getMother() != null) {
            System.out.println("Мать: " + this.getMother().getName());
        }

        if (this.getChildren() != null) {
            printChildren(this.getChildren());
        }

    }

}
