package org.python.test;
import org.python.types.*;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//import static sun.java2d.xr.XRUtils.None;

public class SortWorkload {
    List newList;
    public SortWorkload() {

    }

    public void start() {


        this.newList = new org.python.types.List();
        for (int i = 4000000; i > 0; i--) {
            newList.append(Int.getInt(i));
        }
    }

    public void sorts() {
        newList.sort(null, null);
    }

    public static void main(String[] args) {

        SortWorkload x = new SortWorkload();
        x.start();
        long startTime = System.currentTimeMillis();
        x.sorts();
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
