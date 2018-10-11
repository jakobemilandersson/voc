package org.python.workloadjava;
import org.python.types.Int;
import org.python.types.List;
import org.python.types.ListAlt;
import org.python.types.Object;

import java.util.concurrent.ThreadLocalRandom;

public class Workload {

    public static void workloadAppend() {
        ListAlt list = new ListAlt();

        for(int i = 0; i < 1000*1000*1; i++) {
            list.append(Int.getInt(i));
        }
    }

    public static void workloadInsert() {
        ListAlt list = new ListAlt();
        //List list = new List();

        for(int i = 0; i < 1000*1000*0.2; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, (1000*1000) + 1);

            list.insert(Int.getInt(randomNum), Int.getInt(i));
        }
    }

    // Change so that 'randList' is not used anymore, the code for populating
    // 'randList' are instead used directly on 'list'.
    // This makes the code less similar to the python implementation
    // but since the timer doesn't activate until after 'randList' in the
    // python implementation is populated, this should make actual workload
    // (num. of function-calls etc.) between the two implementations
    // more precise! And thus should make it easier to analyse the two
    // different implementations!
    //
    // THIS IS NOT FINAL, WE CAN ALWAYS CHANGE BACK! :)
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
        //Workload.workloadMix();
        //Workload.workloadAppend();
        Workload.workloadInsert();
        System.out.println("Workload functions finished!");
    }
}
