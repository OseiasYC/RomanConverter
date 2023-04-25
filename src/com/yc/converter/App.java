package com.yc.converter;

import java.util.List;
import java.util.Arrays;

public class App {
    static List<String> uni = Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    static List<String> dec = Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");
    static List<String> hun = Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M");
    
    public static void main(String[] args) {
        System.err.println(romanConverter(888));
        System.err.println(romanToDecimal("MCMXCIV"));
    }

    public static String romanConverter(int num) {
        int u = num%10;
        int d = num/10;
        int h = num/100;
        
        if(d>11){
            d = d%10;
        }
        
        return(hun.get(h) + dec.get(d) + uni.get(u));
    }

    public static int value(char r)
    {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        if (r == 'D')
            return 500;
        if (r == 'M')
            return 1000;
        return -1;
    }

    public static int romanToDecimal(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));

            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));

                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }
}
