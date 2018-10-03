package org.python.workloadjava;
import org.python.types.Int;
import org.python.types.List;
import org.python.types.Object;

import java.util.concurrent.ThreadLocalRandom;

public class Workload {

    public static void workloadAppend() {
        List list = new List();

        for(int i = 0; i < 1000*1000*1; i++) {
            list.append(Int.getInt(i));
        }
    }

    public static void workloadInsert() {
        List list = new List();

        for(int i = 0; i < 1000*1000*1; i++) {
            list.insert(Int.getInt(i), Int.getInt(i));
        }
    }

    public static void workloadMix() {
        List randList = new List();

        for(int i = 0; i < (1000*1000)-1; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, (1000*1000) + 1);
            randList.append(Int.getInt(randomNum));
        }

        randList.append(Int.getInt(4222193));

        List list = new List();
        for(int i = 0; i < 1000*1000; i++) {
            Int randInt = (Int)randList.__getitem__(Int.getInt(i));
            list.append(randInt);
        }

        list.sort(null, null);
        Int ind = (Int)list.index(Int.getInt(4222193), null, null);
        list.pop(ind);
        list.insert(ind, Int.getInt(-1));


    }

    public static void main(String args[]) {
        System.out.println("Running workload functions...");
        Workload.workloadMix();
        //Workload.workloadAppend();
        //Workload.workloadInsert();
        System.out.println("Workload functions finished!");
    }
}
