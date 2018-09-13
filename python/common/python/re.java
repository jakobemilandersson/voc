package python;
import java.util.ArrayList;
import java.util.List;

@org.python.Module(
        __doc__ = ""
)
public class re extends org.python.types.Module {

    @org.python.Method(
            __doc__ = "Get an environment variable, return None if it doesn't exist.\n" +
                      "The optional second argument can specify an alternate default.\n" +
                      "key, default and the result are str.",
            args = {"pattern"}
    )
    public static String escape(org.python.Object pattern) {
		String inputStr = String.valueOf(pattern);
		ArrayList<Character> retStr = new ArrayList<Character>();
		
		for(char c: inputStr.toCharArray()) {
			if(!(Character.isLetter(c) || Character.isDigit(c))){
				retStr.add('\\');
			}
			retStr.add(c);
		}

		StringBuilder builder = new StringBuilder(retStr.size());
		for(Character ch: retStr){
			builder.append(ch);
		}

		return builder.toString();
    }

}
