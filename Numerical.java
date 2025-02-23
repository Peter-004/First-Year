import java.util.*;
import javax.script.*;
public class Numerical {
    public static double eval(String infix) {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        Object stringResult;
        try {
            stringResult = engine.eval(infix);
            //int result = (int) doubleResult;
            return Double.parseDouble(stringResult.toString());
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
        return(1);
    }
    public static void disp(String[] matrix){
        for(String mat : matrix){
            System.out.print(mat);
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }
    public static void disp(String[][] matrix){
        for(String[] mat : matrix){
            System.out.print(Arrays.toString(mat));
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }
    public static void disp(int[][] matrix){
        for(int[] mat : matrix){
            System.out.print(Arrays.toString(mat));
            System.out.println();
        }
        System.out.println("-----------------------------------------------------");
    }
    public static int[][] coFactor(int[][] matrix,int row, int col){
        int n = matrix.length;
        int index = 0;
        int[][] coFact = new int[n-1][n-1];
        for(int i = 0;i< n;i++){
            int ind = 0;
            int[] newRow = new int[n-1];
            if(i != row) {
                for (int j = 0; j < n; j++) {
                    if (j != col){
                        newRow[ind] = matrix[i][j];
                        ind++;
                    }
                }
                coFact[index] = newRow;
                index++;
            }

        }
        return coFact;
    }
    public static String[][] coFactor(String[][] matrix,int row, int col){
        int n = matrix.length;
        int index = 0;
        String[][] coFact = new String[n-1][n-1];
        for(int i = 0;i< n;i++){
            int ind = 0;
            String[] newRow = new String[n-1];
            if(i != row) {
                for (int j = 0; j < n; j++) {
                    if (j != col){
                        newRow[ind] = matrix[i][j];
                        ind++;
                    }
                }
                coFact[index] = newRow;
                index++;
            }

        }
        return coFact;
    }
    public static int determinant(int[][] matrix){
        int determinant = 0;
        int sign = 1;
        if(matrix.length == 2){
            return ((matrix[0][0] * matrix[1][1])-(matrix[0][1] * matrix[1][0]));
        }
        else{
            //remember the sign
            for(int col = 0;col < matrix.length;col++){
                determinant += (sign * (matrix[0][col] * determinant(coFactor(matrix, 0, col))));
                sign = -sign;
            }
        }
        return determinant;
    }
    public static String[][] kMatrix(String[][] a, String[] b, int col){
        int len = a.length;
        String[][] kMat = new String[len][len];
        System.arraycopy(a,0,kMat,0,len);
        for(int i = 0;i<len;i++){
            String[] s = new String[len];
            System.arraycopy(a[i],0,s,0,len);
            s[col] = b[i];
            kMat[i] = s;
        }


        return kMat;
    }
    public static String determinant(String[][] matrix){
        String determinant = "0";
        String sign = "1";
        if(matrix.length == 2){
            return Complex.sub(Complex.product(matrix[0][0],matrix[1][1]),Complex.product(matrix[0][1],matrix[1][0]));
        }
        else{
            //remember the sign
            for(int col = 0;col < matrix.length;col++){
                String signMultiply = Complex.product(sign,matrix[0][col]);
                //Start Comment
                String detCFactor = determinant(coFactor(matrix, 0, col));
                String product = Complex.product(signMultiply,detCFactor);
                determinant = Complex.add(determinant,product);
                //End Comment
                //determinant = Complex.add(determinant,Complex.product(signMultiply,determinant(coFactor(matrix, 0, col))));
                sign = Complex.product("-1",sign);
            }
        }
        return determinant;
    }
    public static void kramer(String[][] a, String[] x, String[] col){
        String determinantA = determinant(a);
        if(a.length != x.length || a.length != col.length){
            System.out.println("Cannot solve with matrix of invalid length");
        }
        else{
            for(int i = 0;i<x.length;i++){
                String var = x[i];
                String[][] kMat = kMatrix(a,col, i);
                String detColSub = determinant(kMat);
                System.out.println(var + " = " + Complex.div(detColSub,determinantA));
            }
        }
    }
    public static void main(String[] args) throws ScriptException {
        int[] arr = {1,2};
        int[][] m = {{1,2},{3,4}};
        ScriptEngineManager mgt = new ScriptEngineManager();
        List<ScriptEngineFactory> list = mgt.getEngineFactories();
        int s = list.size();
        disp(m);
        System.out.println(Arrays.toString(arr));
        System.out.println(list);
        ScriptEngine engine = mgt.getEngineByName("nashorn");
        int[][] tr = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] fr = {{1,0,0,0},{1,2,0,0},{9,10,3,0},{133,14,15,4}};
        int[][] mat = {{1,2},{3,4}};
        String[] col1 = {"2-3j","-j"};
        String[] col2 = {"103.923+60j","0","-80"};
        String[] col3 = {"4+j","2","3-4j","7-49j"};
        String[] currents = {"I1","I2","I3","I4"};
        String[][] c1 = {{"j","2j"},{"2+j","4"}};
        String[][] c2 = {{"1+6j","5","2+4j"},{"-1","0","-j"},{"j","3+10j","2"}};
        String[][] c3 = {{"2+j","1","2"},{"-1","j-2","0"},{"0","3","2-j"}};
        String[][] c4 = {{"4+j","0","0","0"},{"0","5-j","0","0"},{"0","0","2","0"},{"0","0","0","-2-2j"}};
        String[][] circuit1 = {{"20+30j","-30j","0"},{"-30j","-130j","200j"},{"0","200j","10-180j"}};
        String[][] circuitry = kMatrix(circuit1, col2, 0);

        disp(mat);
        System.out.println("determinant is: "+determinant(mat));
        disp(tr);
        System.out.println("determinant is: "+determinant(tr));
        disp(c1);
        System.out.println("determinant is: "+determinant(c1));
        disp(c2);
        System.out.println("determinant is: "+determinant(c2));
        disp(c3);
        System.out.println("determinant is: "+determinant(c3));
        //disp(circuit1);
        //System.out.println("determinant of circuit1 is: "+determinant(circuit1));
        disp(circuitry);
        System.out.println("determinant of circuitry is: "+determinant(circuitry));
        disp(c4);
        System.out.println("determinant of c4 is: "+determinant(c4));
        disp(coFactor(circuitry,0,1));
        System.out.println("determinant of cF is: "+determinant(coFactor(circuitry,0,1)));
        disp(circuit1);
        disp(currents);
        disp(col2);
        kramer(circuit1,currents,col2);
        kramer(c4,currents,col3);
    }
}
