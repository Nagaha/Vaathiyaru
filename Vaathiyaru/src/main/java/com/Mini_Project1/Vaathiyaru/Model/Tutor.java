package com.Mini_Project1.Vaathiyaru.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Tutor")
public class Tutor {

    private int id;
    private String heading;
    private String desc;
    private String location;
    private int exp;
    private double ratings;

    // Constructors
    Tutor() {
    }



    public Tutor(int id, String heading, String desc, String location, int exp, double ratings) {
        this.id = id;
        this.heading = heading;
        this.desc = desc;
        this.location = location;
        this.exp = exp;
        this.ratings=ratings;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }
    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    // toString method
    @Override
    public String toString() {
        String ans="Hey there! Hope this message finds you well, \n \t A new user has been" +
                "updated kindly contact him if necessary. Here are the details \n" +
                "Name:"+this.heading+" \nDescription:"+this.desc+" \nLocation:"+this.location+
                " \nWith experience of "+this.exp+" years"+" Having ratings of "+this.ratings;
        return ans;
    }
}
