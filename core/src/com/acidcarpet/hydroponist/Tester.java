package com.acidcarpet.hydroponist;

public class Tester {
    public static void main(String[] args){

        for(int i = 1; i<10000; i++){
            System.out.println("i:"+i+"-"+String.valueOf((double)i/(double)100)+"- - -"+Wrench.try_percent((double)i/(double)100));
        }


    }
}
