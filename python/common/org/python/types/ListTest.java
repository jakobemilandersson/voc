package org.python.types;

import org.junit.Test;
import org.python.exceptions.IndexError;
import org.python.exceptions.TypeError;

import static org.junit.Assert.*;

public class ListTest {
    @Test
    public void toJava() throws Exception {
    }

    /*@Test
    public void hashCode() throws Exception {
    }*/

    @Test
    public void __hash__() throws Exception {
    }

    @Test
    public void isHashable() throws Exception {
    }

    @Test
    public void __iadd__() throws Exception {
    }

    @Test
    public void __bool__() throws Exception {
    }

    @Test
    public void __repr__() throws Exception {
    }

    @Test
    public void __format__() throws Exception {
    }

    @Test
    public void __lt__() throws Exception {
    }

    @Test
    public void __le__() throws Exception {
    }

    @Test
    public void __eq__() throws Exception {
    }

    @Test
    public void __gt__() throws Exception {
    }

    @Test
    public void __ge__() throws Exception {
    }

    @Test
    public void __setattr_null() throws Exception {
    }

    @Test
    public void __len__() throws Exception {
    }

    @Test
    public void __getitem__() throws Exception {
        List x = new List();
        Object obj1 = new Str("some string");
        Object obj2 = new Str("another string");
        Object obj3 = new Str("again and again");
        Object obj4 = new Str("random stuff");

        x.append(obj1);
        x.append(obj2);
        x.append(obj3);
        x.append(obj4);

        assertEquals(((Str) x.__getitem__(Int.getInt(2))).value, "again and again");
    }

    @Test
    public void __setitem__() throws Exception {
        List x1 = new List();
        x1.append(Int.getInt(1));
        x1.__setitem__(Int.getInt(0), Int.getInt(5));
        assertEquals(x1.__getitem__(Int.getInt(0)), Int.getInt(5));

        List x2 = new List();

        x2.append(Int.getInt(1));
        x2.append(Int.getInt(2));
        x2.append(Int.getInt(3));

        x2.__setitem__(Int.getInt(1), new Str("hello"));
        x2.__setitem__(Int.getInt(2), new Str("there"));
        assertTrue(
                x2.__getitem__(Int.getInt(0)) == Int.getInt(1) && ((Str) x2.__getitem__(Int.getInt(1))).value == "hello"
                        && ((Str) x2.__getitem__(Int.getInt(2))).value == "there");

        List x = new List();
        try {
            x.__setitem__(Int.getInt(0), Int.getInt(5));
        } catch (IndexError e) {
        }

        List y = new List();
        y.append(Int.getInt(1));
        Object boolindx = Bool.getBool(false);
        y.__setitem__(boolindx, Int.getInt(123));
        assertTrue(y.__getitem__(Int.getInt(0)) == Int.getInt(123));
    }

    @Test
    public void __delitem__() throws Exception {
        List x = new List();
        x.append(Int.getInt(5));
        x.__delitem__(Int.getInt(0));
        assertTrue(x.__len__() == Int.getInt(0));

        Object boolindx = Bool.getBool(false);
        x.append(Int.getInt(969));
        x.__delitem__(boolindx);
        assertTrue(x.__len__() == Int.getInt(0));

        List y = new List();
        y.append(Int.getInt((1)));
        y.append(Int.getInt((2)));
        y.append(Int.getInt((3)));
        try {
            y.__delitem__(Int.getInt(-4));
        } catch (IndexError e) {
        }

        List z = new List();
        z.append(Int.getInt((1)));
        z.append(Int.getInt((2)));
        z.append(Int.getInt((3)));

        z.__delitem__(Int.getInt(-2));

        assertTrue(z.__len__() == Int.getInt(2) &&
                ((Int) z.__getitem__(Int.getInt(0))).value == (Int.getInt(1)).value &&
                ((Int) z.__getitem__(Int.getInt(1))).value == (Int.getInt(3)).value);

        List w = new List();
        w.append(Int.getInt((1)));
        w.append(Int.getInt((2)));
        w.append(Int.getInt((3)));
        try {
            w.__delitem__(Int.getInt(8));
        } catch (IndexError e) {
        }

        List v = new List();
        v.append(Int.getInt((1)));
        v.append(Int.getInt((2)));
        v.append(Int.getInt((3)));
        try {
            v.__delitem__(new Str("one"));
        } catch (TypeError e) {
        }

    }

    @Test
    public void __iter__() throws Exception {
    }

    @Test
    public void __reversed__() throws Exception {
    }

    @Test
    public void __contains__() throws Exception {
        List x = new List();
        x.append(Int.getInt(1));
        x.append(Int.getInt(2));
        assertEquals(x.__contains__(Int.getInt(1)), Bool.getBool(true));
    }

    @Test
    public void __add__() throws Exception {
    }

    @Test
    public void __mul__() throws Exception {
    }

    @Test
    public void __imul__() throws Exception {
    }

    @Test
    public void __rmul__() throws Exception {
    }

    @Test
    public void append() throws Exception {
        List x = new List();
        // Appending items
        Object firstInt = Int.getInt(7);
        Object secondInt = Int.getInt(2);
        x.append(firstInt);
        x.append(secondInt);
        Bool firstIntExist = (Bool) x.__contains__(firstInt);
        assertTrue(firstIntExist.value);

        // Testappending mixed types in list
        Str s = new Str("hello");
        x.append(s);
        Bool strInList = (Bool) x.__contains__(s);
        assertTrue(strInList.value && firstIntExist.value);
    }

    @Test
    public void clear() throws Exception {
        List x = new List();
        x.append(Int.getInt(1));
        x.clear();
        List y = new List();
        assertEquals(x, y);
    }

    @Test
    public void copy() throws Exception {
        List x = new List();
        x.append(Int.getInt(1));
        List y = (List) x.copy();
        assertEquals(x, y);
    }

    @Test
    public void count() throws Exception {
        List x = new List();
        x.append(Int.getInt(1));
        x.append(Int.getInt(1));
        x.append(Int.getInt(2));
        assertEquals(x.count(Int.getInt(1)), Int.getInt(2));
    }

    @Test
    public void extend() throws Exception {
        List original = new List();
        original.append(Int.getInt(1));
        original.append(Int.getInt(2));
        original.append(Int.getInt(3));

        List validation = new List();
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));
        validation.append(Int.getInt(3));
        validation.append(Int.getInt(4));
        validation.append(new Str("hello"));

        List elementsToAdd = new List();
        elementsToAdd.append(Int.getInt(4));
        elementsToAdd.append(new Str("hello"));

        original.extend(elementsToAdd);

        assertEquals(original, validation);

        List original2 = new List();
        original2.append(Int.getInt(1));
        original2.append(Int.getInt(2));
        original2.append(Int.getInt(3));

        List validation2 = new List();
        validation2.append(Int.getInt(1));
        validation2.append(Int.getInt(2));
        validation2.append(Int.getInt(3));
        validation2.append(Int.getInt(0));
        validation2.append(Int.getInt(1));
        validation2.append(Int.getInt(2));
        validation2.append(Int.getInt(3));
        validation2.append(Int.getInt(4));

        Range toAdd = new Range(Int.getInt(5));

        original2.extend(toAdd);

        assertEquals(original2, validation2);

        List original3 = new List();
        original3.append(Int.getInt(1));
        original3.append(Int.getInt(2));
        original3.append(Int.getInt(3));

        List validation3 = new List();
        validation3.append(Int.getInt(1));
        validation3.append(Int.getInt(2));
        validation3.append(Int.getInt(3));
        validation3.append(Int.getInt(4));

        Int toAdd2 = Int.getInt(4);

        original3.extend(toAdd2);

        assertEquals(original3, validation3);
    }

    @Test
    public void index() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void pop() throws Exception {
    }

    @Test
    public void remove() throws Exception {
        List original = new List();
        original.append(Int.getInt(1));
        original.append(Int.getInt(2));
        original.append(Int.getInt(3));
        original.remove(Int.getInt(3));

        List validation = new List();
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));


        assertEquals(original, validation);
    }

    @Test
    public void reverse() throws Exception {
        List x = new List();
        x.append(Int.getInt(1));
        x.append(Int.getInt(2));
        List y = new List();
        y.append(Int.getInt(2));
        y.append(Int.getInt(1));
        x.reverse();
        assertEquals(x, y);
    }

    @Test
    public void sort() throws Exception {
    }

    @Test
    public void __round__() throws Exception {
    }

}