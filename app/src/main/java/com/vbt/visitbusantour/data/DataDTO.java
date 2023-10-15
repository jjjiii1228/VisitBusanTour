package com.vbt.visitbusantour.data;

import java.util.List;

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

    public static class CourseDetailDTO {
        private String date;
        private List<LocationDTO> location;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<LocationDTO> getLocation() {
            return location;
        }

        public void setLocation(List<LocationDTO> location) {
            this.location = location;
        }
    }

    public static class LocationDTO {
        private String location_name;
        private String location_url;
        private String location_address;
        private String location_longitude;
        private String location_latitude;
        private String location_score;
        private String location_type;

        public LocationDTO(String location_name, String location_address, String location_score, String location_url) {
            this.location_name = location_name;
            this.location_address = location_address;
            this.location_score = location_score;
            this.location_url = location_url;
        }

        public String getLocation_name() {
            return location_name;
        }

        public void setLocation_name(String location_name) {
            this.location_name = location_name;
        }

        public String getLocation_url() {
            return location_url;
        }

        public void setLocation_url(String location_url) {
            this.location_url = location_url;
        }

        public String getLocation_address() {
            return location_address;
        }

        public void setLocation_address(String location_address) {
            this.location_address = location_address;
        }

        public String getLocation_longitude() {
            return location_longitude;
        }

        public void setLocation_longitude(String location_longitude) {
            this.location_longitude = location_longitude;
        }

        public String getLocation_latitude() {
            return location_latitude;
        }

        public void setLocation_latitude(String location_latitude) {
            this.location_latitude = location_latitude;
        }

        public String getLocation_score() {
            return location_score;
        }

        public void setLocation_score(String location_score) {
            this.location_score = location_score;
        }

        public String getLocation_type() {
            return location_type;
        }

        public void setLocation_type(String location_type) {
            this.location_type = location_type;
        }
    }
}
