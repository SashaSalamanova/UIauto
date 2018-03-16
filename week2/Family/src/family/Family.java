package family;

public class Family {
    public static void main(String[] args) {
        Parent dad = new Father("Dad", 50, "Male");
        Parent mum = new Mother("Mum", 47, "Female");
        Person boy = new Child("Boy", 10, "Male");
        Person girl = new Child("Girl", 5, "Female");
        Person[] children = {boy, girl};   
        
        GatheredFamily myFamily = new GatheredFamily(dad, mum, children);
        myFamily.familyInfo();
    }
    
}
