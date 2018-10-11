package org.python.workloadjava;
import org.python.types.Int;
import org.python.types.List;

import java.util.concurrent.ThreadLocalRandom;

public class Workload {

    public static void workloadAppend() {
        List list = new List();

        for(int i = 0; i < 200000; i++) {
            Int powInt = (Int) Int.getInt(1).__pow__(Int.getInt(i), null);
            list.append(powInt);
        }
    }

    public static void workloadInsert() {
        List list = new List();

        for (int i = 0; i < 1000 * 1000 * 0.2; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, (1000 * 1000) + 1);
            list.insert(Int.getInt(randomNum), Int.getInt(i));
        }
    }

    public static void workloadMix() {
        List list = new List();
        for(int i = 0; i < (1000*1000)-1; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, (1000*1000) + 1);
            list.append(Int.getInt(randomNum));
        }
        list.append(Int.getInt(4222193));
        list.sort(null, null);
        Int ind = (Int)list.index(Int.getInt(4222193), null, null);
        list.pop(ind);
        list.insert(ind, Int.getInt(-1));
    }

    public static void main(String args[]) {
        System.out.println("Running workload functions...");
        Workload.workloadMix();
        Workload.workloadInsert();
        Workload.workloadAppend();
        System.out.println("Workload functions finished!");
    }
}
