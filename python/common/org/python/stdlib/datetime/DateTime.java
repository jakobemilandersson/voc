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
import org.python.exceptions.OverflowError;
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
		String[] errors = {"function missing required argument 'year' (pos 1)",
		"function missing required argument 'month' (pos 2)",
		"function missing required argument 'day' (pos 3)"};
		
		//Default values
		this.hour = Int.getInt(0);
		this.minute = Int.getInt(0);
		this.second = Int.getInt(0);
		this.microsecond = Int.getInt(0);
		
		int nArgs = args.length;
		int currVal = 0;
		
		for(int i = 0; i < nArgs; i++){
			
			//Handle incompatible datatypes
			if(args[i] instanceof org.python.types.Str)
				throw new org.python.exceptions.TypeError("an integer is required (got type str)");
			if(args[i] instanceof org.python.types.List)
				throw new org.python.exceptions.TypeError("an integer is required (got type list)");
			if(args[i] instanceof org.python.types.Float)
				throw new org.python.exceptions.TypeError("an integer is required (got type float)");
			if(args[i] instanceof org.python.types.Dict)
				throw new org.python.exceptions.TypeError("an integer is required (got type dict)");
			if(args[i] instanceof org.python.types.Complex)
				throw new org.python.exceptions.TypeError("can't convert complex to int");
	
			if(args[i] instanceof org.python.types.Bool)
				args[i] = (org.python.types.Int)args[i].__int__();
			
			switch(i){
				case 0:
					if(args[i]==null) throw new org.python.exceptions.TypeError(errors[i]);
					
					currVal = (int)(((Int)args[i]).value);
					if(currVal>=1 && currVal<=9999) this.year = (org.python.types.Int)args[i];
					else throw new org.python.exceptions.ValueError("year is out of range");
					
					break;
				case 1:
					if(args[i]==null) throw new org.python.exceptions.TypeError(errors[i]);
					
					currVal = (int)(((Int)args[i]).value);
					if(currVal>=1 && currVal<=12) this.month = (org.python.types.Int)args[i];
					else throw new org.python.exceptions.ValueError("month must be in 1..12");
					
					break;
				case 2:
					if(args[i]==null) throw new org.python.exceptions.TypeError(errors[i]);
					
					currVal = (int)(((Int)args[i]).value);
					if(dayIsValid((int)this.year.value, (int)this.month.value, currVal)) this.day = (org.python.types.Int)args[i];
					else throw new org.python.exceptions.ValueError("day is out of range for month");
					
					break;
				case 3:
					this.hour = (org.python.types.Int)args[i];
					break;
				case 4:
					this.minute = (org.python.types.Int)args[i];
					break;
				case 5:
					this.second = (org.python.types.Int)args[i];
					break;
				case 6:
					this.microsecond = (org.python.types.Int)args[i];
					break;
			}
		}
     
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
	
	//https://github.com/python/cpython/blob/master/Lib/datetime.py#L46
	private boolean dayIsValid(int year, int month, int day){
		//Leap check
		boolean isLeap = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
		if(isLeap && month==2){
			if(day>=1 && day <= 29) return true;
		}
		
		int[] dim = {-1, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if(day>=1 && day <= dim[month]) return true;
		
		return false;
	}

   
}