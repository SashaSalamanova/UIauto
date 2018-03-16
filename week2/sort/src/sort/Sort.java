package sort;
public class Sort{
    public static void main(String[] args) {
        //Входной двумерный массив
        int[][] matrix = {
                {1,3,5,7},
                {5,2,3,8},
                {12,0,-3,1}
        };
        int[] iterationNum = {0};//Номер итерации
        Matrix myMatrix = new Matrix(matrix);
        System.out.print("Исходный массив\n");
        myMatrix.print();
        for (int i = 0; i < 3; i++) {
            if (i%2 == 0 ){
                SortedArray forwardSorted = new SortedArray(matrix[i], true, iterationNum);
                forwardSorted.sort();
            }
            else {
                SortedArray backwardSorted = new SortedArray(matrix[i], false, iterationNum);
                backwardSorted.sort();
            }
        }
        System.out.print("Отсортированный массив\n");
        myMatrix.print();
        System.out.print("Число итераций\n");
        System.out.print(iterationNum[0]+"\n");
};
}    
