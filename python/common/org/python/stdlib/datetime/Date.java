package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Str;
import org.python.types.Bool;
import java.util.Calendar;

public class Date extends org.python.types.Object {
    private org.python.types.Int year;
    private org.python.types.Int month;
    private org.python.types.Int day;

    @org.python.Method(__doc__ = "Time TODO", default_args = { "year", "month", "day" })
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

		if(args[0] == null || args[1] == null || args[2] == null) throw new org.python.exceptions.TypeError("EEXEXEXEXCC");

        this.year = Int.getInt(1);
        this.month = Int.getInt(1);
        this.day = Int.getInt(1);

        if(args[0] != null) this.year = (Int) args[0];
        if(args[1] != null) this.month = (Int) args[1];
        if(args[2] != null) this.day = (Int) args[2];

        if(this.year.value < 0 || this.year.value > 9999) throw new org.python.exceptions.ValueError("year " + this.year +" is out of range");
        
    }


    private Date(Int year, Int month, Int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @org.python.Method(__doc__ = "Return repr(self).", default_args = { "year", "month", "day" })
    public org.python.types.Object replace(org.python.Object[] args,
            java.util.Map<java.lang.String, org.python.Object> kwargs) {

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

    @org.python.Method(__doc__ = "Return repr(self).")
    public org.python.types.Str isoformat() {
        String year = this.year.toString();
        String month = this.month.toString();
        String day = this.day.toString();
        year = filler(year, 4);
        month = filler(month, 2);
        day = filler(day, 2);

        // return this.year;
        return new org.python.types.Str(year + "-" + month + "-" + day);
    }

    private static String filler(String input, int target) {
        int len = input.toString().length();
        String output = input;
        for (int i = len; i < target; i++) {
            output = "0" + output;
        }
        return output;
    }

    @org.python.Method(__doc__ = "Return today")
    public static org.python.types.Object today() {

        Calendar cal = Calendar.getInstance();

        int intMonth = cal.get(Calendar.MONTH);
        intMonth++;

        Int year = Int.getInt(cal.get(Calendar.YEAR));
        Int month = Int.getInt(intMonth);
        Int day = Int.getInt(cal.get(Calendar.DAY_OF_MONTH));

        org.python.stdlib.datetime.Date newDate = new org.python.stdlib.datetime.Date(year, month, day);

        return newDate;
    }

    @org.python.Method(__doc__ = "Return repr(self).")
    public org.python.types.Str __repr__() {
        return isoformat();
    }
}