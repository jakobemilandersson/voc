package python;
import java.lang.Math;

@org.python.Module(
        __doc__ = ""
)
public class calendar extends org.python.types.Module {

    @org.python.Method(
            __doc__ = "",
            args = {"x", "y"}
    )
    public static org.python.Object leapdays(org.python.Object x, org.python.Object y) {
        return org.python.types.Int.getInt((Math.floorDiv(((org.python.types.Int) y).value-1, org.python.types.Int.getInt(4).value) - 
        	Math.floorDiv(((org.python.types.Int) x).value-1, org.python.types.Int.getInt(4).value)) -
        	(Math.floorDiv(((org.python.types.Int) y).value-1, org.python.types.Int.getInt(100).value) - 
        	Math.floorDiv(((org.python.types.Int) x).value-1, org.python.types.Int.getInt(100).value)) +
        	(Math.floorDiv(((org.python.types.Int) y).value-1, org.python.types.Int.getInt(400).value) - 
        	Math.floorDiv(((org.python.types.Int) x).value-1, org.python.types.Int.getInt(400).value)));
   }
}
