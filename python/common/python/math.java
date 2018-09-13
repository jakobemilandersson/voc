package python;

@org.python.Module(
        __doc__ =
                "This module provides various functions to do math."
)
public class math extends org.python.types.Module {
    public math() {
        super();
    }

    public static org.python.Object _STRUCT_TM_ITEMS;

    @org.python.Attribute
    public static org.python.Object __file__ = new org.python.types.Str("python/common/python/math.java");
    @org.python.Attribute
    public static org.python.Object __loader__ = org.python.types.NoneType.NONE;  // TODO
    @org.python.Attribute
    public static org.python.Object __name__ = new org.python.types.Str("math");
    @org.python.Attribute
    public static org.python.Object __package__ = new org.python.types.Str("");
    @org.python.Attribute
    public static org.python.Object __spec__ = org.python.types.NoneType.NONE;  // TODO
    //public static org.python.types.Int altzone;

    @org.python.Method(
            __doc__ = "",
            args = {"x"}
    )
    public static org.python.Object cos(org.python.Object x) {
        return new org.python.types.Float((float) Math.cos(((org.python.types.Int) x.__int__()).value));
    }
}
