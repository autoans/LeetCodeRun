package bitmanipulation;

import java.util.Arrays;

/**
 * 1009. Complement of Base 10 Integer
 * @author penzh
 *
 */
public class NumberComplement {
    public int bitwiseComplement2(int N) {
        if (N == 0) return 1;
        //if (N == 1) return 0;
        int x = 1;
        while(x<= N){
             x = x << 1;
        }
        return N ^ (x-1);
    }
    public int bitwiseComplement(int N) {
        String bit = Integer.toBinaryString(N);
        
        char[] complement = bit.toCharArray();
        for (int i = 0; i < complement.length; i++) {
            complement[i] = (complement[i] == '0'? '1' : '0');
        }
        
        return Integer.parseInt(String.valueOf(complement), 2);
    }
    
    public static void main(String[] args) {
        NumberComplement nc = new NumberComplement();
        System.out.println(nc.bitwiseComplement2(1));
    }
}
