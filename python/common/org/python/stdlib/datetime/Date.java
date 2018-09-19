package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Str;
import java.util.Calendar;

public class Date extends org.python.types.Object {
    private org.python.types.Int year;
    private org.python.types.Int month;
    private org.python.types.Int day;

    @org.python.Method(__doc__ = "Time TODO", default_args = { "year", "month", "day" })
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

        this.year = Int.getInt(1);
        this.month = Int.getInt(1);
        this.day = Int.getInt(1);

        if (args[0] != null)
            this.year = (Int) args[0];
        if (args[1] != null)
            this.month = (Int) args[1];
        if (args[2] != null)
            this.day = (Int) args[2];

        /*
         * TODO: Kolla så year/month/date </> sina resp.värden, kolla så ett visst datum
         * funkar en viss månad, kolla null/int.
         * 
         */

        // if(args[0] == null || args[1] == null || args[2] == null) throw new
        // org.python.exceptions.RuntimeError("EEXEXEXEXCC");

        // boolean yearCondition = (year < 0) || (year > 9999);
        // boolean monthCondition = (month < 0) || (month > 12);

        // if (this.year < Int.getInt(0) || this.year > Int.getInt(9999) || this.month <
        // Int.getInt(0) || this.month > Int.getInt(12) ) {
        // throw new org.python.exceptions.ValueError("too many values to unpack
        // (expected 2)");
        // }

        /*
         * org.python.Object yearKwargs = kwargs.get("year"); if (yearKwargs instanceof
         * org.python.types.Int) { this.year = (Int) yearKwargs; } org.python.Object
         * monthKwargs = kwargs.get("month"); if (monthKwargs instanceof
         * org.python.types.Int) { this.month = (Int) monthKwargs; } org.python.Object
         * dayKwargs = kwargs.get("day"); if (dayKwargs instanceof org.python.types.Int)
         * { this.day = (Int) dayKwargs; }
         */
        // this.year = (Int) args[0];
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
    // public static org.python.types.Str today() {
    public static org.python.types.Object today() {

        Calendar cal = Calendar.getInstance();

        int intMonth = cal.get(Calendar.MONTH);
        intMonth++;

        /*
         * String year = filler(String.valueOf(cal.get(Calendar.YEAR)), 4); String month
         * = filler(String.valueOf(intMonth), 2); String day =
         * filler(String.valueOf(cal.get(Calendar.DAY_OF_MONTH)), 2);
         */
        Int year = Int.getInt(cal.get(Calendar.YEAR));
        Int month = Int.getInt(intMonth);
        Int day = Int.getInt(cal.get(Calendar.DAY_OF_MONTH));

        org.python.stdlib.datetime.Date newDate = new org.python.stdlib.datetime.Date(year, month, day);

        // Måste returnera objektet ist för sträng... pga se python...
        return newDate;
        // return new org.python.types.Str(year + "-" + month + "-" + day);
    }

    @org.python.Method(__doc__ = "Return repr(self).")
    public org.python.types.Str __repr__() {
        return isoformat();
    }
}