package com.trapezegroup;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.trapezegroup.converter.TimeConverter;
import lombok.Data;
import org.joda.time.DateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
    /*
    "operator": "FG",
      "service": "3",
      "destination": "Drumchapel Station",
      "status": "delayed",
      "arrival time": 203,
      "departure time": 203
     */

    private String operator;
    @JsonProperty("publicservicename")
    private String service;
    private String destination;
    private String status;
    @JsonProperty("departuretime")
    private String departureTime;
    @JsonProperty("arrivaltime")
    private String arrivalTime;

    private TimeConverter timeConverter = new TimeConverter();

    public String getOperator() {
        return operator;
    }

    public String getService() {
        return service;
    }

    public String getDestination() {
        return destination;
    }

    public String getStatus() {
        return status;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public  String getLocalArrivalTime() {
        return timeConverter.convert(arrivalTime);
    }

    public String getLocalDepartureTime() {
        return timeConverter.convert(departureTime);
    }

    public String bay;

    public void setBay(String bay) {
        this.bay = bay;
    }

    public DateTime getDepartureTimeAsDateTime() {
        return timeConverter.convertToDateTime(departureTime);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("departureTime=").append(departureTime);
        sb.append(", operator='").append(operator).append('\'');
        sb.append(", service='").append(service).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append(", arrivalTime=").append(arrivalTime);
        sb.append('}');
        return sb.toString();
    }
}
