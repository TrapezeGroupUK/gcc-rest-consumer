package com.trapezegroup.converter;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeConverter {

    public String convert(String timeString) {
        if(StringUtils.isBlank(timeString)) {
            return timeString;
        }

        try {
            if (timeString.contains(":")) {
                return convertUTCToLocalTime(timeString);
            }
            return convertSecondsToWholeMinutes(timeString);
        } catch (Exception e) {
            throw new RuntimeException("Unable to convert time:" + timeString, e);
        }
    }

    private String convertSecondsToWholeMinutes(String timeString) {
        int secs = Integer.parseInt(timeString);
        int mins = secs / 60;
        String minutes = String.valueOf(mins);
        return minutes + " mins";
    }

    private String convertUTCToLocalTime(String timeString) {
        String[] hoursMins = timeString.split(":");
        DateTime utcTime = new DateTime(DateTimeZone.UTC).withHourOfDay(Integer.parseInt(hoursMins[0])).withMinuteOfHour(Integer.parseInt(hoursMins[1]));
        DateTimeZone localTimeZone = DateTimeZone.forID("Europe/London");
        DateTime localTime = utcTime.toDateTime(localTimeZone);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
        return fmt.print(localTime);
    }
}
