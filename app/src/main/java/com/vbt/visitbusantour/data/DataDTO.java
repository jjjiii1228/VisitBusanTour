package com.vbt.visitbusantour.data;

public class DataDTO {
    String start_date;
    String end_date;
    String departure;
    String destination;
    String total_people_cnt;

    public DataDTO(String start_date, String end_date, String departure, String destination, String total_people_cnt) {
        this.start_date = start_date;
        this.end_date = end_date;
        this.departure = departure;
        this.destination = destination;
        this.total_people_cnt = total_people_cnt;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTotal_people_cnt() {
        return total_people_cnt;
    }

    public void setTotal_people_cnt(String total_people_cnt) {
        this.total_people_cnt = total_people_cnt;
    }
}
