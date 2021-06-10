package com.example.stream;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    static String[] arr_str = {"1","3","4","7","2","5","8","9","13","15","17","19","18","167","153"};
    static Integer[] arr_int = {1,3,4,7,2,5,8,9,15,17,19,18,167,153};

    static List<String> list_str = Arrays.asList(arr_str);
    static List<Integer> list_int = Arrays.asList(arr_int);


    public static void main(String[] args) {
//        System.out.println(null != null);

//        foreach();
//        find();
//        collect();
//        List<String> value;
//        while (list_str.size()>4){
//            value = list_str.subList(0, 4);
//
//            list_str = list_str.subList(4, list_str.size());
//        }
//        System.out.println("++++++++++++");
//        list_str.stream().forEach(System.out::println);
//        List<String> list = list_str.stream().skip(1).limit(5).collect(Collectors.toList());
//        System.out.println("skip：" + list);
        List<String> arr1 = new ArrayList<>();
        Integer i=0;
        while(i<5000000){
            arr1.add(i+"");
            i++;
        }


        long start = System.currentTimeMillis();
        long end = 0;
        System.out.println("start : " + start);
        end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println(end - start);


        System.out.println("----------------");

        List<String> arr2 = new ArrayList<>();
        Integer j=0;
        while(j<5000000){
            arr2.add(j+"");
            j++;
        }

        start = System.currentTimeMillis();
        System.out.println("start : " + start);
        List<List<String>> list = new ArrayList<>();
        List<String> value = new ArrayList<>();
        while (arr2.size()>4){
            value = arr2.subList(0, 4);
            arr2 = arr2.subList(4, arr2.size());
            list.add(value);
        }
        end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println(end - start);

    }

    /**
     * 筛选并创建新的list
     */
    private static void collect() {
        List<Object> collect = list_str.stream().filter(s -> s.length() >1 ).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

    private static void find() {
        System.out.println(list_str.stream().filter(s -> s.length() >1).findFirst().get());
        System.out.println(list_str.stream().filter(s -> s.length() >1).findAny().get());
        System.out.println(list_str.stream().anyMatch(s -> s.length() >1));
    }

    private static void foreach() {
        list_str.stream().forEach(System.out::println);
        System.out.println("-------");
        list_str.stream().filter(s -> s.length() >1).forEach(System.out::println);
    }


}
