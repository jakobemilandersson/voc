package org.python.stdlib.datetime;
import java.text.ParseException;
import java.text.DateFormatSymbols;
import java.util.Locale;
import java.text.SimpleDateFormat;
import org.python.types.Int;
import org.python.types.Str;
import org.python.types.Bool;
import org.python.types.List;
import org.python.types.NoneType;
import org.python.types.Object;
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

        if(args[0] != null) this.year = (Int) args[0];
        if(args[1] != null) this.month = (Int) args[1];
        if(args[2] != null) this.day = (Int) args[2];
		//if(args[3] != null) this.hour = (Int) args[3];
		//if(args[4] != null) this.minute = (Int) args[4];
		//if(args[5] != null) this.second = (Int) args[5];
		//if(args[6] != null) this.microsecond = (Int) args[6];
		//if(args[7] instanceof org.python.types.Str) this.tzinfo = (org.python.types.Str) args[7];
		//if(args[8] != null) this.fold = (Int) args[8];
/*
        org.python.Object yearKwargs = kwargs.get("year");
        if (yearKwargs instanceof org.python.types.Int) {
            this.year = (Int) yearKwargs;
        } 
        org.python.Object monthKwargs = kwargs.get("month");
        if (monthKwargs instanceof org.python.types.Int) {
            this.month = (Int) monthKwargs;
        }
        org.python.Object dayKwargs = kwargs.get("day");
        if (dayKwargs instanceof org.python.types.Int) {
            this.day = (Int) dayKwargs;
        }
*/
//        this.year = (Int) args[0];        
    }

   
}