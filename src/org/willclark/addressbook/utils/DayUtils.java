package org.willclark.addressbook.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DayUtils {
	
	public static final String INTERNAL_DATE_FORMAT = "yyyyMMdd";
	public static final String INTERNAL_DATETIME_FORMAT = "yyyyMMddHHmm";

	public static final String EXTERNAL_DATE_FORMAT = "MM/dd/yyyy";
	public static final String EXTERNAL_DATETIME_FORMAT = "MM/dd/yyyy HH:mm";

    public static String stdString(Date date) {
    	SimpleDateFormat sdf = new SimpleDateFormat(EXTERNAL_DATE_FORMAT);
    	sdf.setTimeZone(TimeZone.getDefault());
        return sdf.format(date);
    }

	public static String format(Date date) {
		return format(date,	EXTERNAL_DATE_FORMAT);
	}

	public static String format(Date date, String format) {
		try {
			return new SimpleDateFormat(format).format(date);
		}
		catch (Exception e) {
			//do nothing
		}
		return "";
	}

	public static Date parse(String date) {
		return parse(date, INTERNAL_DATE_FORMAT);
	}

	public static Date parse(String date, String format) {
		if (date == null || format == null) return null;
		try {
			return new SimpleDateFormat(format).parse(date);
		}
		catch (Exception e) {
			//do nothing
		}
		return new Date();
	}

    public static Date getMidnight(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date getEndOfDay(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        c.add(Calendar.DAY_OF_YEAR, 1);
        c.add(Calendar.MILLISECOND, -1);

        return c.getTime();
    }

    public static Date getBeginningOfWeek(Date day, int dayOfWeek) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);

        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static Date getBeginningOfWeek(Date day) {
    	return getBeginningOfWeek(day,Calendar.SUNDAY);
    }

    public static Date getBeginningOfWeek(Date day, Date min) {
        return getBeginningOfWeek(day,Calendar.SUNDAY).before(min) ? min : getBeginningOfWeek(day,Calendar.SUNDAY);
    }

    public static Date getEndOfWeek(Date day, int dayOfWeek) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);

        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);

        return cal.getTime();
    }

    public static Date getEndOfWeek(Date day) {
    	return getEndOfWeek(day,Calendar.SATURDAY);
    }

    public static Date getEndOfWeek(Date day, Date max) {
        return getEndOfWeek(day,Calendar.SATURDAY).after(max) ? max : getEndOfWeek(day,Calendar.SATURDAY);
    }

    public static int getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.MONTH);
    }

    public static int getDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_MONTH);
    }

    public static int getHourOfDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMinuteOfHour(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.MINUTE);
    }

    public static int getSecondOfMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.SECOND);
    }

    public static Date getBeginningOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date getBeginningOfYear(int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }

    public static Date getEndOfYear(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.MONTH, Calendar.DECEMBER);
        c.set(Calendar.DAY_OF_MONTH, 31);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, -1);

        return c.getTime();
    }

    public static Date getEndOfYear(int year) {
    	return getEndOfYear(getBeginningOfYear(year));
    }

    public static Date getBeginningOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date getBeginningOfMonth(int month, int year) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }

    public static Date getEndOfMonth(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        c.add(Calendar.MONTH, 1);
        c.add(Calendar.MILLISECOND, -1);

        return c.getTime();
    }

    public static Date getEndOfMonth(int month, int year) {
    	return getEndOfMonth(getBeginningOfMonth(month, year));
    }

    public static int getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.YEAR);
    }

    public static Date addDays(Date date, int days) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.DAY_OF_MONTH, days);

        return c.getTime();
    }

    public static Date addWeeks(Date date, int weeks) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.WEEK_OF_YEAR, weeks);

        return c.getTime();
    }

    public static Date addMonths(Date date, int months) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.MONTH, months);

        return c.getTime();
    }

    public static Date addYears(Date date, int years) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);

        c.add(Calendar.YEAR, years);

        return c.getTime();
    }

    public static Date add(Date date, String what, int units) {
        if (what.startsWith("d"))
            return addDays(date, units);
        else if (what.startsWith("w"))
            return addWeeks(date, units);
        else if (what.startsWith("m"))
            return addMonths(date, units);
        else
            throw new IllegalArgumentException("add: arg must be d/w/m");
    }

	public static Date getToday() {
		return getMidnight(new Date());
	}

	public static Date getYesterday() {
		return DayUtils.subtractDays(getMidnight(new Date()),1);
	}

	public static Date getCurrentHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getPreviousHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.HOUR, -1);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date roundMinute(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date roundHour(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

    public static Date addMinutes(Date date, int minutes) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutes);
		//calendar.set(Calendar.SECOND, 0);
		//calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
    }

	public static Date addHours(Date date, int hour) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR, hour);
		//calendar.set(Calendar.MINUTE, 0);
		//calendar.set(Calendar.SECOND, 0);
		//calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date addSeconds(Date date, int seconds) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, seconds);
		//calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date subtractSeconds(Date date, int seconds) {
		return addSeconds(date, -1*seconds);
	}

	public static Date subtractMinutes(Date date, int minutes) {
		return addMinutes(date, -1*minutes);
	}

	public static Date subtractHours(Date date, int hour) {
		return addHours(date, -1*hour);
	}

	public static Date subtractDays(Date date, int days) {
		return addDays(date, -1*days);
	}

	public static Date subtractWeeks(Date date, int weeks) {
		return addWeeks(date, -1*weeks);
	}

	public static Date subtractMonths(Date date, int months) {
		return addMonths(date, -1*months);
	}

	public static Date subtractYears(Date date, int years) {
		return addYears(date, -1*years);
	}

	public static Date getNextHourChunk(Date date, int interval) {
		if (interval < 0 || interval > 59) throw new IllegalArgumentException("interval should be greater than 0 and less than 59");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int minute = DayUtils.getMinuteOfHour(date);
		int mod = minute % interval;
		calendar.add(Calendar.MINUTE, interval-mod);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getPreviousHourChunk(Date date, int interval) {
		if (interval < 0 || interval > 59) throw new IllegalArgumentException("interval should be greater than 0 and less than 59");

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int minute = DayUtils.getMinuteOfHour(date);
		int mod = minute % interval;
		calendar.add(Calendar.MINUTE, -mod);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	public static Date getNextQuarterHour(Date date) {
		return getNextHourChunk(date, 15);
	}

	public static Date getPreviousQuarterHour(Date date) {
		return getPreviousHourChunk(date, 15);
	}

	public static String parseDateRangeForDateNavigationInterval(String range) {
		if (range == null) throw new IllegalArgumentException("range is a required parameter");
		if (range.equalsIgnoreCase("thisCalendarWeek")
			|| range.equalsIgnoreCase("lastCalendarWeek")
			|| range.equalsIgnoreCase("thisWorkWeek")
			|| range.equalsIgnoreCase("lastWorkWeek")) {
			return "weekly";
		}
		else if(range.equalsIgnoreCase("thisCalendarMonth")
				|| range.equalsIgnoreCase("lastCalendarMonth")
				|| range.equalsIgnoreCase("thisYearJan")
				|| range.equalsIgnoreCase("thisYearFeb")
				|| range.equalsIgnoreCase("thisYearMar")
				|| range.equalsIgnoreCase("thisYearApr")
				|| range.equalsIgnoreCase("thisYearMay")
				|| range.equalsIgnoreCase("thisYearJun")
				|| range.equalsIgnoreCase("thisYearJul")
				|| range.equalsIgnoreCase("thisYearAug")
				|| range.equalsIgnoreCase("thisYearSep")
				|| range.equalsIgnoreCase("thisYearOct")
				|| range.equalsIgnoreCase("thisYearNov")
				|| range.equalsIgnoreCase("thisYearDec")
				|| range.equalsIgnoreCase("lastYearJan")
				|| range.equalsIgnoreCase("lastYearFeb")
				|| range.equalsIgnoreCase("lastYearMar")
				|| range.equalsIgnoreCase("lastYearApr")
				|| range.equalsIgnoreCase("lastYearMay")
				|| range.equalsIgnoreCase("lastYearJun")
				|| range.equalsIgnoreCase("lastYearJul")
				|| range.equalsIgnoreCase("lastYearAug")
				|| range.equalsIgnoreCase("lastYearSep")
				|| range.equalsIgnoreCase("lastYearOct")
				|| range.equalsIgnoreCase("lastYearNov")
				|| range.equalsIgnoreCase("lastYearDec")) {
			return "monthly";
		}
		else if(range.equalsIgnoreCase("today") || range.equalsIgnoreCase("yesterday")) return "daily";
		return null;
	}

	public static Date[] getPreviousDatesForDateNavigation(String interval, Date from, Date thru) {
		if (interval == null) throw new IllegalArgumentException("interval is a required parameter");

		if("monthly".equalsIgnoreCase(interval)) {
			if (from == null || thru == null) throw new IllegalArgumentException("from and thru are conditionally required parameters");
			return new Date[]{DayUtils.getBeginningOfMonth(DayUtils.subtractMonths(from, 1)), DayUtils.getEndOfMonth(DayUtils.subtractMonths(thru, 1))};
		}
		if("weekly".equalsIgnoreCase(interval)) {
			if (from == null || thru == null) throw new IllegalArgumentException("from and thru are conditionally required parameters");
			return new Date[]{DayUtils.subtractDays(from, 7), DayUtils.subtractDays(thru, 7)};
		}
		if("daily".equalsIgnoreCase(interval)) {
			if (from == null) throw new IllegalArgumentException("from is a conditionally required parameter");
			return new Date[]{DayUtils.subtractDays(from, 1), DayUtils.subtractDays(from, 1)};
		}
		return null;
	}

	public static Date[] getNextDatesForDateNavigation(String interval, Date from, Date thru) {
		if (interval == null) throw new IllegalArgumentException("interval is a required parameter");

		if("monthly".equalsIgnoreCase(interval)) {
			if (from == null || thru == null) throw new IllegalArgumentException("from and thru are conditionally required parameters");
			return new Date[]{DayUtils.getBeginningOfMonth(DayUtils.addMonths(from, 1)), DayUtils.getEndOfMonth(DayUtils.addMonths(thru, 1))};
		}
		if("weekly".equalsIgnoreCase(interval)) {
			if (from == null || thru == null) throw new IllegalArgumentException("from and thru are conditionally required parameters");
			return new Date[]{DayUtils.addDays(from, 7), DayUtils.addDays(thru, 7)};
		}
		if("daily".equalsIgnoreCase(interval)) {
			if (from == null) throw new IllegalArgumentException("from is a conditionally required parameter");
			return new Date[]{DayUtils.addDays(from, 1), DayUtils.addDays(from, 1)};
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(DayUtils.getPreviousQuarterHour(new Date()));
		System.out.println(DayUtils.getNextQuarterHour(new Date()));
	}

}
