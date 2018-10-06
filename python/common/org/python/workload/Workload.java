package org.python.workload;

import org.python.types.Int;
import org.python.types.List;
import org.python.types.Object;

public class Workload {
    public static void rev_ext(){
        int size = 1000000;

        List l = new List();
        List l_ = new List();

        for(int i = 0; i < size; i++){
            l.append(Int.getInt(i));
            l_.append(Int.getInt(-i));
        }

        l.reverse();
        l_.reverse();

        l.extend(l_);
    }
    
    public static void ind() {
        int size = 20000;

        List l = new List();

        for(int i = 0; i < size; i++)
            l.append(Int.getInt(i));

        for(int i = 0; i < size; i++)
            l.index(Int.getInt(i), Int.getInt(0), Int.getInt(size));
    }

    public static void main(String args[]) {

        System.out.println("Started running workload functions");
        Workload.rev_ext();
        Workload.ind();
        System.out.println("Finished!");

    }
}


