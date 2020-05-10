package bitmanipulation;

public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int[] wordsInt = new int[words.length]; // keeps each word's int representation
        int[] lengths = new int[words.length]; // keeps each word's length
        int max = 0;
        for (int i = 0 ; i < words.length; i++) {
            lengths[i] = words[i].length();
            for (int j = 0 ; j < lengths[i]; j++) {
                wordsInt[i] |= 1 << words[i].charAt(j) - 'a'; //!! good use of bit manipulation
            }
        }
        
        for (int i = 0 ; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if ((wordsInt[i] & wordsInt[j]) == 0) {
                    max = Math.max(max, lengths[i] * lengths[j]);
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        MaximumProductofWordLengths mp = new MaximumProductofWordLengths();
        String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(mp.maxProduct(words));
    }
}
