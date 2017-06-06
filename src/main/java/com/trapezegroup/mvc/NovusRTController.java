package com.trapezegroup.mvc;

import com.trapezegroup.Event;
import com.trapezegroup.NovusRTConsumer;
import com.trapezegroup.NovusRTResult;
import com.trapezegroup.converter.TimeComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class NovusRTController {

    @Autowired
    private NovusRTConsumer novusRTConsumer;

    @Value("#{stops}")
    private Map<String, String> stops;

    private TimeComparator timeComparator = new TimeComparator();

    @RequestMapping("/departures")
    public String stopData(Model model) {

        List<Event> departures = new ArrayList<Event>();

        // Loop through each stop to obtain departures
        for (Map.Entry<String, String> stopAndBay: stops.entrySet()) {
            // Fetch departures for this stop
            List<Event> departuresForStop = novusRTConsumer.getNovusRTResult(stopAndBay.getKey(), stopAndBay.getValue()).getEvents();
            if (departuresForStop != null) {
                departures.addAll(departuresForStop);
            }
        }

        // Order departures based on departure time
        Collections.sort(departures, timeComparator);

        model.addAttribute("stopEvents", departures);
        return "stop_data";
    }
}
