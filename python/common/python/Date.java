package python;
import java.util.ArrayList;
import java.util.List;

@org.python.Module(
        __doc__ = ""
)
public class Date extends org.python.types.Module {

    @org.python.Method(
            __doc__ = ""
    )
    public static org.python.Object today() {
		return new org.python.types.Str("tja");
    }

}
