import java.util.*;

public class Vector {

    private int x;
    private int y;
    private int z;

    public Vector(int i, int j, int k){
        x = i;
        y = j;
        z = k;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getZ(){
        return z;
    }

    @Override
    public String toString() {
        return String.format("%di %dj %dk", x,y,z);
    }

    public static double mod(Vector v){
        int i = v.getX();
        int j = v.getY();
        int k = v.getZ();
        int powSum = (i * i) + (j * j) + (k * k);
        double modulus = Math.sqrt(powSum);
        return modulus;
    }

    public static Vector crossProduct(Vector a, Vector b){
        int arnold;
        int chris;
        int rock;

        arnold = (a.getY() * b.getZ()) - (a.getZ() * b.getY());
        chris = -1 * ((a.getX() * b.getZ()) - (a.getZ() * b.getX()));
        rock = (a.getX() * b.getY()) - (a.getY() * b.getX());
        Vector product = new Vector(arnold, chris, rock);
        return product;
    }

    public static void main(String[] args){
        Vector hyp = new Vector(2, 3,4);
        Vector peep = new Vector(5,6,7);
        System.out.println(crossProduct(hyp, peep));
    }
}
