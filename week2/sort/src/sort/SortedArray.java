package sort;

public class SortedArray implements SortArray{
    int[] arr;
    boolean direction; //true - forward, false - backward
    int[] iterationNum;
    public SortedArray(int[] arr, boolean direction, int[] iterationNum){
        this.arr = arr;
        this.direction = direction;
        this.iterationNum = iterationNum;
    }
    public void sort(){
        if(direction){
            for(int i = arr.length-1 ; i > 0 ; i--){
                for(int j = 0 ; j < i ; j++){
                    if( arr[j] < arr[j+1] ){
                        int tmp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = tmp;
                        iterationNum[0]++;
                    }
                }
            }
        }
        else{
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
    }
}
