import org.junit.*;
public class StringPermutationTest extends Assert{
    private static Permutation permutationForTest;

    @BeforeClass
    public static void init() { permutationForTest = new Permutation(); }
    @AfterClass
    public static void clear() { permutationForTest = null; }

    @Test
    public void differentCaseWithSpaceTest(){
        String firstString = "На дворе - трава";
        String secondString = "На траве - дрова";
        assertTrue("Строки являются анаграммами",
                permutationForTest.checkIfPermutation(firstString, secondString));
    }

    @Test
    public void oneCaseNoSpaceTest(){
        String firstString = "СПАНИЕЛЬ";
        String secondString = "АПЕЛЬСИН";
        assertTrue("Строки являются анаграммами",
                permutationForTest.checkIfPermutation(firstString, secondString));
    }

    @Test
    public void isNotPermutationTest(){
        String firstString = "The eyes";
        String secondString = "They sea";
        assertFalse("Строки не являются анаграммами",
                permutationForTest.checkIfPermutation(firstString, secondString));
    }

    @Test
    public void secondNegativeTest(){
        String firstString = "ERAΣ ION";
        String secondString = "ARΣINOE";
        assertFalse("Строки не являются анаграммами",
                permutationForTest.checkIfPermutation(firstString, secondString));
    }

    @Test(expected = NullPointerException.class)
    public void testWithException(){
            assertTrue("Проверка исключения",
                    permutationForTest.checkIfPermutation(null, null));
    }
}
