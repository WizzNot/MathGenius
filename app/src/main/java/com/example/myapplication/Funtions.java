package com.example.myapplication;

import static android.support.constraint.Constraints.TAG;

import android.util.Log;
import android.widget.Toast;

public class Funtions {
    public static String[] answer(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            return new String[]{"all"};
        } else if (a == b && b == 0) {
            return new String[]{"none"};
        } else if ((a == c && c == 0) || (b == c && c == 0)) {
            return new String[]{"0"};
        } else if (b == 0) {
            return new String[]{Double.toString(Math.sqrt((-1 * c) / a)), Double.toString(-1 * Math.sqrt((-1 * c) / a))};
        } else if (c == 0) {
            return new String[]{Double.toString((double) -b / a), "0"};
        } else if (a == 0) {
            return new String[]{String.valueOf(c / b * -1)};
        } else {
            double d = (b * b) - (4 * a * c);
            if (d < 0) {
                return new String[]{"none"};
            } else if (d > 0) {
                return new String[]{String.valueOf(((-b - (Math.sqrt(d))) / (2 * a))), String.valueOf((((-b) + (Math.sqrt(d))) / (2 * a)))};
            }
            else {
                return new String[]{String.valueOf(-b / (2 * a))};
            }
        }
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void test(int z) {
        TestActivity.primer = "";
        int otv = 0;
        if (z == 1) {
            int count = getRandomNumber(2, 5);
            for (int i = 1; i <= count; i++) {
                Integer t = getRandomNumber(-100000, 100000) / 10;
                otv += t;
                if (t.toString().charAt(0) != '-') {
                    TestActivity.primer = TestActivity.primer + "+" + t.toString();
                } else {
                    TestActivity.primer = TestActivity.primer + t.toString();
                }
            }
            TestActivity.otv = new String[]{Double.toString((double) Math.round(otv))};
        } else if (z == 2) {
            boolean any = true;
            int a = 1, b = 1, c = 1;
            while (any) {
                any = false;
                a = getRandomNumber(-100, 100);
                b = getRandomNumber(-100, 100);
                c = getRandomNumber(-100, 100);
                ;
                for (String i : answer(a, b, c)) {
                    if (!(i.equals("all"))) {
                        if (i.equals("none")) {
                            any = true;
                        } else {
                            if ((!(Double.valueOf(i) >= -1000 && Double.valueOf(i) <= 1000) || ((b * b) - (4 * a * c)) < 0) || Double.valueOf(i) % 0.1 != 0) {
                                any = true;
                            }
                        }
                    }
                }
            }
            TestActivity.otv = new String[2];
            int k = 0;
            String bplus = b > 0 ? "+" : "-";
            String cplus = c > 0 ? "+" : "-";
            for (String i : answer(a, b, c)) {
                if (i.equals("all")) {
                    TestActivity.otv = new String[]{"любой"};
                } else {
                    TestActivity.otv[k] = i;
                }
                k++;
            }
            TestActivity.primer = Integer.toString(a) + "x²" + bplus + Integer.toString(Math.abs(b)) + "x" + cplus + Integer.toString(Math.abs(c));
        }
    }
    public static String[] answeruravn(String s)
    {
        double a=0, b=0, c=0;
        if(!s.contains("x^2")){
            a = 0;
            b = s.charAt(0)!='x'?Double.valueOf(s.substring(0, s.indexOf("x"))):1;
            c = s.length() > s.indexOf("x")?Double.valueOf(s.substring(s.indexOf("x") + 1, s.length())):0;
            Log.i(TAG, "answeruravn: " + a + " " + b + " " + c);
            return answer(a, b, c);
        }
        else{
            if(s.split("x").length == 2)
            {
                a = s.charAt(0) != 'x'?Double.valueOf(s.substring(0, s.indexOf("x^2"))):1;
                b = 0;
                c = s.length()>s.indexOf("x^2")?Double.valueOf(s.substring(s.indexOf("x^2") + 3, s.length())):0;
                Log.i(TAG, "answeruravn: " + a + " " + b + " " + c);
                return answer(a, b, c);
            }
            else if(s.split("x").length == 3)
            {
                a = s.charAt(0) != 'x'?Double.valueOf(s.substring(0, s.indexOf("x^2"))):1;
                b = s.charAt(s.lastIndexOf("x") - 1) != '+' && s.charAt(s.lastIndexOf("x") - 1) != '-'?Double.valueOf(s.substring(s.indexOf("x^2") + 3, s.lastIndexOf("x"))):s.charAt(s.lastIndexOf("x") - 1) == '-'?-1:1;
                c = s.length()>s.lastIndexOf("x")?Double.valueOf(s.substring(s.lastIndexOf("x") + 1, s.length())):0;
                Log.i(TAG, "answeruravn: " + a + " " + b + " " + c);
                return answer(a, b, c);
            }
            else {
                throw new NumberFormatException();
            }
        }
    }
}
