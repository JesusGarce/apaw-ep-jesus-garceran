package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class Team {

    @Id
    private String id;

    private String name;

    private String city;

    private String badge;

    private int points;

    public Team(String name, String city, String badge, int points) {
        this.name = name;
        this.city = city;
        this.badge = badge;
        this.points = points;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", badge='" + badge + '\'' +
                '}';
    }
}
