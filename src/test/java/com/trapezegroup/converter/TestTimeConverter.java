package com.trapezegroup.converter;

import junit.framework.Assert;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static junit.framework.TestCase.assertEquals;

/*
Change 1:
The top row “Bishops Cleeve” is an example of a real-time prediction; JSON returns a numeric (number of seconds) for this (Eg. 532).
Can these be presented as a number of mins.  Simply divide by 60 (truncating/rounding down) and display “X mins” (Eg. 8 mins).

Change 2:
The other rows (above) are examples of scheduled times; JSON returns a colon-formatted string that is UTC time.
Can these be converted to local time before display.
 */
public class TestTimeConverter {
    private TimeConverter  timeConverter;

    @Before
    public void init() {
        timeConverter = new TimeConverter();
    }

    @Test
    public void testSecondsToMinutesSuccessfulConversion() {
        String secondsOne = "505";

        String minsOne = timeConverter.convert(secondsOne);

        assertEquals("Expect 8 mins", "8 mins", minsOne);

        String secondsTwo = "239";

        String minsTwo = timeConverter.convert(secondsTwo);

        assertEquals("Expect 3 mins", "3 mins", minsTwo);
    }

    @Test
    public void testUTCTimeToLocalTimeConversion() {
        String utcOne = "10:30";

        String localTimeOne = convertToLocalTime(utcOne);

        String localTimeResult = timeConverter.convert(utcOne);

        Assert.assertEquals("Expecting conversion to local time: " + localTimeOne, localTimeOne, localTimeResult);
    }

    @Test(expected = RuntimeException.class)
    public void testInvalidFormat() {
        timeConverter.convert("11/15");
    }

    @Test
    public void testNullReturnsNull() {
        assertNull(timeConverter.convert(null));
    }

    @Test
    public void testBlankOrEmptyReturnsBlankOrEmpty() {
        String emptyString = "";
        assertEquals(emptyString, timeConverter.convert(emptyString));
        String blankString = "  ";
        Assert.assertEquals(blankString, timeConverter.convert(blankString));
    }


    private String convertToLocalTime(String utcTimeString) {
        String[] hoursMins = utcTimeString.split(":");
        DateTime utcTime = new DateTime(DateTimeZone.UTC).withHourOfDay(Integer.parseInt(hoursMins[0])).withMinuteOfHour(Integer.parseInt(hoursMins[1]));
        DateTimeZone localTimeZone = DateTimeZone.forID("Europe/London");
        DateTime localTime = utcTime.toDateTime(localTimeZone);
        DateTimeFormatter fmt = DateTimeFormat.forPattern("HH:mm");
        return fmt.print(localTime);
    }
}
