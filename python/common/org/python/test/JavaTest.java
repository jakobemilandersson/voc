package org.python.test;
import org.junit.Assert;
import org.junit.Test;
import org.python.exceptions.IndexError;
import org.python.exceptions.TypeError;
import org.python.types.*;
import org.python.types.Object;

public class JavaTest {

    // ----------------- Erika and Daniel------------------

    @Test
    public void testCreation() {
        List x = new List();
        Assert.assertTrue(x.__len__() == Int.getInt(0));
    }

    @Test
    public void testAppend() {
        List x = new List();

        // Appending items
        Object firstInt = Int.getInt(7);
        Object secondInt = Int.getInt(2);
        x.append(firstInt);
        x.append(secondInt);
        Bool firstIntExist = (Bool) x.__contains__(firstInt);
        Assert.assertTrue(firstIntExist.value);

        // Testappending mixed types in list
        Str s = new Str("hello");
        x.append(s);
        Bool strInList = (Bool) x.__contains__(s);
        Assert.assertTrue(strInList.value && firstIntExist.value);
    }

    @Test
    public void testGetitem() {
        List x = new List();
        Object obj1 = new Str("some string");
        Object obj2 = new Str("another string");
        Object obj3 = new Str("again and again");
        Object obj4 = new Str("random stuff");

        x.append(obj1);
        x.append(obj2);
        x.append(obj3);
        x.append(obj4);

        Assert.assertEquals(((Str) x.__getitem__(Int.getInt(2))).value, "again and again");
    }

    @Test
    public void testSetitem() {
        // set object in list where another object exists
        List x1 = new List();
        x1.append(Int.getInt(1));
        x1.__setitem__(Int.getInt(0), Int.getInt(5));
        Assert.assertEquals(x1.__getitem__(Int.getInt(0)), Int.getInt(5));

    }

    @Test
    public void testSetitemDifferentTypes() {
        // set object in list where another object exists with different type.
        List x2 = new List();

        x2.append(Int.getInt(1));
        x2.append(Int.getInt(2));
        x2.append(Int.getInt(3));

        x2.__setitem__(Int.getInt(1), new Str("hello"));
        x2.__setitem__(Int.getInt(2), new Str("there"));
        Assert.assertTrue(
            x2.__getitem__(Int.getInt(0)) == Int.getInt(1) && ((Str) x2.__getitem__(Int.getInt(1))).value == "hello"
                && ((Str) x2.__getitem__(Int.getInt(2))).value == "there");
    }

    @Test(expected = IndexError.class)
    public void testSetItemOutOfBounds() {
        List x = new List();
        x.__setitem__(Int.getInt(0), Int.getInt(5));
    }

    @Test(expected = IndexError.class)
    public void testSetItemOutOfBoundsNegative() {
        // try to set item on negative index
        List x = new List();
        x.append(Int.getInt(1));
        x.__setitem__(Int.getInt(-2), Int.getInt(5));
    }

    @Test
    public void testSetItemBoolIndex() {
        List x = new List();
        x.append(Int.getInt(1));
        Object boolindx = Bool.getBool(false);
        x.__setitem__(boolindx, Int.getInt(123));
        Assert.assertTrue(x.__getitem__(Int.getInt(0)) == Int.getInt(123));
    }

    @Test
    public void testDelItem() {
        List x = new List();
        x.append(Int.getInt(5));
        x.__delitem__(Int.getInt(0));
        Assert.assertTrue(x.__len__() == Int.getInt(0));


        Object boolindx = Bool.getBool(false);
        x.append(Int.getInt(969));
        x.__delitem__(boolindx);
        Assert.assertTrue(x.__len__() == Int.getInt(0));
    }

    @Test(expected = IndexError.class)
    public void testDelItemNegOutOfRange() {
        List x = new List();
        x.append(Int.getInt((1)));
        x.append(Int.getInt((2)));
        x.append(Int.getInt((3)));
        x.__delitem__(Int.getInt(-4));
    }

    @Test
    public void testDelItemNegIndex() {
        List x = new List();
        x.append(Int.getInt((1)));
        x.append(Int.getInt((2)));
        x.append(Int.getInt((3)));

        x.__delitem__(Int.getInt(-2));

        Assert.assertTrue(x.__len__() == Int.getInt(2) &&
            ((Int) x.__getitem__(Int.getInt(0))).value == (Int.getInt(1)).value &&
            ((Int) x.__getitem__(Int.getInt(1))).value == (Int.getInt(3)).value);
    }

    @Test
    public void testDelItemPosOutOfRange() {
        List x = new List();
        x.append(Int.getInt((1)));
        x.append(Int.getInt((2)));
        x.append(Int.getInt((3)));
        x.__delitem__(Int.getInt(8));
    }

    @Test(expected = TypeError.class)
    public void testDelItemIndexWrongType() {
        List x = new List();
        x.append(Int.getInt((1)));
        x.append(Int.getInt((2)));
        x.append(Int.getInt((3)));
        x.__delitem__(new Str("one"));
    }

    // -------------------------------------------------------
    

    
    // --------- Adam, Tor and Jakob ---------------------------
    @Test
    public void testListContains() {
        List x = new List();
        x.append(Int.getInt(1));
        x.append(Int.getInt(2));
        Assert.assertEquals(x.__contains__(Int.getInt(1)), Bool.getBool(true));
    }

    @Test
    public void testListReverse() {
        List x = new List();
        x.append(Int.getInt(1));
        x.append(Int.getInt(2));
        List y = new List();
        y.append(Int.getInt(2));
        y.append(Int.getInt(1));
        x.reverse();
        Assert.assertEquals(x, y);
    }

    @Test
    public void testListCount() {
        List x = new List();
        x.append(Int.getInt(1));
        x.append(Int.getInt(1));
        x.append(Int.getInt(2));
        Assert.assertEquals(x.count(Int.getInt(1)), Int.getInt(2));
    }

    @Test
    public void testListExtendList() {
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

        Assert.assertEquals(original, validation);
    }

    @Test
    public void testListExtendRange() {
        List original = new List();
        original.append(Int.getInt(1));
        original.append(Int.getInt(2));
        original.append(Int.getInt(3));

        List validation = new List();
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));
        validation.append(Int.getInt(3));
        validation.append(Int.getInt(0));
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));
        validation.append(Int.getInt(3));
        validation.append(Int.getInt(4));

        Range toAdd = new Range(Int.getInt(5));

        original.extend(toAdd);

        Assert.assertEquals(original, validation);
    }

    @Test
    public void testListExtendNonIterable() {
        List original = new List();
        original.append(Int.getInt(1));
        original.append(Int.getInt(2));
        original.append(Int.getInt(3));

        List validation = new List();
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));
        validation.append(Int.getInt(3));
        validation.append(Int.getInt(4));

        Object toAdd = Int.getInt(4);

        try {
            original.extend(toAdd);
        } catch (org.python.exceptions.TypeError error) {
            // error.printStackTrace();
        }
    }

    @Test
    public void testListRemoveInteger() {
        List original = new List();
        original.append(Int.getInt(1));
        original.append(Int.getInt(2));
        original.append(Int.getInt(3));
        original.remove(Int.getInt(3));

        List validation = new List();
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));

        Assert.assertEquals(original, validation);
    }

    @Test
    public void testListRemoveFirstDuplicate() {
        List original = new List();
        original.append(Int.getInt(1));
        original.append(Int.getInt(2));
        original.append(Int.getInt(2));
        original.append(Int.getInt(3));
        original.append(Int.getInt(2));
        original.remove(Int.getInt(2));

        List validation = new List();
        validation.append(Int.getInt(1));
        validation.append(Int.getInt(2));
        validation.append(Int.getInt(3));
        validation.append(Int.getInt(2));

        Assert.assertEquals(original, validation);
    }
    @Test
    public void testListCopy() {
        List x = new List();
        x.append(Int.getInt(1));
        List y = (List) x.copy();
        Assert.assertEquals(x, y);
    }

    @Test
    public void testListRemoveBoolean() {
        List original = new List();
        original.append(Bool.getBool(true));
        original.append(Bool.getBool(false));
        original.append(Bool.getBool(true));
        original.append(Bool.getBool(false));
        original.remove(Bool.getBool(true));

        List validation = new List();
        validation.append(Bool.getBool(false));
        validation.append(Bool.getBool(true));
        validation.append(Bool.getBool(false));

        Assert.assertEquals(original, validation);
    }
    // -----------------------------------------------------------

    // --------- Daniel, Jakob and Henrik  - SPRINT 3-------------
    @Test
    public void testPowToLargeNum() {
        List x = new List();
        Int powerToInt = (Int) Int.getInt(1).__pow__(Int.getInt(1337), null);
        x.append(powerToInt);
        Assert.assertEquals(((Int) x.__getitem__(Int.getInt(0))).value, 1);
    }

    @Test
    public void testPowToSmallNum() {
        List x = new List();
        Int powerToInt = (Int) Int.getInt(1).__pow__(Int.getInt(3), null);
        x.append(powerToInt);
        Assert.assertEquals(((Int) x.__getitem__(Int.getInt(0))).value, 1);
    }
    // -----------------------------------------------------------


    // --------- Lucas and Henrik -------------------------------
    // ----------------------------------------------------------

}
