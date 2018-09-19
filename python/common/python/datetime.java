package python;
import java.util.ArrayList;
import java.util.List;

@org.python.Module(
        __doc__ = ""
)
public class Date extends org.python.types.Module {

    @org.python.Method(
            __doc__ = "",
            args = {"pattern"}
    )
    public static Date today(org.python.Object pattern) {
		return new Date();
    }

}
