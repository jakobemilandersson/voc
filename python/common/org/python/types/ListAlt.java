package org.python.types;

import org.Python;

import java.util.Collections;
import java.util.Comparator;

public class ListAlt extends Object {
    public java.util.List<org.python.Object> value;

    public java.lang.Object toJava() {
        return this.value;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public org.python.Object __hash__() {
        throw new org.python.exceptions.AttributeError(this, "__hash__");
    }

    @Override
    public boolean isHashable() {
        return false;
    }

    public ListAlt() {
        super();
        this.value = new java.util.LinkedList<org.python.Object>();
    }

    public ListAlt(java.util.List<org.python.Object> list) {
        super();
        this.value = list;
    }

    @org.python.Method(__doc__ = "list() -> new empty list"
            + "list(iterable) -> new list initialized from iterable's items\n", default_args = { "iterable" })
    public ListAlt(org.python.Object[] args, java.util.Map<String, org.python.Object> kwargs) {
        super();
        if (args[0] == null) {
            this.value = new java.util.LinkedList<org.python.Object>();
        } else if (args.length == 1) {
            if (args[0] instanceof ListAlt) {
                this.value = new java.util.LinkedList<org.python.Object>(((ListAlt) args[0]).value);
            } else if (args[0] instanceof Set) {
                this.value = new java.util.LinkedList<org.python.Object>(((Set) args[0]).value);
            } else if (args[0] instanceof Tuple) {
                this.value = new java.util.LinkedList<org.python.Object>(((Tuple) args[0]).value);
            } else {
                org.python.Object iterator = Python.iter(args[0]);
                java.util.List<org.python.Object> generated = new java.util.LinkedList<org.python.Object>();
                try {
                    while (true) {
                        org.python.Object next = iterator.__next__();
                        generated.add(next);
                    }
                } catch (org.python.exceptions.StopIteration si) {
                }
                this.value = generated;
            }
        } else {
            throw new org.python.exceptions.TypeError("list() takes at most 1 argument (" + args.length + " given)");
        }
    }

    // public org.python.Object __new__() {
    // throw new org.python.exceptions.NotImplementedError("list.__new__() has not
    // been implemented.");
    // }

    // public org.python.Object __init__() {
    // throw new org.python.exceptions.NotImplementedError("list.__init__() has not
    // been implemented.");
    // }

    @org.python.Method(__doc__ = "Implement self+=value.", args = { "other" })
    public org.python.Object __iadd__(org.python.Object other) {
        if (other instanceof ListAlt) {
            this.value.addAll(((ListAlt) other).value);
        } else if (other instanceof Tuple) {
            this.value.addAll(((Tuple) other).value);
        } else if (other instanceof Set) {
            this.value.addAll(((Set) other).value);
        } else if (other instanceof FrozenSet) {
            this.value.addAll(((FrozenSet) other).value);
        } else if ((other instanceof Str) || (other instanceof Dict)
                || (other instanceof Range) || (other instanceof Bytes)
                || (other instanceof ByteArray)) {
            org.python.Object iter = null;
            if (other instanceof Str) {
                iter = ((Str) other).__iter__();
            } else if (other instanceof Dict) {
                iter = ((Dict) other).__iter__();
            } else if (other instanceof Range) {
                iter = ((Range) other).__iter__();
            } else if (other instanceof Bytes) {
                iter = ((Bytes) other).__iter__();
            } else if (other instanceof ByteArray) {
                iter = ((ByteArray) other).__iter__();
            }
            while (true) {
                try {
                    this.value.add(iter.__next__());
                } catch (org.python.exceptions.StopIteration ae) {
                    break;
                }
            }
        } else {
            throw new org.python.exceptions.TypeError(
                    String.format("'%s' object is not iterable", Python.typeName(other.getClass())));
        }
        return this;
    }

    @org.python.Method(__doc__ = "")
    public org.python.Object __bool__() {
        return Bool.getBool(!this.value.isEmpty());
    }

    @org.python.Method(__doc__ = "Return repr(self).")
    public Str __repr__() {
        StringBuilder buffer = new StringBuilder("[");
        boolean first = true;
        for (org.python.Object obj : this.value) {
            if (first) {
                first = false;
            } else {
                buffer.append(", ");
            }
            buffer.append(obj.__repr__());
        }
        buffer.append("]");
        return new Str(buffer.toString());
    }

    @org.python.Method(__doc__ = "default object formatter")
    public Str __format__() {
        throw new org.python.exceptions.NotImplementedError("list.__format__() has not been implemented.");
    }

    @org.python.Method(__doc__ = "Return self<value.", args = { "other" })
    public org.python.Object __lt__(org.python.Object other) {
        if (other instanceof ListAlt) {
            ListAlt otherList = (ListAlt) other;
            int size = this.value.size();
            int otherSize = otherList.value.size();
            int count = Math.min(size, otherSize);

            // check how many items are identical on the lists
            int i = 0;
            for (i = 0; i < count; i++) {
                Bool result = (Bool) Object
                        .__cmp_eq__(this.value.get(i), otherList.value.get(i));
                if (!result.value) {
                    break;
                }
            }

            // not all items were identical, result is that of the first non-identical item
            if (i < count) {
                return Object.__lt__(this.value.get(i), otherList.value.get(i));
            }

            // all items were identical, break tie by size
            return Bool.getBool(size < otherSize);
        } else {
            return NotImplementedType.NOT_IMPLEMENTED;
        }
    }

    @org.python.Method(__doc__ = "Return self<=value.", args = { "other" })
    public org.python.Object __le__(org.python.Object other) {
        if (other instanceof ListAlt) {
            ListAlt otherList = (ListAlt) other;
            int size = this.value.size();
            int otherSize = otherList.value.size();
            int count = Math.min(size, otherSize);

            // check how many items are identical on the lists
            int i = 0;
            for (i = 0; i < count; i++) {
                Bool result = (Bool) Object
                        .__cmp_eq__(this.value.get(i), otherList.value.get(i));
                if (!result.value) {
                    break;
                }
            }

            // not all items were identical, result is that of the first non-identical item
            if (i < count) {
                return Object.__le__(this.value.get(i), otherList.value.get(i));
            }

            // all items were identical, break tie by size
            return Bool.getBool(size <= otherSize);
        } else {
            return NotImplementedType.NOT_IMPLEMENTED;
        }
    }

    @org.python.Method(__doc__ = "Return self==value.", args = { "other" })
    public org.python.Object __eq__(org.python.Object other) {
        if (other instanceof ListAlt) {
            ListAlt otherList = (ListAlt) other;
            return Bool.getBool(this.value.equals(otherList.value));
        }
        return NotImplementedType.NOT_IMPLEMENTED;
    }

    @org.python.Method(__doc__ = "Return self>value.", args = { "other" })
    public org.python.Object __gt__(org.python.Object other) {
        if (other instanceof ListAlt) {
            ListAlt otherList = (ListAlt) other;
            int size = this.value.size();
            int otherSize = otherList.value.size();
            int count = Math.min(size, otherSize);

            // check how many items are identical on the lists
            int i = 0;
            for (i = 0; i < count; i++) {
                Bool result = (Bool) Object
                        .__cmp_eq__(this.value.get(i), otherList.value.get(i));
                if (!result.value) {
                    break;
                }
            }

            // not all items were identical, result is that of the first non-identical item
            if (i < count) {
                return Object.__gt__(this.value.get(i), otherList.value.get(i));
            }

            // all items were identical, break tie by size
            return Bool.getBool(size > otherSize);
        } else {
            return NotImplementedType.NOT_IMPLEMENTED;
        }
    }

    @org.python.Method(__doc__ = "Return self>=value.", args = { "other" })
    public org.python.Object __ge__(org.python.Object other) {
        if (other instanceof ListAlt) {
            ListAlt otherList = (ListAlt) other;
            int size = this.value.size();
            int otherSize = otherList.value.size();
            int count = Math.min(size, otherSize);

            // check how many items are identical on the lists
            int i = 0;
            for (i = 0; i < count; i++) {
                Bool result = (Bool) Object
                        .__cmp_eq__(this.value.get(i), otherList.value.get(i));
                if (!result.value) {
                    break;
                }
            }

            // not all items were identical, result is that of the first non-identical item
            if (i < count) {
                return Object.__ge__(this.value.get(i), otherList.value.get(i));
            }

            // all items were identical, break tie by size
            return Bool.getBool(size >= otherSize);
        } else {
            return NotImplementedType.NOT_IMPLEMENTED;
        }
    }

    public boolean __setattr_null(String name, org.python.Object value) {
        // Builtin types can't have attributes set on them.
        return false;
    }

    @org.python.Method(__doc__ = "Return len(self).")
    public Int __len__() {
        return Int.getInt(this.value.size());
    }

    @org.python.Method(__doc__ = "x.__getitem__(y) <==> x[y]", args = { "index" })
    public org.python.Object __getitem__(org.python.Object index) {
        try {
            if (index instanceof Slice) {
                Slice.ValidatedValue slice = ((Slice) index).validateValueTypes();
                java.util.List<org.python.Object> sliced = new java.util.LinkedList<org.python.Object>();

                if (slice.start == null && slice.stop == null && slice.step == null) {
                    sliced.addAll(this.value);
                } else {
                    long step;
                    if (slice.step != null) {
                        step = slice.step.value;
                    } else {
                        step = 1;
                    }

                    if (step < 0) {
                        long start;
                        if (slice.start != null) {
                            if (slice.start.value < 0) {
                                start = Math.max((this.value.size() + slice.start.value), -1);
                            } else {
                                start = Math.min(slice.start.value, this.value.size() - 1);
                            }
                        } else {
                            start = this.value.size() - 1;
                        }

                        long stop;
                        if (slice.stop != null) {
                            if (slice.stop.value < 0) {
                                stop = Math.max((this.value.size() + slice.stop.value), 0);
                            } else {
                                stop = Math.min(slice.stop.value, this.value.size());
                            }
                        } else {
                            stop = -1;
                        }
                        for (long i = start; i > stop; i += step) {
                            sliced.add(this.value.get((int) i));
                        }
                    } else {
                        long start;
                        if (slice.start != null) {
                            if (slice.start.value < 0) {
                                start = Math.max((this.value.size() + slice.start.value), 0);
                            } else {
                                start = Math.min(slice.start.value, this.value.size());
                            }
                        } else {
                            start = 0;
                        }

                        long stop;
                        if (slice.stop != null) {
                            if (slice.stop.value < 0) {
                                stop = Math.max((this.value.size() + slice.stop.value), 0);
                            } else {
                                stop = Math.min(slice.stop.value, this.value.size());
                            }
                        } else {
                            stop = this.value.size();
                        }
                        for (long i = start; i < stop; i += step) {
                            sliced.add(this.value.get((int) i));
                        }
                    }
                }
                return new ListAlt(sliced);
            } else {
                int idx;
                if (index instanceof Bool) {
                    idx = (int) ((Bool) index).__int__().value;
                } else {
                    idx = (int) ((Int) index).value;
                }
                if (idx < 0) {
                    if (-idx > this.value.size()) {
                        throw new org.python.exceptions.IndexError("list index out of range");
                    } else {
                        return this.value.get(this.value.size() + idx);
                    }
                } else {
                    if (idx >= this.value.size()) {
                        throw new org.python.exceptions.IndexError("list index out of range");
                    } else {
                        return this.value.get(idx);
                    }
                }
            }
        } catch (ClassCastException e) {
            if (Python.VERSION < 0x03050000) {
                throw new org.python.exceptions.TypeError("list indices must be integers, not " + index.typeName());
            } else {
                throw new org.python.exceptions.TypeError(
                        "list indices must be integers or slices, not " + index.typeName());
            }
        }
    }

    @org.python.Method(__doc__ = "Set self[key] to value.", args = { "index", "value" })
    public void __setitem__(org.python.Object index, org.python.Object value) {
        try {

            int idx;
            if (index instanceof Bool) {
                idx = (int) ((Bool) index).__int__().value;
            } else {
                idx = (int) ((Int) index).value;
            }
            if (idx < 0) {
                if (-idx > this.value.size()) {
                    throw new org.python.exceptions.IndexError("list assignment index out of range");
                } else {
                    this.value.set(this.value.size() + idx, value);
                }
            } else {
                if (idx >= this.value.size()) {
                    throw new org.python.exceptions.IndexError("list assignment index out of range");
                } else {
                    this.value.set(idx, value);
                }
            }
        } catch (ClassCastException e) {
            if (Python.VERSION < 0x03050000) {
                throw new org.python.exceptions.TypeError("list indices must be integers, not " + index.typeName());
            } else {
                throw new org.python.exceptions.TypeError(
                        "list indices must be integers or slices, not " + index.typeName());
            }
        }
    }

    @org.python.Method(__doc__ = "Delete self[key].", args = { "index" })
    public void __delitem__(org.python.Object index) {
        try {
            int idx;
            if (index instanceof Bool) {
                idx = (int) ((Bool) index).__int__().value;
            } else {
                idx = (int) ((Int) index).value;
            }
            if (idx < 0) {
                if (-idx > this.value.size()) {
                    throw new org.python.exceptions.IndexError("list index out of range");
                } else {
                    this.value.remove(this.value.size() + idx);
                }
            } else {
                if (idx >= this.value.size()) {
                    throw new org.python.exceptions.IndexError("list index out of range");
                } else {
                    this.value.remove(idx);
                }
            }
        } catch (ClassCastException e) {
            if (Python.VERSION < 0x03050000) {
                throw new org.python.exceptions.TypeError("list indices must be integers, not " + index.typeName());
            } else {
                throw new org.python.exceptions.TypeError(
                        "list indices must be integers or slices, not " + index.typeName());
            }
        }
    }

    @org.python.Method(__doc__ = "Implement iter(self).")
    public org.python.Object __iter__() {
        return new List_IteratorAlt(this);
    }

    @org.python.Method(__doc__ = "Reverse the list in place and returns\n"
            + "an iterator that iterates over all the objects\n" + "in the list in reverse order. Does not\n"
            + "modify the original list.")
    public org.python.Object __reversed__() {
        return new List_ReverseIteratorAlt(this);
    }

    @org.python.Method(__doc__ = "Return key in self.", args = { "item" })
    public org.python.Object __contains__(org.python.Object item) {
        boolean found = false;
        for (int i = 0; i < this.value.size(); i++) {
            if (((Bool) Object.__cmp_eq__(item, this.value.get(i))).value) {
                found = true;
                break;
            }
        }
        return Bool.getBool(found);
    }

    @org.python.Method(__doc__ = "Return self+value.", args = { "other" })
    public org.python.Object __add__(org.python.Object other) {
        if (other instanceof ListAlt) {
            ListAlt result = new ListAlt();
            result.value.addAll(this.value);
            result.value.addAll(((ListAlt) other).value);
            return result;
        } else {
            throw new org.python.exceptions.TypeError(
                    String.format("can only concatenate list (not \"%s\") to list", Python.typeName(other.getClass())));
        }
    }

    @org.python.Method(__doc__ = "Return self*value.n", args = { "other" })
    public org.python.Object __mul__(org.python.Object other) {
        if (other instanceof Int) {
            long count = ((Int) other).value;
            ListAlt result = new ListAlt();
            for (long i = 0; i < count; i++) {
                result.value.addAll(this.value);
            }
            return result;
        } else if (other instanceof Bool) {
            boolean count = ((Bool) other).value;
            ListAlt result = new ListAlt();
            if (count) {
                result.value.addAll(this.value);
            }
            return result;
        }
        throw new org.python.exceptions.TypeError(
                "can't multiply sequence by non-int of type '" + other.typeName() + "'");
    }

    @org.python.Method(__doc__ = "Implement self*=value.", args = { "other" })
    public org.python.Object __imul__(org.python.Object other) {
        if (other instanceof Int) {
            long count = ((Int) other).value;
            ListAlt result = new ListAlt();
            for (long i = 0; i < count; i++) {
                result.value.addAll(this.value);
            }
            return result;
        } else if (other instanceof Bool) {
            boolean bool = ((Bool) other).value;
            if (bool) {
                return this;
            } else {
                return new ListAlt();
            }
        } else {
            throw new org.python.exceptions.TypeError(
                    "can't multiply sequence by non-int of type '" + other.typeName() + "'");
        }
    }

    @org.python.Method(__doc__ = "Return self*value.", args = { "other" })
    public org.python.Object __rmul__(org.python.Object other) {
        throw new org.python.exceptions.NotImplementedError("list.__rmul__() has not been implemented.");
    }

    @org.python.Method(__doc__ = "L.append(object) -> None -- append object to end", args = { "item" })
    public org.python.Object append(org.python.Object item) {
        this.value.add(item);
        return NoneType.NONE;
    }

    @org.python.Method(__doc__ = "L.clear() -> None -- remove all items from L")
    public org.python.Object clear() {
        this.value.clear();
        return NoneType.NONE;
    }

    @org.python.Method(__doc__ = "L.copy() -> list -- a shallow copy of L")
    public org.python.Object copy() {
        return new ListAlt(new java.util.LinkedList<org.python.Object>(this.value));
    }

    @org.python.Method(__doc__ = "L.count(value) -> integer -- return number of occurrences of value", args = {
            "other" })
    public org.python.Object count(org.python.Object other) {
        int count = 0;
        for (int i = 0; i < this.value.size(); i++) {
            if (((Bool) Object.__cmp_eq__(other, this.value.get(i))).value) {
                count++;
            }
        }
        return Int.getInt(count);
    }

    @org.python.Method(__doc__ = "L.extend(iterable) -> None -- extend list by appending elements from the iterable", args = {
            "other" })
    public org.python.Object extend(org.python.Object other) {
        if (other instanceof ListAlt) {
            this.value.addAll(((ListAlt) other).value);
        } else if (other instanceof FrozenSet) {
            this.value.addAll(((FrozenSet) other).value);
        } else if (other instanceof Set) {
            this.value.addAll(((Set) other).value);
        } else if (other instanceof Tuple) {
            this.value.addAll(((Tuple) other).value);
        } else if (other instanceof Dict) {
            this.value.addAll(((Dict) other).value.keySet());
        } else if ((other instanceof Str) || (other instanceof Range)
                || (other instanceof Bytes) || (other instanceof ByteArray)
                || (other instanceof Iterator)) {
            org.python.Object iter = null;
            if (other instanceof Str) {
                iter = ((Str) other).__iter__();
            } else if (other instanceof Range) {
                iter = ((Range) other).__iter__();
            } else if (other instanceof Bytes) {
                iter = ((Bytes) other).__iter__();
            } else if (other instanceof ByteArray) {
                iter = ((ByteArray) other).__iter__();
            } else if (other instanceof Iterator) {
                iter = other;
            }
            while (true) {
                try {
                    this.value.add(iter.__next__());
                } catch (org.python.exceptions.StopIteration si) {
                    break;
                }
            }
        } else {
            throw new org.python.exceptions.TypeError("'" + other.typeName() + "' object is not iterable");
        }
        return NoneType.NONE;
    }

    private int toPositiveIndex(int index) {
        if (index < 0) {
            return this.value.size() + index;
        }
        return index;
    }

    @org.python.Method(__doc__ = "L.index(value, [start, [stop]]) -> integer -- return first index of value.\nRaises ValueError if the value is not present.", args = {
            "item" }, default_args = { "start", "end" })
    public org.python.Object index(org.python.Object item, org.python.Object start, org.python.Object end) {
        if (start != null && !(start instanceof Int)) {
            if (Python.VERSION < 0x03050000) {
                throw new org.python.exceptions.TypeError("list indices must be integers, not " + start.typeName());
            } else {
                throw new org.python.exceptions.TypeError(
                        "list indices must be integers or slices, not " + start.typeName());
            }
        }
        if (end != null && !(end instanceof Int)) {
            if (Python.VERSION < 0x03050000) {
                throw new org.python.exceptions.TypeError("list indices must be integers, not " + end.typeName());
            } else {
                throw new org.python.exceptions.TypeError(
                        "list indices must be integers or slices, not " + end.typeName());
            }
        }

        int iStart = 0, iEnd = this.value.size();
        if (end != null) {
            iEnd = toPositiveIndex(((Long) end.toJava()).intValue());
        }
        if (start != null) {
            iStart = toPositiveIndex(((Long) start.toJava()).intValue());
        }

        for (int i = iStart; i < Math.min(iEnd, this.value.size()); i++) {
            if (((Bool) Object.__cmp_eq__(item, this.value.get(i))).value) {
                return Int.getInt(i);
            }
        }
        throw new org.python.exceptions.ValueError(
                String.format("%d is not in list", ((Int) item).value));
    }

    @org.python.Method(__doc__ = "L.insert(index, value) -> None -- Insert an item at a given index.", args = { "index",
            "item" })
    public org.python.Object insert(org.python.Object index, org.python.Object item) {
        if (!(index instanceof Int)) {
            throw new org.python.exceptions.TypeError(
                    "'" + index.typeName() + "' object cannot be interpreted as an integer");
        }
        int posIndex = toPositiveIndex(((Long) index.toJava()).intValue());
        if (posIndex >= 0 && posIndex < this.value.size()) {
            this.value.add(posIndex, item);
        } else if (posIndex >= this.value.size()) {
            this.value.add(item);
        } else if (posIndex < 0) {
            this.value.add(0, item);
        }
        return NoneType.NONE;
    }

    @org.python.Method(__doc__ = "L.pop([index]) -> item -- remove and return item at index (default last).", default_args = {
            "item" })
    public org.python.Object pop(org.python.Object item) {
        int index = this.value.size() - 1;
        if (item != null) {
            index = ((Long) ((Int) item).toJava()).intValue();
            if (index < 0) {
                index = this.value.size() + index;
            }
        }
        if (this.value.isEmpty()) {
            throw new org.python.exceptions.IndexError("pop from empty list");
        } else if (index < 0 || index >= this.value.size()) {
            throw new org.python.exceptions.IndexError("pop index out of range");
        }
        return this.value.remove(index);
    }

    @org.python.Method(__doc__ = "L.remove(value) -> None -- remove first occurrence of value.\nRaises ValueError if the value is not present.", args = {
            "item" })
    public org.python.Object remove(org.python.Object item) {
        for (int i = 0; i < this.value.size(); i++) {
            if (((Bool) Object.__cmp_eq__(item, this.value.get(i))).value) {
                this.value.remove(i);
                return NoneType.NONE;
            }
        }
        throw new org.python.exceptions.ValueError("list.remove(x): x not in list");
    }

    @org.python.Method(__doc__ = "L.reverse() -> None -- reverse the elements of the L in place.")
    public org.python.Object reverse() {
        Collections.reverse(this.value);
        return NoneType.NONE;
    }

    @org.python.Method(__doc__ = "L.sort(key=None, reverse=False) -> None -- stable sort *IN PLACE*", args = {}, default_args = {
            "key", "reverse" })
    public org.python.Object sort(final org.python.Object key, org.python.Object reverse) {
        if (key == null && reverse == null) {
            Collections.sort(this.value);
        } else {
            // needs to be final in order to use inside the comparator
            final boolean shouldReverse = reverse == null ? false : ((Bool) reverse.__bool__()).value;

            Collections.sort(this.value, new Comparator<org.python.Object>() {
                @Override
                public int compare(org.python.Object o1, org.python.Object o2) {
                    org.python.Object val1 = o1;
                    org.python.Object val2 = o2;
                    if (key != null) {
                        val1 = ((Function) key).invoke(o1, null, null);
                        val2 = ((Function) key).invoke(o2, null, null);
                    }
                    return shouldReverse ? val2.compareTo(val1) : val1.compareTo(val2);
                }
            });
        }
        return NoneType.NONE;
    }

    @org.python.Method(__doc__ = "")
    public org.python.Object __round__(org.python.Object ndigits) {
        throw new org.python.exceptions.TypeError("type list doesn't define __round__ method");
    }
}
