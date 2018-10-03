package org.python.test;
import org.python.types.*;
import java.util.Scanner;

public class RemoveWorkload {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("new int");
        int a = Integer.parseInt(s.nextLine());
        long startTime = System.currentTimeMillis();
        org.python.types.List newList = new org.python.types.List();
        for (int i = 0; i < 1000000; i++) {
            newList.append(Int.getInt(i));
        }

        for (int i = 3000; i < 4000; i++) {
            newList.remove(Int.getInt(i));
        }

        for (int i = 100000; i < 100500; i++) {
            newList.remove(Int.getInt(i));
        }


        newList.remove(Int.getInt(32483));
        newList.remove(Int.getInt(0));
        newList.remove(Int.getInt(76435));
        newList.remove(Int.getInt(2454));
        newList.remove(Int.getInt(23));
        newList.remove(Int.getInt(987632));
        newList.remove(Int.getInt(34506));
        newList.remove(Int.getInt(5));
        newList.remove(Int.getInt(765));
        newList.remove(Int.getInt(8634));
        newList.remove(Int.getInt(764452));
        newList.remove(Int.getInt(77777));
        newList.remove(Int.getInt(102000));
        newList.remove(Int.getInt(87632));
        newList.remove(Int.getInt(999999));
        newList.remove(Int.getInt(8745));
        newList.remove(Int.getInt(555));
        newList.remove(Int.getInt(3));
        newList.remove(Int.getInt(6564));
        newList.remove(Int.getInt(32456));
        newList.remove(Int.getInt(75442));
        newList.remove(Int.getInt(999243));
        newList.remove(Int.getInt(123456));
        newList.remove(Int.getInt(987654));
        newList.remove(Int.getInt(333334));
        newList.remove(Int.getInt(2));
        newList.remove(Int.getInt(8765));
        newList.remove(Int.getInt(98));

        newList.clear();

        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}