import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        System.out.println(nonRepeatable("abojoatitt"));//abojti
        System.out.println(generateBrackets(2));
        System.out.println(binarySystem(3));
        System.out.println(alphabetaicRow("abdjzyxwzyzyzy"));
        System.out.println(fifth("aaaabbbaaccvdd"));
        System.out.println(convertToNum("one thousand six hundred eleven"));
        System.out.println(uniqueSubstring("78997898"));
        int[][] a = new int[][]{{2,7,3},
                                {1,4,8},
                                {4,5,9}};
        System.out.println(shortestWay(a));
        System.out.println(numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(switchNums("519", "723"));
    }
    //1
    public static String nonRepeatable(String a) {
        if (a.length() <= 1) {
            return a;
        }
        String firstChar = ""+ a.charAt(0);
        String remaining = nonRepeatable(a.substring(1));
        remaining = remaining.replace(firstChar, "");
        return firstChar + remaining;
    }
    //2
    public static List<String> generateBrackets(int n) {
        List<String> combo = new ArrayList<String>();
        recurse(combo, 0, 0, "", n);
        return combo;
    }
    private static void recurse(List<String> combo, int left, int right, String a, int n) {
        if (left == n && right == n) {
            combo.add(a);
            return;
        }

        if (left < n) {
            recurse(combo, left + 1, right, a + "(", n);
        }

        if (right < left) {
            recurse(combo, left, right + 1, a + ")", n);
        }
    }
    //3
    public static List<String> binarySystem(int n) {
        List<String> combo = new ArrayList<>();
        generate(n, "", combo);
        return combo;
    }

    private static void generate(int n, String current, List<String> combo) {
        if (current.length() == n) {
            combo.add(current);
            return;
        }
        if (current.isEmpty() || current.charAt(current.length() - 1) != '0') {
            generate(n, current + "0", combo);
        }
        generate(n, current + "1", combo);
    }
    //4
    public static String alphabetaicRow(String a){
        if (a.isEmpty()){
            return "";
        }
        String maxForwardSequence = "";
        String maxBackwardSequence = "";
        String currentForwardSequence = Character.toString(a.charAt(0));
        String currentBackwardSequence = Character.toString(a.charAt(0));
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) == a.charAt(i - 1) + 1) {
                currentForwardSequence += a.charAt(i);
            }
            else {
                if (currentForwardSequence.length() > maxForwardSequence.length()) {
                    maxForwardSequence = currentForwardSequence;
                }
                currentForwardSequence = Character.toString(a.charAt(i));
            }

            if (a.charAt(i) == a.charAt(i - 1) - 1) {
                currentBackwardSequence += a.charAt(i);
            }
            else {
                if (currentBackwardSequence.length() > maxBackwardSequence.length()) {
                    maxBackwardSequence = currentBackwardSequence;
                }
                currentBackwardSequence = Character.toString(a.charAt(i));
            }
        }
        if (currentForwardSequence.length() > maxForwardSequence.length()) {
            maxForwardSequence = currentForwardSequence;
        }
        if (currentBackwardSequence.length() > maxBackwardSequence.length()) {
            maxBackwardSequence = currentBackwardSequence;
        }
        return (maxForwardSequence.length() >= maxBackwardSequence.length()) ? maxForwardSequence : maxBackwardSequence;
    }
    //5
    public static String fifth(String a){
        char[] chars = a.toCharArray();
        ArrayList<Character> vov = new ArrayList<>();
        ArrayList<Integer> cnts = new ArrayList<>();
        int cnt = 1;
        for (int i = 0; i<chars.length-1; i++){
            if (chars[i] == chars[i+1]){
                cnt++;
            }
            else {
                vov.add(chars[i]);
                cnts.add(cnt);
                cnt = 1;
            }
        }
        vov.add(chars[chars.length-1]);
        cnts.add(cnt);
        String[] replaceChars = new String[vov.size()];
        for (int i = 0; i<vov.size();i++){
            replaceChars[i] = vov.get(i) + cnts.get(i).toString();
        }
        //если результат положительный, то они меняются местами
        Arrays.sort(replaceChars, (str1, str2) -> str1.charAt(1) - str2.charAt(1));
        String res = "";
        for (int i = 0; i<replaceChars.length;i++ ){
            res +=replaceChars[i];
        }
        return res;
    }
    //6
    public static int convertToNum(String a) {
        String[] strNum = new String[]{
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        String[] tens = new String[]{
                "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        String[] vovs = a.split(" ");
        int result = 0;
        int currentNumber = 0;

        for (int j = 0; j < vovs.length; j++) {
            for (int i = 0; i < strNum.length; i++) {
                if (vovs[j].equals(strNum[i])) {
                    currentNumber += i;
                    break;
                }
            }
            for (int i = 2; i < tens.length; i++) {
                if (vovs[j].equals(tens[i])) {
                    currentNumber += i * 10;
                    break;
                }
            }
            if (vovs[j].equals("hundred")) {
                currentNumber *= 100;
            }
            if (vovs[j].equals("thousand")) {
                result += currentNumber * 1000;
                currentNumber = 0;
            }
        }

        result += currentNumber;
        return result;
    }

    //7
    public static String uniqueSubstring(String a) {
        int maxLength = 0;
        String maxSub = "";
        for (int i = 0; i < a.length(); i++) {
            String curSub = "";
            for (int j = i; j < a.length(); j++) {
                char currentChar = a.charAt(j);
                //indexof = -1 когда не найден такой символ в строке
                if (curSub.indexOf(currentChar) == -1) {
                    curSub += currentChar;
                }
                else {
                    break;
                }

                if (curSub.length() > maxLength) {
                    maxLength = curSub.length();
                    maxSub = curSub;
                }
            }
        }

        return maxSub;
    }
    //8
    public static int shortestWay(int[][] a){
        for (int i = 0; i < a.length; i++){
            for (int j = 0; j < a.length; j++){
                if (i == 0 && j == 0){
                    continue;
                }
                else if (i==0){
                    a[i][j] += a[i][j-1];
                }
                else if (j == 0){
                    a[i][j] += a[i-1][j];
                }
                else {
                    a[i][j]+=Math.min(a[i][j-1], a[i-1][j]);
                }
            }
        }
        return a[a.length-1][a.length-1];
    }
    //9
    public static String numericOrder(String a) {
        String[] words = a.split(" ");
        String[] res = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            int wordPlace = 0;
            String wordWithoutNumbers = "";
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (Character.isDigit(c)) {
                    wordPlace = (c - '0');
                } else {
                    wordWithoutNumbers += c;
                }
            }
            res[wordPlace - 1] = wordWithoutNumbers;
        }

        return String.join(" ", res);
    }
    //10
    public static String switchNums(String a, String b){
        char[] aNum = a.toCharArray();
        char[] bNum = b.toCharArray();
        Arrays.sort(aNum);
        int cnt = aNum.length-1;
        for (int i = 0; i < bNum.length; i++){
            if (cnt >= 0 && bNum[i]<aNum[cnt]){
                bNum[i] = aNum[cnt];
                cnt--;
            }
        }
        return String.valueOf(bNum);
    }
}
