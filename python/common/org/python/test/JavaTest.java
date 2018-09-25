package org.python.test;

import org.python.types.List;
import org.python.types.Int;
import org.python.types.Object;
import org.python.types.Bool;
import org.python.types.Str;
import java.util.*;

import junit.framework.TestCase;

public class JavaTest extends TestCase {

    public void test_creation() {
        List x = new List();
        assertTrue(x.__len__() == Int.getInt(0));
    }

    public void test_append() {
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
}
