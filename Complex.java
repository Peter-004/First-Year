public class Complex {
    private double a;
    private double b;
    public Complex(double x, double y){
        a = x;
        b = y;
    }
    public Complex(int x, int y){
        a = x;
        b = y;
    }
    public static String power(String s,int index){
        String ans = s;
        for(int i = 1;i<index;i++){
            ans = product(ans,s);
        }
        return ans;
    }

    public void conjugate(){
        b = -b;
    }
    public double mag(){
        return Math.sqrt((a*a)+(b*b));
    }
    public Complex product(Complex delta){
        double e = (a * delta.a) - (b * delta.b);
        double f = (a * delta.b) + (b * delta.a);
        return new Complex( e, f);
    }
    public Complex div(Complex delta){
        double z = (delta.a*delta.a)+(delta.b*delta.b);
        double x = (a*delta.a) + (b*delta.b);
        double y = (b*delta.a) - (a*delta.b);
        return new Complex(x,y);
    }

    @Override
    public String toString() {
        String finalForm;
        if(a == 0)finalForm = String.format("%.2fi",b);
        else if(b == 0)finalForm = String.format("%.2f",a);
        else{
            if(b>0)finalForm = String.format("%.2f+%.2fi",a,b);
            else{
                finalForm = String.format("%.2f%.2fi",a,b);
            }
        }
        return finalForm;
    }
    public static String sub(String s, String t){
        String ans;
        double a = 0;double b = 0; double c = 0; double d = 0;
        int f = s.length();
        int g = t.length();
        String e = "";
        double h = 0;
        for(int i = 0;i<f;i++){
            char gForce = s.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) b = Double.valueOf(e + 1) * 1;
                else{
                    b = Double.valueOf(e);
                    e="";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(a == 0 && e.length()> 0){
                    a = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(a == 0){
            a = h;
        }
        //for the second complex number
        h = 0;
        e = "";
        for(int i = 0;i<g;i++){
            char gForce = t.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) d = Double.valueOf(e + 1) * 1;
                else{
                    d = Double.valueOf(e);
                    e = "";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(c == 0 && e.length()> 0){
                    c = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(c == 0){
            c = h;
        }
        double x = a-c;
        double y = b-d;
        if(y == 0)ans = String.format("%.2f",x);
        else if(x == 0)ans = String.format("%.2fi",y);
        else{
            if(y>0){
                ans = String.format("%.2f+%.2fi",x,y);
            }
            else{
                ans = String.format("%.2f%.2fi",x,y);
            }
        }
        return ans;
    }
    public static String add(String s, String t){
        String ans;
        double a = 0;double b = 0; double c = 0; double d = 0;
        int f = s.length();
        int g = t.length();
        String e = "";
        double h = 0;
        for(int i = 0;i<f;i++){
            char gForce = s.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) b = Double.valueOf(e + 1) * 1;
                else{
                    b = Double.valueOf(e);
                    e="";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                //if e is technically "0"
                if(a == 0 && e.length()> 0){
                    a = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(a == 0){
            a = h;
        }
        //for the second complex number
        h = 0;
        e = "";
        for(int i = 0;i<g;i++){
            char gForce = t.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                //doesn't allow 0i
                if(h == 0) d = Double.valueOf(e + 1) * 1;
                else{
                    d = Double.valueOf(e);
                    e = "";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(c == 0 && e.length()> 0){
                    c = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                //tackle decimal pt
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(c == 0){
            c = h;
        }
        double x = a+c;
        double y = b+d;
        if(y == 0)ans = String.format("%.2f",x);
        else if(x == 0)ans = String.format("%.2fi",y);
        else{
            if(y>0){
                ans = String.format("%.2f+%.2fi",x,y);
            }
            else{
                ans = String.format("%.2f%.2fi",x,y);
            }
        }
        return ans;
    }
    public static String div(String s, String t){
        String ans;
        double a = 0;double b = 0; double c = 0; double d = 0;
        int f = s.length();
        int g = t.length();
        String e = "";
        double h = 0;
        for(int i = 0;i<f;i++){
            char gForce = s.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) b = Double.valueOf(e + 1) * 1;
                else{
                    b = Double.valueOf(e);
                    e="";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(a == 0 && e.length()> 0){
                    a = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(a == 0){
            a = h;
        }
        //for the second complex number
        h = 0;
        e = "";
        for(int i = 0;i<g;i++){
            char gForce = t.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) d = Double.valueOf(e + 1) * 1;
                else{
                    d = Double.valueOf(e);
                    e = "";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(c == 0 && e.length()> 0){
                    c = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(c == 0){
            c = h;
        }
        double z = (c*c)+(d*d);
        double x = (a*c) + (b*d);
        double y = (b*c) - (a*d);
        x /= z;
        y /= z;
        if(y == 0)ans = String.format("%.2f",x);
        else if(x == 0)ans = String.format("%.2fi",y);
        else{
            if(y>0){
                ans = String.format("%.2f+%.2fi",x,y);
            }
            else{
                ans = String.format("%.2f%.2fi",x,y);
            }
        }
        return ans;
    }
    public static String product(String s, String t){
        String ans;
        double a = 0;double b = 0; double c = 0; double d = 0;
        int f = s.length();
        int g = t.length();
        String e = "";
        double h = 0;
        for(int i = 0;i<f;i++){
            char gForce = s.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) b = Double.valueOf(e + 1) * 1;
                else{
                    b = Double.valueOf(e);
                    e="";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(a == 0 && e.length()> 0){
                    a = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(a == 0){
            a = h;
        }
        //for the second complex number
        h = 0;
        e = "";
        for(int i = 0;i<g;i++){
            char gForce = t.charAt(i);
            if(gForce == 'i' || gForce == 'j' ){
                if(h == 0) d = Double.valueOf(e + 1) * 1;
                else{
                    d = Double.valueOf(e);
                    e = "";
                }
                h=0;
            }
            else if(gForce == '+' || gForce == '-'){
                if(c == 0 && e.length()> 0){
                    c = h;
                    e = String.valueOf(gForce);
                }
                else{
                    e += gForce;
                }
                h = 0;
            }
            else{
                e += gForce;
                h = Double.valueOf(e);
            }
        }
        if(c == 0){
            c = h;
        }
        double x = (a*c) - (b*d);
        double y = (a*d) + (b*c);
        if(y == 0)ans = String.format("%.2f",x);
        else if(x == 0)ans = String.format("%.2fi",y);
        //you can use the greatest length as the formatter for decimal places
        else{
            if(y>0){
                ans = String.format("%.2f+%.2fi",x,y);
            }
            else{
                ans = String.format("%.2f%.2fi",x,y);
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Complex t = new Complex(3, 4);
        Complex s = new Complex(3,-4);
        Complex u = new Complex(-4,-7);
        t.conjugate();
        System.out.println(s);
        System.out.println(u.mag());
        System.out.println(t.product(s));
        System.out.println(power("3+4j",3));
        System.out.println(product("3+4i","3+4i"));//-7+24i
        System.out.println(product("3+4i","3-4i"));//25
        System.out.println(product("i","3+4i"));//-4+3i
        System.out.println(product("-4i","3-4i"));//-16-12i
        System.out.println(product("1","j-2")+ ": j-2");//1
        System.out.println(product("0","10-180i")+ ": 0.00");
        System.out.println(product("-80","200")+ ": -16000");
        System.out.println(product("30i","16000.00i")+ ": -480000.00");
        System.out.println(product("120+66i","16600.00-1300.00i")+ ": 2077800.00+939600.00i");
        System.out.println(div("-i","-i") + ": 1");//1
        System.out.println(div("3+4i","3+4i") + ": 1");//1
        System.out.println(div("i","3+4i") + ": 0.16+0.12i");//0.16+0.12i
        System.out.println(div("-4i","3-4i") + ": 0.64-0.48i");//0.64-0.48i
        System.out.println(div("3-i",power("3+4i",2)) + ": -0.072-0.104i");//-0.072-0.104i
        System.out.println(div("1","j") + ": -i");//-i
        System.out.println(add("0","1+0.6j") + ": 1+0.6i");//-i
        System.out.println(add("0.00","16000.00") + ": 16000.00");
        System.out.println(add("2077800.00+939600.00i","480000.00i") + ": 16000.00");
        System.out.println(sub(product("0","10-180j"),product("-80","200j")) + ": 16000.00");
    }
}
