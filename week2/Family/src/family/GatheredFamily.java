package family;

public class GatheredFamily {
    private Parent father;
    private Parent mother; 
    private Person[] children;
    
    public GatheredFamily(Parent father, Parent mother, Person[] children){
        this.father = father;
        this.mother = mother;
        this.children = children;
    };
    public void familyInfo(){
        System.out.println("Информация о семье:" );
        father.sayHi();
        mother.sayHi();
        for(int i = 0; i < children.length; i++){
            children[i].sayHi();
        }
    }
}