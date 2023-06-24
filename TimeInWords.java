public class TimeInWords {
    public static String timeInWords(int h, int m) {
        // Write your code here
        String[] words = {"o' clock","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen","twenty","twenty-one", "twenty-two", "twenty three", "twenty four","twenty five", "twenty six", "twenty seven", "twenty eight", "twenty nine", "half past"};
        if(m == 0)return String.format("%s %s", words[h], words[m]);
        else if(m == 1)return String.format("one minute past %s", words[h]);
        else if(m<30 && m%15!=0){
            return String.format("%s minutes past %s",words[m],words[h]);
        }
        else if(m<30 && m ==15){
            return String.format("quarter past %s",words[h]);
        }
        else if(m == 30)return String.format("half past %s",words[h]);
        else if(m == 59){
            return String.format("one minute to %s",words[(h+1)%12]);
        }
        else if(m>30 && m%15!=0){
            return String.format("%s minutes to %s", words[60-m],words[(h+1)%12]);
        }
        else if(m>30 && m == 45){
            return String.format("quarter to %s",words[(h+1)%12]);
        }
        return null;
    }
    public static void main(String[] args){
        System.out.println(timeInWords(5,00));
        System.out.println(timeInWords(5,01));
        System.out.println(timeInWords(5,15));
        System.out.println(timeInWords(5,29));
        System.out.println(timeInWords(5,45));
        System.out.println(timeInWords(5,59));
        System.out.println(timeInWords(12,59));

    }
}
