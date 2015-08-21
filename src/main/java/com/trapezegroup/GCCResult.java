package com.trapezegroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GCCResult {

    private String time;
    @JsonProperty("NAPTAN")
    private String naptan;
    private List<Event> events;

    public String getTime() {
        return time;
    }

    public String getNaptan() {
        return naptan;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("GCCResult{");
        sb.append("time=").append(time);
        sb.append(", NAPTAN='").append(naptan).append('\'');
        sb.append(", events=").append(events);
        sb.append('}');
        return sb.toString();
    }
}
