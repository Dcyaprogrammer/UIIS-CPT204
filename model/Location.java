package model;

public class Location {
    private String location_id;
    private int priority_score;

    public Location(String location_id, int priority_score) {
        this.location_id = location_id;
        this.priority_score = priority_score;
    }

    public String getLocation_id() {
        return location_id;
    }

    public int getPriority_score() {
        return priority_score;
    }

    @Override
    public String toString(){
        return location_id + " " + priority_score;
    }

}
 