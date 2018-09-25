package org.python.stdlib.datetime;
import java.text.ParseException;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.text.NumberFormat;
import java.text.DecimalFormat;
import org.python.types.Int;
import org.python.types.Str;
import org.python.types.Bool;
import org.python.types.List;
import org.python.types.NoneType;
import org.python.types.Object;
import org.python.exceptions.TypeError;
import java.util.Calendar;
import java.util.ArrayList;

public class DateTime extends org.python.types.Object {

    @org.python.Attribute
    private org.python.types.Int year;
	
	@org.python.Attribute
	private org.python.types.Int month;
	
	@org.python.Attribute
	private org.python.types.Int day;
	
	@org.python.Attribute
	private org.python.types.Int hour;
	
	@org.python.Attribute
	private org.python.types.Int minute;
	
	@org.python.Attribute
	private org.python.types.Int second;
	
	@org.python.Attribute
	private org.python.types.Int microsecond;
	
	@org.python.Attribute
	private org.python.types.Str tzinfo;
	
	@org.python.Attribute
	private org.python.types.Int fold;
	
      
	//self._tzinfo = tzinfo
    //self._hashcode = -1


    @org.python.Method(__doc__ = "DateTime constructor", default_args = { "year", "month", "day" })
    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
		
		this.hour = Int.getInt(0);
		this.minute = Int.getInt(0);
		this.second = Int.getInt(0);
		
		int nArgs = args.length;
		
		switch(nArgs){
			case 0: throw new org.python.exceptions.TypeError("Required argument 'year' (pos 1) not found");
		}
		
        if(args[0] != null) this.year = ((org.python.types.Int)args[0]);
        if(args[1] != null) this.month = ((org.python.types.Int)args[1]);
        if(args[2] != null) this.day = ((org.python.types.Int)args[2]);
		//if(args[3] != null) this.hour = (Int) args[3];
		//if(args[4] != null) this.minute = (Int) args[4];
		//if(args[5] != null) this.second = (Int) args[5];
		//if(args[6] != null) this.microsecond = (Int) args[6];
		//if(args[7] instanceof org.python.types.Str) this.tzinfo = (org.python.types.Str) args[7];
		//if(args[8] != null) this.fold = (Int) args[8];

     
    }
	
	@org.python.Method(
            __doc__ = "Return repr(self)."
    )
	public org.python.types.Str __repr__(){
		NumberFormat nfFour = new DecimalFormat("0000");
		NumberFormat nfTwo = new DecimalFormat("00");
		
		String out = nfFour.format(this.year.value)	+"-"+ nfTwo.format(this.month.value)+"-"+
		nfTwo.format(this.day.value)+" "+nfTwo.format(this.hour.value)+":"+
		nfTwo.format(this.minute.value)+":"+nfTwo.format(this.second.value);
		return new org.python.types.Str(out);
	}

   
}