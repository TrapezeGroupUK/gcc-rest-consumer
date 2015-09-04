package com.trapezegroup;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NovusRTResult {

    private String time;
    @JsonProperty("AtcoCode")
    private String atcoCode;
    private List<Event> events;

    public String getTime() {
        return time;
    }

    public String getAtcoCode() {
        return atcoCode;
    }

    public List<Event> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NovusRTResult{");
        sb.append("time=").append(time);
        sb.append(", NAPTAN='").append(atcoCode).append('\'');
        sb.append(", events=").append(events);
        sb.append('}');
        return sb.toString();
    }
}
