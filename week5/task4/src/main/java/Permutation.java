public class Permutation {

    private String sortSymbols(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    public boolean checkIfPermutation (String s,String t) {
        return s.length() == t.length() && sortSymbols(s).equals(sortSymbols(t));
    }
}
