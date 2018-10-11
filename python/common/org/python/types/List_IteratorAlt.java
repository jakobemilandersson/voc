package org.python.types;

class List_IteratorAlt extends Iterator {
    public List_IteratorAlt(ListAlt list) {
        this.iterator = list.value.iterator();
    }
}
