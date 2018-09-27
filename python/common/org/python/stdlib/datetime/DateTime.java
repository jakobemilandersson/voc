package org.python.stdlib.datetime;

import java.text.ParseException;
import java.text.DateFormatSymbols;
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
import java.util.Locale;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.TimeZone;
import java.time.Instant;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.lang.Math;


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
    
    //tzinfo not yet implemented
    //@org.python.Attribute
    //private org.python.types.Str tzinfo;

    @org.python.Attribute
    private org.python.types.Int hashcode;

    @org.python.Method(__doc__ = "DateTime constructor",
        default_args = { "year", "month", "day" }
    )
    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();

        //Handle incompatible datatypes
        validateArgs(args);

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
        NumberFormat nfSix = new DecimalFormat("000000");
        NumberFormat nfFour = new DecimalFormat("0000");
        NumberFormat nfTwo = new DecimalFormat("00");
        
        String out = nfFour.format(this.year.value)	+"-"+ nfTwo.format(this.month.value)+"-"+
        nfTwo.format(this.day.value)+" "+nfTwo.format(this.hour.value)+":"+
        nfTwo.format(this.minute.value)+":"+nfTwo.format(this.second.value);
        
        if(this.microsecond.value>0)
            out = out+"."+nfSix.format(this.microsecond.value);
        
        return new org.python.types.Str(out);
    }
	
    @org.python.Method(
            __doc__ = "Return hour(self)."
    )
    public org.python.types.Int hour(){
        return this.hour;
    }
	
    @org.python.Method(
            __doc__ = "Return minute(self)."
    )
    public org.python.types.Int minute(){
        return this.minute;
    }

    @org.python.Method(
            __doc__ = "Construct a date from a POSIX timestamp.",
            args = {"timestamp"}
    )
    public static org.python.types.Str fromtimestamp(org.python.Object timestamp){
        validateArgs_timestamp(timestamp);
        
        //Algorithm taken from https://github.com/python/cpython/blob/master/Lib/datetime.py
        //Get integer and decimal parts of timestamp
        int a = (int)(((org.python.types.Float)timestamp.__float__()).value );
        double frac = ((org.python.types.Float)timestamp.__float__()).value - a;
        
        
        //microseconds
        long us = Math.round(frac*1e6);
        
        if (us >= 1000000){
            ((org.python.types.Float)timestamp.__float__()).value = ((org.python.types.Float)timestamp.__float__()).value+1;
            us = us-1000000;
        }
        else if (us < 0){
            ((org.python.types.Float)timestamp.__float__()).value = ((org.python.types.Float)timestamp.__float__()).value-1;
            us = us+1000000;
        }
        
        String x = ""+((org.python.types.Float)timestamp.__float__() );
        BigDecimal y = new BigDecimal(x);
        
        long nanoTimeStamp = (y.multiply(new BigDecimal(1e9))).longValue();
        
        Instant instant = Instant.ofEpochMilli(0);
        instant = instant.plusNanos(nanoTimeStamp);

        LocalDateTime ldt = LocalDateTime.ofInstant(instant, TimeZone.getDefault().toZoneId());
        
        org.python.types.Int year_= Int.getInt(ldt.getYear());
        org.python.types.Int month_ = Int.getInt(ldt.getMonthValue());
        org.python.types.Int day_ = Int.getInt(ldt.getDayOfMonth());
        org.python.types.Int hour_ = Int.getInt(ldt.getHour());
        org.python.types.Int minute_ = Int.getInt(ldt.getMinute());
        org.python.types.Int second_ = Int.getInt(ldt.getSecond());
        org.python.types.Int microsecond_ = Int.getInt(us);
        
        org.python.types.Object[] args_ = {year_, month_, day_, hour_, minute_, second_, microsecond_};
        
        Map kwargs_ = new HashMap();
        
        kwargs_.put("year", year_);
        kwargs_.put("month", month_);
        kwargs_.put("day", day_);
        kwargs_.put("hour", hour_);
        kwargs_.put("minute", minute_);
        kwargs_.put("second", second_);
        kwargs_.put("microsecond", microsecond_);
        
        DateTime dt = new DateTime(args_, kwargs_);
        
        return dt.__repr__();
    }

    /**
    * Verifies if a day is valid given the month and year of the same date.
    * Takes regard to if the specified year is a leapday.
    * Algorithm is derived from https://github.com/python/cpython/blob/master/Lib/datetime.py#L46
    * @param year	an integer representing the year of a date
    * @param month	an integer representing the month of a date
    * @param_day	an integer representing the day of a date
    * @return 		true if day is valid, otherwise false.
    */
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
    /**
    * Validates the arguments given to the constructor of DateTime.
    * @param args	A list of arguments. These should be equal the arguments of the constructor.
    * @return 		Nothing
    * @exception	TypeError on an object that is not an integer or boolean.
    */
    private static void validateArgs(org.python.Object[] args){
        for(int i = 0; i < args.length; i++){
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
        }
    }

    /**
    * Validates the argument given to the method fromtimestamp
    * @param args	An org.python.Object object. This should be equal to the argument of fromtimestamp.
    * @return 		Nothing
    * @exception	TypeError on an object that is not an integer, float or boolean.
    */
    private static void validateArgs_timestamp(org.python.Object arg){
        if(arg instanceof org.python.types.Str)
            throw new org.python.exceptions.TypeError("an integer is required (got type str)"); 
        if(arg instanceof org.python.types.List)
            throw new org.python.exceptions.TypeError("an integer is required (got type list)"); 
        if(arg instanceof org.python.types.Dict)
            throw new org.python.exceptions.TypeError("an integer is required (got type dict)"); 
        if(arg instanceof org.python.types.Complex)
            throw new org.python.exceptions.TypeError("can't convert complex to int"); 
    }
}
