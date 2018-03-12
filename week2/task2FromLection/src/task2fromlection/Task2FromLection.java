/*Создайте массив целых чисел (размер 7 элементов), заполните его только четными числами, 
а затем каждый второй элемент умножьте на предыдущий*/
package task2fromlection;

public class Task2FromLection {
    
    public static void main(String[] args) {
        int[] arr = new int[7];
        //Заполнить четными числами
        for (int i = 0; i < 7; i++){
            arr[i] = (i+1)*2;
            //каждый второй умножить на предыдущий
            if((i+1)%2 == 0){
                arr[i]=arr[i]*arr[i-1];
            }
            System.out.print(arr[i]+" ");
        }
    }
}
