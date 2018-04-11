import org.junit.*;
import org.junit.experimental.categories.Category;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;


public class ThreeNumbersCountTest extends Assert{
    private NumericalSequence sequenceForTest;

    @After
    public void clear() { sequenceForTest= null; }

    @Category(categories.Positive.class)
    @Test
    public void whenSequenceHasFourNumbersThreeReturnFour() {
        int[] numbers = {13, 12, 48, 37, 6323};
        sequenceForTest = new NumericalSequence(numbers);
        assertThat( "В последовательности содержится четыре цифры 3", sequenceForTest.getTreeNumberCount(), is(4));
    }

    @Category(categories.Positive.class)
    @Test
    public void whenSequenceHasTenNumbersThreeReturnTen() {
        int[] numbers = {399, 12, 348, 373333, 1363, 70030};
        sequenceForTest = new NumericalSequence(numbers);
        assertThat( "В последовательности содержится десять цифр 3", sequenceForTest.getTreeNumberCount(), is(10));
    }

    @Category(categories.Negative.class)
    @Test
    public void whenSequenceHasSevenNumbersThreeDoNotReturnFive() {
        int[] numbers = {0, 0, 77, 7007, 67, 10, -977};
        sequenceForTest = new NumericalSequence(numbers);
        assertThat( "В последовательности не пять цифр 3", sequenceForTest.getTreeNumberCount(), not(5));
    }

    @Category(categories.Negative.class)
    @Test
    public void whenSequenceHasNoNumbersThreeDoNotReturnHundred() {
        int[] numbers = {0, -1, 77, 100000, -48, 55};
        sequenceForTest = new NumericalSequence(numbers);
        assertThat( "В последовательности не 100 цифр 3", sequenceForTest.getTreeNumberCount(), not(100));
    }

}
