
package summ;
//Сумма цифр натурального числа
public class Summ {
    public static int recursion(int n) {
        //Если чтсло сотоит из одной цифры
        if (n < 10) {
            return n;
        }// Рекурсия
        else {
            return n % 10 + recursion(n / 10);
        }
    }
    public static void main(String[] args) {
        System.out.println(recursion(666)); 
    }
}
