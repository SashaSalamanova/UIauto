public class NumericalSequence {

    int[] numbers;
    NumericalSequence(int[] numbers){
        this.numbers = numbers;
    }
    public int[] getSequence(){
        return numbers;
    }
    public int getTreeNumberCount(){
        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            numbers[i] = Math.abs(numbers[i]);
            while (numbers[i] > 0) {
                if (numbers[i]%10 == 3) count++;
                numbers[i] = numbers[i]/10;
            }
        }
        return count;
    }
}
