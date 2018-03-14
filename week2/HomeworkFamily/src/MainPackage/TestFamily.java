package MainPackage;

public class TestFamily {
    public static void main(String[] args) {
        Person papa = new Person("papa", 32, true);
        Person mama = new Person("mama", 31, false);
        Person maloy = new Person("maloy", 5, true, papa, mama);
        Person malaya = new Person("malaya", 3, true, papa, mama);
        papa.addChild(maloy);
        mama.addChild(maloy);
        papa.addChild(malaya);
        mama.addChild(malaya);
        maloy.getInfo();
    }
}

