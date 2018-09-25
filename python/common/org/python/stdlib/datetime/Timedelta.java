package org.python.stdlib.datetime;

import org.python.types.Int;
import org.python.types.Str;
import org.python.types.Float;
import org.python.types.Tuple;
import org.python.types.Bool;

public class Timedelta extends org.python.types.Object {
    private Int days;
    private Int seconds;
    private Int microseconds;
    private Int hashcode;

    private Timedelta() {
        super();
    }

    @org.python.Method(
        __doc__ = "Timedelta TODO",
        default_args = {}
    )
    public Timedelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        // Final values, all integer.
        Int d = Int.getInt(0);
        Int s = Int.getInt(0);
        Int us = Int.getInt(0);

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
            seconds = Int.getInt(Math.round((long) (fdays.value * (24*60*60)/1000)));
        }
        else if(args.length > 0) {
            if(args[0] instanceof Int)
              days = (Int) args[0];
            else if(args[0] instanceof Bool)
              days = ((Int) args[0].__int__());
            else if(args[0] instanceof Float) {
              fdays = (Float) args[0];
              days = (Int) args[0].__int__();
              fdays.value -= ((Float) days.__float__()).value;
              fdays.value = Math.round(fdays.value * 1000.0);
              seconds = Int.getInt(Math.round((long) (fdays.value * (24*60*60)/1000)));
            }
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
          microseconds = Int.getInt(Math.round((long) (fseconds.value * (1000000)/1000)));
        }
        else if(args.length > 1) {
            if(args[1] instanceof Int)
              seconds = (Int) args[1];
            else if(args[1] instanceof Float) {
              fseconds = (Float) args[1];
              seconds = (Int) args[1].__int__();
              fseconds.value -= ((Float) seconds.__float__()).value;
              fseconds.value = Math.round(fseconds.value * 1000.0);
              microseconds = Int.getInt(Math.round((long) (fseconds.value * (1000000)/1000)));
            }
        }
        org.python.Object microsecondsKwargs = kwargs.get("microseconds");
        if (microsecondsKwargs instanceof org.python.types.Int) {
            microseconds = (Int) microsecondsKwargs;
        }
        else if (microsecondsKwargs instanceof Float) {
            microseconds =  Int.getInt(((Int) microsecondsKwargs.__int__()).value);
        }
        else if(args.length > 2) {
            if(args[2] instanceof Int)
              microseconds = (Int) args[2];
            else if(args[2] instanceof Float) {
              microseconds =  Int.getInt(((Int) args[2].__int__()).value);
            }
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
          microseconds = Int.getInt(Math.round((long) (fmilliseconds.value * (1000)/1000)));
        }
        else if(args.length > 3) {
            if(args[3] instanceof Int)
              milliseconds = (Int) args[3];
            else if(args[3] instanceof Float) {
              fmilliseconds = (Float) args[3];
              milliseconds = (Int) args[3].__int__();
              fmilliseconds.value -= ((Float) milliseconds.__float__()).value;
              fmilliseconds.value = Math.round(fmilliseconds.value * 1000.0);
              microseconds = Int.getInt(Math.round((long) (fmilliseconds.value * (1000)/1000)));
            }
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
          seconds = Int.getInt(Math.round((long) (fminutes.value * (60)/1000)));
        }
        else if(args.length > 4) {
            if(args[4] instanceof Int)
              minutes = (Int) args[4];
            else if(args[4] instanceof Float) {
              fminutes = (Float) args[4];
              minutes = (Int) args[4].__int__();
              fminutes.value -= ((Float) minutes.__float__()).value;
              fminutes.value = Math.round(fminutes.value * 1000.0);
              seconds = Int.getInt(Math.round((long) (fminutes.value * (60)/1000)));
            }
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
          seconds = Int.getInt(Math.round((long) (fhours.value * (60*60)/1000)));
        }
        else if(args.length > 5) {
            if(args[5] instanceof Int)
              hours = (Int) args[5];
            else if(args[5] instanceof Float) {
              fhours = (Float) args[5];
              hours = (Int) args[5].__int__();
              fhours.value -= ((Float) hours.__float__()).value;
              fhours.value = Math.round(fhours.value * 1000.0);
              seconds = Int.getInt(Math.round((long) (fhours.value * (60*60)/1000)));
            }
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
          seconds = Int.getInt(Math.round((long) (fweeks.value * (7*24*60*60)/1000)));
        }
        else if(args.length > 6) {
            if(args[6] instanceof Int)
              weeks = (Int) args[6];
            else if(args[6] instanceof Float) {
              fweeks = (Float) args[6];
              weeks = (Int) args[6].__int__();
              fweeks.value -= ((Float) weeks.__float__()).value;
              fweeks.value = Math.round(fweeks.value * 1000.0);
              seconds = Int.getInt(Math.round((long) (fweeks.value * (7*24*60*60)/1000)));
            }
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
        __doc__ = "Return str(self)."
    )
    public Str __str__() {
        long mm = this.seconds.value / 60;
        long ss = this.seconds.value % 60;
        long hh = mm / 60;
        mm = mm % 60;

        String result = String.format("%d:%02d:%02d", hh, mm, ss);

        if (this.days.value > 0) {
            result = String.format(
                "%d day%s, %s",
                this.days.value,
                this.days.value > 1 ? "s" : "",
                result
            );
        }

        if (this.microseconds.value > 0) {
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
        Float tot_sec = new Float(((this.days.value * 86400 + this.seconds.value) * 10^6
            + this.microseconds.value / 10^6)/10);

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
