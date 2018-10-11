package org.python.workload;

import org.python.types.Int;
import org.python.types.List;
import org.python.types.Object;

public class Workload {
    private int size;
    public List l;
    public List l_;

    public Workload() {
        //size>500000 might crash program
        this.size = 500000;
        this.l = new List();
        this.l_ = new List();

        for(int i = 0; i < this.size; i++){
            this.l.append(Int.getInt(i));
            this.l_.append(Int.getInt(-i));
        }
    }

    public void extend(List l1, List l2) {
        for(int i = 0; i < 10; i++){
            l1.extend(l2);
        }
    }

    public void reverse(List l1, List l2){
        for(int i = 0; i<500;i++){
            l1.reverse();
            l2.reverse();
        }
    }

    public void ind(List l1) {
        for(int i = 1; i < 100; i++){
            l1.index(Int.getInt(this.size-i), Int.getInt(0), Int.getInt(this.size));
        }
    }

    public static void main(String args[]) {

        System.out.println("Started running workload functions");
        Workload w = new Workload();
        w.extend(w.l, w.l_);
        w.reverse(w.l,w.l_);
        w.ind(w.l);
        System.out.println("Finished!");

    }
}


