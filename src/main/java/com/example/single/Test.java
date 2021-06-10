package com.example.single;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {

        Single s1 = Single.getSingle();
        Single s2 = Single.getSingle();

//        System.out.println(s1==s2);

        String str0 = "";
        String str1 = "abc";
        String str2 = str1;
        String str3 = str1 + "";
        String str4 = str2 + "";
        String str5 = str1 + str0;
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str1==str4);
        System.out.println(str1==str5);
        System.out.println("----------");
        String str6 = new String("abc");
        String str7 = "abc";
        String str8 = "abc" + "";
        System.out.println(str1==str6);
        System.out.println(str1==str7);
        System.out.println(str1==str8);

    }

}
