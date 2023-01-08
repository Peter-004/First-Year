import java.util.*;

public class RomanNumeral {
    /**
     * romanNumeral method converts an integer to roman numeral, while n < 4000. This is not the simplest code, I was just not reasonable
     * Inspiration for code: leetcode
     * @param n the integer to be converted
     * @return a string of characters representing the roman number of the integer n
     * @author Adebayo Peter
     */
    public static String romanNumeral(int n){
        String roman = "";
        int[] num = {1,5,10,50,100,500,1000,4000};
        String[] romans = {"I","V","X","L","C","D","M"};
        String t = String.valueOf(n);
        int len = t.length();
        for(int i = 0;i<len;i++){
            int a = Integer.parseInt(String.valueOf(t.charAt(i)));
            int m = a * (int)Math.pow(10,len-1-i);
            for(int j = 0;j<7;j++){
                if(m == num[j])roman += romans[j];
                else{
                    if(a == 4){
                        if(m>num[j] && m<num[j+1])roman += (romans[j] + romans[j+1]);
                    }
                    else if(a == 9){
                        if(m>num[j] && m<num[j+1])roman += (romans[j-1] + romans[j+1]);
                    }
                    else if(m>num[j] && m<num[j+1]){
                        int lend = 0;
                        if(a<5){
                            while(lend != m){
                                roman += romans[j];
                                lend += num[j];
                            }
                        }
                        else{
                            int si = num[j];
                            roman += romans[j];
                            while(si != m){
                                roman += romans[j-1];
                                si += num[j-1];
                            }
                        }
                    }
                }
            }
        }
        return roman;
    }

    /**
     * Inspiration for code: leetcode
     * numRoman method returns an integer associated with the roman numeral s
     * @param s the roman numeral to be converted
     * @return an integer n -- the integer associated with the roman number s
     * @author Adebayo Peter
     */
    public static int numRoman(String s){
        int n = 0;
        String[] r = {"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        int[] num = {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        int i = 0;
        while(i < s.length()){
            if(i == s.length() - 1){
                n += num[Arrays.asList(r).indexOf(String.valueOf(s.charAt(i)))];
            }
            else{
                if(Arrays.asList(r).contains(s.substring(i,i+2))){
                    n += num[Arrays.asList(r).indexOf(s.substring(i,i+2))];
                    i++;
                }
                else{
                    n += num[Arrays.asList(r).indexOf(String.valueOf(s.charAt(i)))];
                }
            }
            i++;
        }
        return n;
    }

    public static void main(String[] args){
        long st = System.currentTimeMillis();
        Random r = new Random();
        int t = r.nextInt(4000);
        for(int i = 1;i<=t;i++){
            System.out.println(i+" "+romanNumeral(i));
       }

        System.out.println(numRoman("XCIV"));
        System.out.println(numRoman("CDXLIV"));
        System.out.println(numRoman("CMXCIX"));
        System.out.println(numRoman("DIV"));
        System.out.println(numRoman("VIII"));
        long et = System.currentTimeMillis();
        long dur = et - st;
        System.out.println("Your runtime was: "+ dur+"ms");
    }
}
