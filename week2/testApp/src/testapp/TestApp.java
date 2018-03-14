package testapp;

public class TestApp {

    public static void main(String[] args) {
       //Вывод четных чисел массива
        int[] a = {2, 6, 9, 12};
        for (int i = 0; i < 4; i++){
            if (a[i]%3 == 0 && a[i]%2 == 0){
                System.out.print(a[i]+" ");
            }
        }
        
    }
    
}
