package org.python.stdlib.datetime;
import org.python.types.Int;
import org.python.types.Str;
import java.util.Calendar;

public class Date extends org.python.types.Object { 
    private org.python.types.Int year;
    private org.python.types.Int month;
    private org.python.types.Int day;
    
    @org.python.Method(
        __doc__ = "Time TODO",
        default_args = {"year","month","day"}
    )
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
		
		if(args[0] == null || args[1] == null || args[2] == null) throw new org.python.exceptions.TypeError("EEXEXEXEXCC");

        this.year = Int.getInt(1);
        this.month = Int.getInt(1);
        this.day = Int.getInt(1);

        if(args[0] != null) this.year = (Int) args[0];
        if(args[1] != null) this.month = (Int) args[1];
        if(args[2] != null) this.day = (Int) args[2];


		org.python.Object year_1 = this.year.__lt__(Int.getInt(0));
		org.python.Object year_2 = this.year.__gt__(Int.getInt(9999));
		org.python.Object year_condition = year_1.__or__(year_2);

		if(year_condition.value) {
			throw new org.python.exceptions.ValueError("gfgfgfgfgfgf");
		}
		// boolean monthCondition = (this.month < 0) || (this.month > 12);
		// boolean dayCondition = (this.month < 0) || (this.month > 12);





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

    @org.python.Method(
        __doc__ = "Return repr(self).",
        default_args = {"year","month","day"}
    )
    public org.python.types.Object replace(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {

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
        return this; 
    }

    @org.python.Method(
            __doc__ = "Return repr(self)."
    )
    public org.python.types.Str isoformat() {
        String year = this.year.toString();
        String month = this.month.toString();
        String day = this.day.toString();
        year = filler(year,4);
        month = filler(month,2);
        day = filler(day,2);

        //return this.year;
        return new org.python.types.Str(year+"-"+month+"-"+day);
    }

    private static String filler(String input, int target) {
        int len = input.toString().length();
        String output = input;
        for (int i = len; i<target; i++) {
           output = "0"+output;
        }
        return output;
    }

	@org.python.Method(
            __doc__ = "Return today"
    )
	public static org.python.types.Str today() {
		Calendar cal = Calendar.getInstance();

		int intMonth = cal.get(Calendar.MONTH);
		if( intMonth == 12) intMonth = 1;
		else intMonth++; 

		String year = filler(String.valueOf(cal.get(Calendar.YEAR)), 4);
		String month = filler(String.valueOf(intMonth), 2);
		String day = filler(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2);

		return new org.python.types.Str(year + "-" + month + "-" + day);
	}

    @org.python.Method(
            __doc__ = "Return repr(self)."
    )
    public org.python.types.Str __repr__() {
        return isoformat();
    }
}