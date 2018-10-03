package org.python.workloadjava;
import org.python.types.Int;
import org.python.types.List;

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

    public static void main(String args[]) {
        System.out.println("YAY");
        Workload.workloadAppend();
        Workload.workloadInsert();
        System.out.println("YAhiuyghY");
    }
}
