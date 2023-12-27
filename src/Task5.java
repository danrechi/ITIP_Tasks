import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        //1
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        //2
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("H3", "A4"));
        System.out.println(spiderVsFly("A4", "H4"));
        System.out.println(spiderVsFly("H2", "B2"));

        //3
        System.out.println(digitsCount(299));
        //4
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        //5
        System.out.println(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}));
        //6
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        //7
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "almost last task!", 4));
        //8
        System.out.println(setSetup(7,3));
        //9
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        //10
        System.out.println(isNew(1044));

    }
    //1
    public static boolean sameLetterPattern(String a, String b){
        if (a.length() != b.length()){return false;}
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        char[] frst = a.toCharArray();
        char[] scnd = b.toCharArray();
        for (int i = 1; i < frst.length;i++){
            first.add(frst[i-1]-frst[i]);
            second.add(scnd[i-1]-scnd[i]);
        }
        return first.equals(second);
    }
    //2
    public static String spiderVsFly(String spider, String fly) {
        char[] letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        //числовые координаты
        int x1 = spider.codePointAt(0);
        int x2 = spider.codePointAt(1);
        int y1 = fly.codePointAt(0);
        int y2 = fly.codePointAt(1);
        //если паук и муха в одном месте
        if (x1 == y1 && x2 == y2) {
            return fly;
        }
        //если паук в центре 48 - '0'
        if (x2 == 48) {
            x1 = y1;
        }
        int firstWay;
        int secondWay;
        //65 - 'A'
        if (x1 > y1) {//если паук левее
            firstWay = letters.length - (x1-65) + (y1-65);//вычисление пути по радиалам
            secondWay = x1-y1;
        } else {
            firstWay = y1 - x1;
            secondWay = letters.length - (y1-65) + (x1-65);
        }
        int minway = Math.min(firstWay, secondWay);
        //изменения номера коорд
        int numberDiff = (x2 - y2 >= 0 ? (x2 - y2 > 0 ? -1 : 0) : 1);//если муха выше двигаемся вверх -1, выше 1, 0
        //изменение буквы
        int wordDiff = (minway == secondWay) ? -1 : 1; //если true -1(по часовой) иначе против часовой
        //формируем новые координаты для следующего шага
        String toCenter = Character.toString((x1)) + Character.toString((x2-1));
        String newNumber = Character.toString(x1) + Character.toString((x2 + numberDiff));//коорд после движения по вертикали
        String newChar = (letters[(x1-65+wordDiff > 0 ? x1-65+wordDiff : x1-65+wordDiff + 8) % 8])
                + Character.toString(x2);//новая буквенная координата по радиалам %8 для того чтобы не вышел за пределы
        //Проверяем условия для продолжения движения паука
        if (minway >= 3 && minway <= 4) {
            //путь по радиалам длиннее 3 или 4 шага, двигаемся к центру
            return spider + "-" + spiderVsFly(toCenter, fly);
        } else {
            if (x2 > y2) {
                //муха ниже, двигаемся по вертикали
                return spider + "-" + spiderVsFly(newNumber, fly);
            } else {
                if (x1 != y1) {
                    //разные буквы, двигаемся по радиалу
                    return spider + "-" + spiderVsFly(newChar, fly);
                } else {
                    // двигаемся по вертикали
                    return spider + "-" + spiderVsFly(newNumber, fly);
                }
            }
        }
    }
    //3
    public static int digitsCount(long n) {
        if (n < 10) {
            return 1;
        }
        return 1 + digitsCount(n / 10);
    }
    //4
    public static int totalPoints(String[] words, String answer)
    {
        int dots = 0;
        int cntOfSix = 0;
        for (String word : words)
        {
            List<Character> chars = new ArrayList<Character>();
            for (int i = 0; i < answer.length();i++) {
                chars.add(answer.charAt(i));
            }

            int cnt = 0;
            boolean tracker = true;//отслеживание совпадений символа
            for (int j = 0; j < word.length(); j++)
            {
                if (chars.contains(word.charAt(j)))//есть/нет символ в слове
                {
                    cnt++;
                    chars.remove((Character)(word.charAt(j)));
                }
                else
                {
                    tracker = false;
                    break;
                }
            }
            if(tracker)
            {
                if(cnt == 3) dots+=1;
                if(cnt == 4) dots+=2;
                if(cnt == 5) dots+=3;
                if(cnt == 6) {
                    cntOfSix+=1;
                    dots+=4;
                }
                if(word.equals(answer)) {
                    dots +=cntOfSix*50;

                }
            }
        }
        return dots;
    }

    //5
    public static ArrayList<ArrayList<Integer>> sumsUp(int[] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            for (int key : map.keySet()) {
                if (key + num == 8) {
                    ArrayList<Integer> pair = new ArrayList<>();
                    pair.add(Math.min(key, num));
                    pair.add(Math.max(key, num));
                    res.add(pair);
                    map.remove(key);
                    break;
                }
            }
            map.put(num, 1);
        }

        return res;
    }

    //6
    public static String takeDownAverage(String[] eval){
        int sum = 0;
        for (int i = 0; i < eval.length; i++){
            sum += Integer.parseInt(eval[i].substring(0,eval[i].length()-1));
        }
        String res = "";
        for (int i = 0; i <= 100; i++){
            if((float)(sum + i)/(float)(eval.length + 1) == (float)(((sum)/eval.length) - 5)) {res =  i + "%";}
        }
        return res;
    }
    //7
    public static String caesarCipher(String work, String text, int cnt){
        text = text.toUpperCase();
        StringBuilder res = new StringBuilder();
        if (work == "encode"){
            for (int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                if (Character.isLetter(c)){
                    char after = (char) ((c - 'A' + cnt)%26+ 'A'); //%26 чтобы не уходить за пределы алфавита('Z'+1 = 'A')
                    //(...)%26 - вычисляем позицию новой буквы
                    res.append(after);
                }
                else {res.append(c);}
            }
        }
        else {
            for (int i = 0; i < text.length(); i++){
                char c = text.charAt(i);
                if (Character.isLetter(c)){
                    char after = (char) ((c - 'A' - cnt + 26)%26+ 'A');//+26 чтобы исключить отрицательного результата
                    res.append(after);
                }
                else {res.append(c);}
            }
        }
        return res.toString();
    }
    //8
    public static int factorial(int n)
    {
        if (n <= 1) {return 1;}
        else {return n * factorial(n - 1);}
    }
    public static int setSetup(int n, int k){
        return factorial(n)/factorial(n-k);
    }
    //9
    public static String timeDifference(String cityA, String stringDate, String cityB) {
        HashMap<String, TimeZone> timeZones = new HashMap<>();
        timeZones.put("Los Angeles", SimpleTimeZone.getTimeZone("GMT-8"));
        timeZones.put("New York", SimpleTimeZone.getTimeZone("GMT-5"));
        timeZones.put("Caracas", SimpleTimeZone.getTimeZone("GMT-4:30"));
        timeZones.put("Buenos Aires", SimpleTimeZone.getTimeZone("GMT-3"));
        timeZones.put("London", SimpleTimeZone.getTimeZone("GMT"));
        timeZones.put("Rome", SimpleTimeZone.getTimeZone("GMT+1"));
        timeZones.put("Moscow", SimpleTimeZone.getTimeZone("GMT+3"));
        timeZones.put("Tehran", SimpleTimeZone.getTimeZone("GMT+3:30"));
        timeZones.put("New Delhi", SimpleTimeZone.getTimeZone("GMT+5:30"));
        timeZones.put("Beijing", SimpleTimeZone.getTimeZone("GMT+8"));
        timeZones.put("Canberra", SimpleTimeZone.getTimeZone("GMT+10"));
        //формат для заданного
        SimpleDateFormat firstFormat = new SimpleDateFormat("MMMM d, yyyy H:m", Locale.US);
        firstFormat.setTimeZone(timeZones.get(cityA));
        //формат для итога
        SimpleDateFormat secondFormat = new SimpleDateFormat("yyyy-M-d HH:mm", Locale.US);
        secondFormat.setTimeZone(timeZones.get(cityB));
        try {
            return secondFormat.format(firstFormat.parse(stringDate));
        } catch (ParseException ignored) {
            return "error";
        }
    }


    //10
    public static boolean isNew(int num)
    {
        String str = String.valueOf(num);
        for(int i = 1; i < str.length(); i++)
        {
            if(!(str.charAt(i) == '0' && i==1) && str.charAt(i - 1) > str.charAt(i)) return false;
        }
        return true;
    }
}
