import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        System.out.println(duplicateChars("oraOnge"));
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(differenceEvenOdd(new int[]{44,32,86,19}));
        System.out.println(equalToAvg(new int[]{1,2,3,4,5}));
        System.out.println(indexMult(new int[]{1,2,3,-5}));
        System.out.println(reverse("Hello world!"));
        System.out.println(Tribonacci(11));
        System.out.println(pseudoHash(10));
        System.out.println(botHelper("Hello, Help..., me"));
        System.out.println(isAnagram("eleven plus two","twelve plus one"));
    }

    public static boolean duplicateChars(String a){
        String str = a.toLowerCase();
        for (int i = 0; i < str.length(); i++){
            for (int j = i+1; j < str.length(); j++){
                if (str.charAt(i) == str.charAt(j)){return true;}
            }
        }
        return false;
    }
    public static String getInitials(String a){
        String[] sp = a.split(" ");
        return ""+sp[0].charAt(0)+sp[1].charAt(0);
    }
    public static int differenceEvenOdd(int[] a){
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i<a.length; i++){
            if (a[i] % 2 == 0){sumEven+=a[i];}
            else {sumOdd +=a[i];}
        }
        return Math.abs(sumEven - sumOdd);
    }
    public static boolean equalToAvg(int[] a){
        int sum = 0;
        float avg = 0;
        for (int i = 0; i < a.length; i++){
            sum+=a[i];
            avg = sum/(float)a.length;
        }
        for (int j = 0; j<a.length;j++){
            if (avg == a[j]){return true;}
        }
        return false;
    }
    public static String indexMult(int[] a){
        for (int i = 0; i<a.length; i++){
            a[i] = a[i]*i;
        }
        return Arrays.toString(a);
    }
    public static String reverse(String a){
        char[] chAr = a.toCharArray();
        String res = "";
        for (int i = a.length()-1; i >= 0; i--){
            res = res + chAr[i];
        }
        return res;
    }
    public static int Tribonacci(int a){
        int[] tri = new int[a];
        tri[0] = 0;
        tri[1] = 0;
        tri[2] = 1;
        for (int i=3; i < a; i++){
            tri[i] = tri[i-3]+tri[i-2]+tri[i-1];
        }
        return tri[a-1];
    }
    public static String pseudoHash(int a){
        Random r = new Random();
        String[] chars = new String[]{"a","b","c","d","f","e","1","6","7"};
        String res = "";
        for (int i = 0; i < a; i++){
            res += chars[r.nextInt(chars.length)];
        }
        return res;
    }
    public static String botHelper(String a){
        a = a.toLowerCase();
        a = a.replaceAll("\\pP", " ");
        String[] arr = a.split(" ");
        String word = "help";
        for (int i = 0; i < arr.length; i++){
            if (word.equals(arr[i])){return "Calling for a staff";}
        }
        return "Keep waiting";
    }

    public static boolean isAnagram(String a, String b){
        String[] frst = a.replaceAll(" ", "").split("");
        String[] scnd = b.replaceAll(" ","").split("");
        Arrays.sort(frst);
        Arrays.sort(scnd);
        return Arrays.equals(frst,scnd);
    }
}
