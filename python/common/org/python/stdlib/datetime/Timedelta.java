package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Str;
import org.python.types.Float;
import org.python.types.Tuple;
import org.python.types.Bool;

public class Timedelta extends org.python.types.Object {
    @org.python.Attribute
    private Int days;
    @org.python.Attribute
    private Int seconds;
    @org.python.Attribute
    private Int microseconds;
    @org.python.Attribute
    private Int hashcode;

    @org.python.Attribute
    public static final Timedelta min = new Timedelta(Int.getInt(-999999999));

    @org.python.Method(
        __doc__ = "Timedelta TODO",
        default_args = {"days", "seconds", "microseconds",
                "milliseconds", "minutes", "hours", "weeks"}
    )
    public Timedelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        // Final values, all integer.

        Int days = Int.getInt(0);
        Float fdays = new Float(0.0);
        Int seconds = Int.getInt(0);
        Float fseconds = new Float(0.0);
        Int microseconds = Int.getInt(0);
        Float fmicroseconds = new Float(0.0);
        Int milliseconds = Int.getInt(0);
        Float fmilliseconds = new Float(0.0);
        Int minutes = Int.getInt(0);
        Float fminutes = new Float(0.0);
        Int hours = Int.getInt(0);
        Float fhours = new Float(0.0);
        Int weeks = Int.getInt(0);
        Float fweeks = new Float(0.0);

        //default_args described in 'microseconds'
        long[] conversion = {86400000000L, 1000000L, 1L, 1000L, 60000000L, 3600000000L, 604800000000L};

        Int iVal = Int.getInt(0);
        Float fVal = new Float(0.0);
        Float rem = new Float(0.0);

        if(args.length > 0) {
          for(int i=0; i<args.length; i++) {
              if(args[i] instanceof Float) {
                iVal = (Int) args[i].__int__();
                fVal = (Float) args[i];

                rem = new Float(fVal.value - ((Float) iVal.__float__()).value);
                rem.value = Math.round(rem.value * 1000.0); 
              }

              switch(i) {
                case 0:
                  if(args[i] instanceof Int)
                    days = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    days = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    days = iVal;
                    microseconds = Int.getInt(Math.round((rem.value * conversion[i]/1000L)));
                  }
                  break;

                case 1:
                  if(args[i] instanceof Int)
                    seconds = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    seconds = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    seconds = iVal;
                    microseconds = Int.getInt(Math.round((rem.value * conversion[i]/1000L)));
                  }
                  break;

                case 2:
                  if(args[i] instanceof Int)
                    microseconds = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    microseconds = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    microseconds = iVal;
                  }
                  break;

                case 3:
                  if(args[i] instanceof Int)
                    milliseconds = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    milliseconds = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    milliseconds = iVal;
                    microseconds = Int.getInt(Math.round((rem.value * conversion[i]/1000L)));
                  }
                  break;

                case 4:
                  if(args[i] instanceof Int)
                    minutes = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    minutes = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    minutes = iVal;
                    microseconds = Int.getInt(Math.round((rem.value * conversion[i]/1000L)));
                  }
                  break;

                case 5:
                  if(args[i] instanceof Int)
                    hours = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    hours = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    hours = iVal;
                    microseconds = Int.getInt(Math.round((rem.value * conversion[i]/1000L)));
                  }
                  break;

                case 6:
                  if(args[i] instanceof Int)
                    weeks = (Int) args[i];
                  else if(args[i] instanceof Bool)
                    weeks = ((Int) args[i].__int__());
                  else if(args[i] instanceof Float) {
                    weeks = iVal;
                    microseconds = Int.getInt(Math.round((rem.value * conversion[i]/1000L)));
                  }
                  break;
              }
          }
        }

        // region ==== PARSING ====

        org.python.Object daysKwargs = kwargs.get("days");

        if (daysKwargs instanceof org.python.types.Int) {
            days = (Int) daysKwargs;
        }
        else if (daysKwargs instanceof Float) {
            fdays = (Float) daysKwargs;
            days = (Int) daysKwargs.__int__();
            fdays.value -= ((Float) days.__float__()).value;
            fdays.value = Math.round(fdays.value * 1000.0);
            microseconds = Int.getInt(Math.round((long) (fdays.value * conversion[0]/1000)));
        }
        else if (daysKwargs instanceof Bool){
            days = ((Int) daysKwargs.__int__());
        }

        org.python.Object secondsKwargs = kwargs.get("seconds");
        if (secondsKwargs instanceof org.python.types.Int) {
            seconds = (Int) secondsKwargs;
        }
        else if (secondsKwargs instanceof Float) {
          fseconds = (Float) secondsKwargs;
          seconds = (Int) secondsKwargs.__int__();
          fseconds.value -= ((Float) seconds.__float__()).value;
          fseconds.value = Math.round(fseconds.value * 1000.0);
          microseconds = Int.getInt(Math.round((long) (fseconds.value * conversion[1]/1000)));
        }
        else if (secondsKwargs instanceof Bool){
            seconds = ((Int) secondsKwargs.__int__());
        }

        org.python.Object microsecondsKwargs = kwargs.get("microseconds");
        if (microsecondsKwargs instanceof org.python.types.Int) {
            microseconds = (Int) microsecondsKwargs;
        }
        else if (microsecondsKwargs instanceof Float) {
            microseconds =  Int.getInt(((Int) microsecondsKwargs.__int__()).value);
        }
        else if (microsecondsKwargs instanceof Bool){
            microseconds = ((Int) microsecondsKwargs.__int__());
        }

        org.python.Object millisecondsKwargs = kwargs.get("milliseconds");
        if (millisecondsKwargs instanceof org.python.types.Int) {
            milliseconds = (Int) millisecondsKwargs;
        }
        else if (millisecondsKwargs instanceof Float) {
          fmilliseconds = (Float) millisecondsKwargs;
          milliseconds = (Int) millisecondsKwargs.__int__();
          fmilliseconds.value -= ((Float) milliseconds.__float__()).value;
          fmilliseconds.value = Math.round(fmilliseconds.value * 1000.0);
          microseconds = Int.getInt(Math.round((long) (fmilliseconds.value * conversion[3]/1000)));
        }
        else if (millisecondsKwargs instanceof Bool){
          milliseconds = ((Int) millisecondsKwargs.__int__());
        }

        org.python.Object minutesKwargs = kwargs.get("minutes");
        if (minutesKwargs instanceof org.python.types.Int) {
            minutes = (Int) minutesKwargs;
        }
        else if (minutesKwargs instanceof Float) {
          fminutes = (Float) minutesKwargs;
          minutes = (Int) minutesKwargs.__int__();
          fminutes.value -= ((Float) minutes.__float__()).value;
          fminutes.value = Math.round(fminutes.value * 1000.0);
          microseconds = Int.getInt(Math.round((long) (fminutes.value * conversion[4]/1000)));
        }
        else if (minutesKwargs instanceof Bool){
          minutes = ((Int) minutesKwargs.__int__());
        }

        org.python.Object hoursKwargs = kwargs.get("hours");
        if (hoursKwargs instanceof org.python.types.Int) {
            hours = (Int) hoursKwargs;
        }
        else if (hoursKwargs instanceof Float) {
          fhours = (Float) hoursKwargs;
          hours = (Int) hoursKwargs.__int__();
          fhours.value -= ((Float) hours.__float__()).value;
          fhours.value = Math.round(fhours.value * 1000.0);
          microseconds = Int.getInt(Math.round((long) (fhours.value * conversion[5]/1000)));
        }
        else if (hoursKwargs instanceof Bool){
          hours = ((Int) hoursKwargs.__int__());
        }

        org.python.Object weeksKwargs = kwargs.get("weeks");
        if (weeksKwargs instanceof org.python.types.Int) {
            weeks = (Int) weeksKwargs;
        }
        else if (weeksKwargs instanceof Float) {
          fweeks = (Float) weeksKwargs;
          weeks = (Int) weeksKwargs.__int__();
          fweeks.value -= ((Float) weeks.__float__()).value;
          fweeks.value = Math.round(fweeks.value * 1000.0);
          microseconds = Int.getInt(Math.round((long) (fweeks.value * conversion[6]/1000)));
        }
        else if (weeksKwargs instanceof Bool){
          weeks = ((Int) weeksKwargs.__int__());
        }

        // endregion

        // Normalize everything to days, seconds, microseconds.
        days = Int.getInt(days.value + (weeks.value * 7));
        seconds = Int.getInt(seconds.value + (minutes.value * 60 + hours.value * 3600));
        microseconds = Int.getInt(microseconds.value + (milliseconds.value * 1000));
        //microseconds.value += (fdays.value * 24*60*60*1000000);

        seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
        microseconds = Int.getInt(microseconds.value % 1000000);

        days = Int.getInt(days.value + seconds.value / (24*3600));
        seconds = Int.getInt(seconds.value % (24*3600));

        this.days = days;
        this.seconds = seconds;
        this.microseconds = microseconds;
        this.hashcode = Int.getInt(-1);
    }

    @org.python.Method(
        __doc__ = "Timedelta TODO",
        default_args = {"days", "seconds", "microseconds",
                "milliseconds", "minutes", "hours", "weeks"}
    )
    public Timedelta(Int days) {
        super();

        this.days = days;
        this.seconds = Int.getInt(0);
        this.microseconds = Int.getInt(0);
        this.hashcode = Int.getInt(-1);
    }

    @org.python.Method(
        __doc__ = "Timedelta TODO",
        default_args = {"days", "seconds", "microseconds",
                "milliseconds", "minutes", "hours", "weeks"}
    )
    public Timedelta() {
        super();

        this.days = Int.getInt(0);
        this.seconds = Int.getInt(0);
        this.microseconds = Int.getInt(0);
        this.hashcode = Int.getInt(-1);
    }

    @org.python.Method(
        __doc__ = "Return str(self)."
    )
    public Str __str__() {
        long mm = this.seconds.value / 60;
        long ss = this.seconds.value % 60;
        long hh = mm / 60;
        mm = mm % 60;

        String result = String.format("%d:%02d:%02d", hh, mm, ss);

        if (this.days.value != 0) {
            result = String.format(
                "%d day%s, %s",
                this.days.value,
                this.days.value > 1 ? "s" : "",
                result
            );
        }

        if (this.microseconds.value != 0) {
            result = String.format(
                "%s.%06d",
                result,
                this.microseconds.value
            );
        }

        return new Str(result);
    }

    @org.python.Method(
        __doc__ = "Return total seconds"
    )
    public org.python.Object total_seconds() {
        Float tot_sec = new Float(((this.days.value * 86400.0 + this.seconds.value * 1.0)
            + new Float(this.microseconds.value/1000000.0).value));

        return tot_sec;
    }

    @org.python.Method(
        __doc__ = "Return self*other.",
        args = {"other"}
    )
    public org.python.Object __mul__(org.python.Object other) {
        org.python.stdlib.datetime.Timedelta tmp = new Timedelta();

        Int days = Int.getInt(((Int) this.days).value * ((Int) other).value);
        Int seconds = Int.getInt(((Int) this.seconds).value * ((Int) other).value);
        Int microseconds = Int.getInt(((Int) this.microseconds).value * ((Int) other).value);

        seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
        microseconds = Int.getInt(microseconds.value % 1000000);

        days = Int.getInt(days.value + seconds.value / (24*3600));
        seconds = Int.getInt(seconds.value % (24*3600));

        tmp.days = days;
        tmp.seconds = seconds;
        tmp.microseconds = microseconds;

        return tmp;
    }

    @org.python.Method(
        __doc__ = "Return self+value.",
        args = {"other"}
    )
    public org.python.Object __add__(org.python.Object other) {
        org.python.stdlib.datetime.Timedelta tmp = new Timedelta();

        Int days = Int.getInt(this.days.value + (((org.python.stdlib.datetime.Timedelta) other).days).value);
        Int seconds = Int.getInt(this.seconds.value + (((org.python.stdlib.datetime.Timedelta) other).seconds).value);
        Int microseconds = Int.getInt(this.microseconds.value + (((org.python.stdlib.datetime.Timedelta) other).microseconds).value);

        seconds = Int.getInt(seconds.value + microseconds.value / 1000000);
        microseconds = Int.getInt(microseconds.value % 1000000);

        days = Int.getInt(days.value + seconds.value / (24*3600));
        seconds = Int.getInt(seconds.value % (24*3600));

        tmp.days = days;
        tmp.seconds = seconds;
        tmp.microseconds = microseconds;

        return tmp;
    }
}
