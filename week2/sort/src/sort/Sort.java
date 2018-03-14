package sort;

public class Sort {

    public static void bubbleSortForward(int[] arr, int[] iterationNum){
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно, 
              если они имеют неправильный порядок, 
              то меняем местами*/
                if( arr[j] < arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    iterationNum[0]++;
            }
        }
    }
}
    public static void bubbleSortBackward(int[] arr, int[] iterationNum){  
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                if( arr[j] > arr[j+1] ){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    iterationNum[0]++;
            }
        }
    }
}
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {5,2,3,8},
                {12,0,-3,1}
        };
        int[] iterationNum = {0};
        for (int i = 0; i < 3; i++) {
            if (i%2 == 0 ){
                bubbleSortForward(matrix[i], iterationNum);
            }
            else {
                bubbleSortBackward(matrix[i], iterationNum);
            };
        for (int j = 0; j < 4; j++){
                System.out.print(matrix[i][j]+" ");
        }
        System.out.print("\n");
}
        System.out.print("Количество итераций: "+iterationNum[0]+" ¯\\_(ツ)_/¯"+"\n");
    }
    
}
