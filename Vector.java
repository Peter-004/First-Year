public class Vector {

    private int x;
    private int y;
    private int z;

    //If it is a two-dimensional vector, k = 0.
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
        return Math.sqrt(powSum);
    }

    public static Vector crossProduct(Vector a, Vector b){
        int arnold = (a.getY() * b.getZ()) - (a.getZ() * b.getY());
        int chris = -1 * ((a.getX() * b.getZ()) - (a.getZ() * b.getX()));
        int rock = (a.getX() * b.getY()) - (a.getY() * b.getX());
        Vector product = new Vector(arnold, chris, rock);
        return product;
    }

    public static int dotProduct(Vector a, Vector b){
        return ((a.getX() * b.getX()) + (a.getY() * b.getY()) + (a.getZ() * b.getZ()));
    }
    public static double angle(Vector a, Vector b){
        //MyMaths is my own subclass of the java.lang.Math . arcCos does the same function as acos, but returns the angle in degrees
        double theta = MyMaths.arcCos(((dotProduct(a,b)) / (mod(a) * mod(b))));
        return  theta;
    }
    public static void main(String[] args){
        //test the methods
    }
}
