package sort;

public class Matrix implements Print {
    int[][] matrix;
    public Matrix(int[][] matrix){
        this.matrix = matrix;
    }
    public void print(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++){
                System.out.print(matrix[i][j]+" ");
            }
        System.out.print("\n");
}
    }
}
