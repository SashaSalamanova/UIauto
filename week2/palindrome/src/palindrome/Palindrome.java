package palindrome;

public class Palindrome {

    public static boolean Palindrome(String text) {
        return text.replaceAll("\\W","")
                   .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W",""))
                   .reverse().toString());
    }
    
    public static void main(String[] args) {
        System.out.println(Palindrome("Madam'      I'm Adam"));
    }
    
}
