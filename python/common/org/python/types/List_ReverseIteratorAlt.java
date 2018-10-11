package org.python.types;

class List_ReverseIteratorAlt extends ReverseIterator {
    public List_ReverseIteratorAlt(org.python.types.ListAlt list) {
        this.iterator = list.value.listIterator(list.value.size());
    }
}
