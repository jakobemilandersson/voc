package python;
import java.util.ArrayList;
import java.util.List;

@org.python.Module(
        __doc__ =
                "OS routines for NT or Posix depending on what system we're on.\n" +
                        "\n" +
                        "This exports:\n" +
                        "  - all functions from posix, nt or ce, e.g. unlink, stat, etc.\n" +
                        "  - os.path is either posixpath or ntpath\n" +
                        "  - os.name is either 'posix', 'nt' or 'ce'.\n" +
                        "  - os.curdir is a string representing the current directory ('.' or ':')\n" +
                        "  - os.pardir is a string representing the parent directory ('..' or '::')\n" +
                        "  - os.sep is the (or a most common) pathname separator ('/' or ':' or '\\')\n" +
                        "  - os.extsep is the extension separator (always '.')\n" +
                        "  - os.altsep is the alternate pathname separator (None or '/')\n" +
                        "  - os.pathsep is the component separator used in $PATH etc\n" +
                        "  - os.linesep is the line separator in text files ('\r' or '\n' or '\r\n')\n" +
                        "  - os.defpath is the default search path for executables\n" +
                        "  - os.devnull is the file path of the null device ('/dev/null', etc.)\n" +
                        "\n" +
                        "Programs that import and use 'os' stand a better chance of being\n" +
                        "portable between different platforms.  Of course, they must then\n" +
                        "only use functions that are defined by all platforms (e.g., unlink\n" +
                        "and opendir), and leave all pathname manipulation to os.path\n" +
                        "(e.g., split and join).\n" +
                        "\n"
)
public class re extends org.python.types.Module {

    @org.python.Method(
            __doc__ = "Create and return a new object.  See help(type) for accurate signature."
    )
    public org.python.Object __new__(org.python.Object klass) {
        org.python.types.Type cls = (org.python.types.Type) super.__new__(klass);

        return cls;
    }


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
