import java.util.*;

import static java.lang.Math.*;

public class Task3 {
    public static void main(String[] args){
        System.out.println(replaceVovels("EooodsaAs sdadAsOs"));
        System.out.println(stringTransform("hasanAAAookssafok"));
        System.out.println(doesBlockFit(1,3,5,4,5));
        System.out.println(numCheck(243));
        System.out.println(countRoots(new int[]{1,-6,9}));


        System.out.println(salesData(new String[][]{{"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop1","Shop2", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}}));
        //System.out.println("7---");
        System.out.println(validSplit("eagle apple egg goat"));
        //System.out.println(validSplit("ab aa aa ac"));
        System.out.println(waveForm(new int[]{3,1,4,2,7,5}));
        System.out.println(commonVovel("Hello world"));
        System.out.println(dataScience(new int[][]{{1,2,3,4,5},
                                {6,7,8,29,10},
                                {5,5,5,5,35},
                                {7,4,3,14,2},
                                {1,0,11,10,1}}));
    }
    public static String replaceVovels(String a){
        String[] vovels = new String[] {"a","e","i","o","u","y","A","E","I","O","U","Y"};
        for (int i = 0; i < vovels.length; i++){
            a = a.replace(vovels[i], "*");
        }
        return a;
    }
    public static String stringTransform(String a){
        a += " ";
        String res = "";
        for (int i = 0; i < a.length()-1; i++){
                if (a.charAt(i)==a.charAt(i+1)){
                    String str = ""+(a.charAt(i));
                    res += "Double" + str.toUpperCase();
                    i++;
                    continue;
                }
            res += a.charAt(i);
        }
        return res;
    }
    public static boolean doesBlockFit(int a, int b, int c, int w, int h){
        int[] arr = new int[]{a,b,c};
        int[] sides = new int[]{w,h};
        Arrays.sort(arr);
        Arrays.sort(sides);
        int min = arr[0];
        int mid = arr[1];
        int minSide = sides[0];
        int maxSide = sides[1];
        return minSide >= min & maxSide >= mid;
    }
    public static boolean numCheck(int a){
        int sum = 0;
        int num = a;
        while (a > 0){
            int digit = a % 10;
            sum += digit*digit;
            a = a / 10;
        }
        return (num % 2) == sum % 2;
    }
    public static int countRoots(int[] num){
        int a = num[0];
        int b = num[1];
        int c = num[2];
        int d = b*b - 4*a*c;
        if (d<0){
            return 0;
        }
        if (d == 0){
            float x = (float) -b / (2*a);
            if (x%1==0){return 1;}
            return 0;
        }
        else {
            float x1 = (-b - (float)sqrt(d))/(2*a);
            float x2 = (-b + (float)sqrt(d))/(2*a);
            if (x1 % 1 == 0){
                if (x2 % 1 == 0) {return 2;}
                return 1;
            }
            return 0;
        }
    }
    public static ArrayList<String> salesData(String[][] a){
        ArrayList<String> shops = new ArrayList<String>();
        for (int i = 0; i < a.length; i++){//kol-vo strok
            for (int j = 1; j<a[i].length;j++){//kol-vo elements
                shops.add(a[i][j]);
            }
        }
        Set<String> setShops = new HashSet<>(shops);
        ArrayList<String> productInAll = new ArrayList<String>();
        for (int k = 0; k<a.length; k++){
            if (setShops.size() == a[k].length-1){
                productInAll.add(a[k][0]);
            }
        }
        return productInAll;
            
    }
    public static boolean validSplit(String a){
        a = a.toLowerCase();
        String[] words = a.split(" ");
        char[] firstChar = new char[words.length];
        char[] lastChar = new char[words.length];

        for(int i = 0; i < words.length; i++)
        {
            firstChar[i] = words[i].charAt(0);
            lastChar[i] = words[i].charAt(words[i].length() - 1);
        }

        int cnt = 0;
        for(int i = 0; i < firstChar.length; i++)
        {
            for(int j = 0; j < firstChar.length; j++)
            {
                if(firstChar[i] == lastChar[j])
                {
                    lastChar[j] = ' ';
                    cnt++;
                    break;
                }
            }
        }
        return (cnt) == firstChar.length - 1;
    }
    public static boolean waveForm(int[] a){
        for (int i = 0; i < a.length-2; i++){
            if (!((a[i]-a[i+1] < 0 & a[i+1]-a[i+2]>0) | (a[i]-a[i+1] > 0 & a[i+1]-a[i+2]<0))){
                return false;
            }
        }
        return true;
    }
    public static String commonVovel(String a){
        String[] chars = new String[]{"a","e","i","o","u","y"};
        a = a.toLowerCase();
        String[] vovChar = a.replaceAll(" ","").split("");
        int[] cntChars = new int[]{0,0,0,0,0,0};
        int maxCnt = 0;
        String maxChar = "";
        for (int i = 0; i < vovChar.length; i++){ //for cnt
            for (int j = 0; j < chars.length; j++){ //for vov
                if (vovChar[i].equals(chars[j])){cntChars[j]++;}
            }
//            if (vovChar[i].equals("a")){cntChars[0]++;}
//            if (vovChar[i].equals("e")){cntChars[1]++;}
//            if (vovChar[i].equals("i")){cntChars[2]++;}
//            if (vovChar[i].equals("o")){cntChars[3]++;}
//            if (vovChar[i].equals("u")){cntChars[4]++;}
//            if (vovChar[i].equals("y")){cntChars[5]++;}
        }
        for (int i = 0; i< cntChars.length;i++){
            if (maxCnt < cntChars[i]){
                maxCnt = cntChars[i];
                maxChar = chars[i];
            }
        }
        return maxChar;
    }
    public static String dataScience(int[][] a){
        for (int i = 0; i<a.length;i++){
            int sum = 0;
            for (int j = 0; j<a.length;j++){
                sum+=a[j][i]; //столб - i, строка j
            }
            a[i][i] = round((sum - a[i][i])/(float)4);
        }
        return Arrays.deepToString(a);
    }
}

