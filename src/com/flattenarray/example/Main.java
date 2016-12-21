package com.flattenarray.example;

import java.util.ArrayList;

/**
 * Flatten an array of arbitrarily nested arrays of integers into a flat array of integers.
 * e.g. [[1,2,[3]],4] -> [1,2,3,4]. 
 */
public class Main {
    static Integer [] resultArray;
    public static void main(String[] argv){
        
        Object[] obj = new Object[2];
        makeSample(obj);
        ArrayList<Integer> list = new ArrayList<Integer>();
        newArray(obj, list);
        
        //print out new int array.
        System.out.println("Orignal array:[[1,2,[3]],4]");
        if(resultArray instanceof java.lang.Integer[]){ //resultArray.getClass().getTypeName().equals("java.lang.Integer[]")
            System.out.print("New Array=[");
            for(int i =0; i<resultArray.length;i++){
                System.out.print(resultArray[i]);
                if(i< resultArray.length-1 ) System.out.print(",");
            }
            System.out.print("]");
        }
    }
    
    static void makeSample(Object[] convertArray){
        //[[1,2,[3]],4]
        convertArray[0] = new Object[3];
        ((Object[]) convertArray[0])[0] = new Integer(1);
        ((Object[]) convertArray[0])[1] = new Integer(2);
        ((Object[]) convertArray[0])[2] = new Object[1];
        ((Object[])((Object[]) convertArray[0])[2])[0] = new Integer (3);
        convertArray[1] = new Integer(4);
    }
    
    static void makeSample2(Object[] convertArray){
        //[[1,2,[3]],4]
        convertArray[0] = new Object[3];
        ((Object[]) convertArray[0])[0] = new Integer(1);
        ((Object[]) convertArray[0])[1] = new Integer(2);
        ((Object[]) convertArray[0])[2] = new Object[1];
        ((Object[])((Object[]) convertArray[0])[2])[0] = new Integer (3);
        convertArray[1] = new Integer(4);
    }
    
    static Integer[] newArray(Object[] convertArray, ArrayList<Integer> list){
        for(Object obj: convertArray){
            if(obj instanceof java.lang.Object[]){ //obj.getClass().getTypeName().equals("java.lang.Object[]")
                newArray((Object[])obj,list);
            }else {
                list.add((Integer)obj);
            }
        }
        
        resultArray = new Integer[list.size()];
        list.toArray(resultArray);
        return resultArray;
    }
}
