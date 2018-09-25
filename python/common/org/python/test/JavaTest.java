package org.python.test;

import org.python.types.List;
import org.python.types.Int;
import org.python.types.Object;
import java.util.*;

import junit.framework.TestCase;

public class JavaTest extends TestCase {

    public void test_creation() {
        List x = new List();
        assertTrue(x.__len__() == Int.getInt(0));
        // org.python.types.Object g = Int.getInt(7);
        // org.python.types.Object h = Int.getInt(2);
        // x.__add__(g);
        // x.__add__(h);
        // boolean n = x.__contains__(g);
        // assertTrue(n == true);
    }
}
