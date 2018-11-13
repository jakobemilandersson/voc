package org.python.test;
import org.python.types.List;
import org.python.types.Int;

//import static sun.java2d.xr.XRUtils.None;

public class SortWorkload {
    List newList;
    public SortWorkload() {

    }

    // Appending elements to a list.
    public void start() {
        this.newList = new org.python.types.List();
        for (int i = 4000000; i > 0; i--) {
            newList.append(Int.getInt(i));
        }
    }

    //Sorts 'newList'.
    public void sorts() {
        newList.sort(null, null);
    }

    // Method for timing how long it takes to append elements to a list and sort it.
    public static void main(String[] args) {

        SortWorkload x = new SortWorkload();
        x.start();
        long startTime = System.currentTimeMillis();
        x.sorts();
        long endTime = System.currentTimeMillis();
        System.out.println("That took " + (endTime - startTime) + " milliseconds");
    }
}
