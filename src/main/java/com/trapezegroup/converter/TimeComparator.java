package com.trapezegroup.converter;

import com.trapezegroup.Event;

import java.util.Comparator;

public class TimeComparator implements Comparator<Event> {
    @Override
    public int compare(Event event1, Event event2) {
        if (event1.getDepartureTimeAsDateTime() == null) {
            return -1;
        }

        if (event1.getDepartureTimeAsDateTime().isBefore(event2.getDepartureTimeAsDateTime())) {
            return -1;
        } else if (event1.getDepartureTimeAsDateTime().isAfter(event2.getDepartureTimeAsDateTime())) {
            return 1;
        }
        return 0;
    }
}
