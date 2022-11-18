package com.yc.converter;

import java.util.List;
import java.util.Arrays;

public class App {
    static List<String> uni = Arrays.asList("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X");
    static List<String> dec = Arrays.asList("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C");
    static List<String> hun = Arrays.asList("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M");
    public static void main(String[] args) {
        System.err.println(romanConverter(888));
        System.err.println(decimalConverter("DCCC", "LXXX", "VIII"));
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

    public static String decimalConverter(String hundred, String decimal, String unit) {
        String u, d, h;

        u = uni.indexOf(unit) + "";
        d = dec.indexOf(decimal) + "";
        h = hun.indexOf(hundred) + "";

        if (uni.indexOf(unit) ==-1) {
            u = "";
        }
        if (dec.indexOf(decimal) == -1) {
            d = "";
        }
        if (hun.indexOf(hundred) == -1) {
            h = "";
        }

        return (h+d+u);
    }
}
