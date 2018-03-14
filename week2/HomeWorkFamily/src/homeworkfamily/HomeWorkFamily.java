package homeworkfamily;

public class HomeWorkFamily {

    public static void main(String[] args) {
        Father dad = new Father("Dad", 50, "Male");
        Mother mum = new Mother("Mum", 47, "Female");
        Child boy = new Child("Boy", 10, "Male");
        Child girl = new Child("Girl", 5, "Female");
        
        dad.printInfo();
        mum.printInfo();
        boy.printInfo();
        girl.printInfo();
    }
    
}
