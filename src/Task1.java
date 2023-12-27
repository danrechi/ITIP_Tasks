
public class Task1 {
    public static void main(String[] args) {
        System.out.println(convert(8));
        System.out.println(fitCalc(41,3));
        System.out.println(containers(5,0,2));
        System.out.println(triangleType(4,4,4));
        System.out.println(ternaryEvaluation(11,12));
        System.out.println(howManyItems(22, 1.4f, 2));
        System.out.println(factorial(5));
        System.out.println(gcd(52,8));
        System.out.println(ticketSaler(70,1500));
        System.out.println(tables(40,20));

    }
    public static float convert(int x){
            return x*3.785f;
        }
    public static int fitCalc(int min, int intensive){
        return min*intensive;
    }
    public static int containers(int x, int y, int z){
        return x*20+y*50+z*100;
    }
    public static String triangleType(int a, int b, int c){
        if (a+b>c & c+b>a & a+c>b){
            if (a==b | b==c | c == a){
                if (a==b & b == c){return "equilateral";}
                else {return "isosceles";}
            }
            else {return "different-sides";}
        }
        else {return "not a tri";}
    }
    public static int ternaryEvaluation(int a, int b){
        return (a>b) ? a : b;
    }
    public static int howManyItems(int a, float b, float c){
        return (int)((a/2) / (b*c));
    }
    public static int factorial(int a){
        int fac = 1;
        for (int i = 1; i <= a; i++){
            fac = fac *i;
        }
        return fac;
    }
    public static int gcd(int a, int b){
        while(a!= b){
            if (a > b){
                a = a - b;
            }
            else {
                b = b - a;
            }
        }
        return a;
    }
    public static int ticketSaler(int a, int b){
        return a*b*72/100;
    }
    public static int tables(int a, int b){
        float c = (a - b*2)/2f+0.5f;
        return (c>0)?(int)c:0;
    }
}