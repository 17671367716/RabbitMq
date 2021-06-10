package com.example.single;

public class Single {

    private static Single single;

    private Single(){}

    public static synchronized Single getSingle(){
        if(single == null ){
            single = new Single();
        }
        return single;
    }
}
