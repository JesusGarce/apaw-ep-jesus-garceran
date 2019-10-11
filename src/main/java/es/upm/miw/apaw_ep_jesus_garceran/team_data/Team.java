package es.upm.miw.apaw_ep_jesus_garceran.team_data;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Team {

    @Id
    private String id;

    @UniqueElements
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

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getBadge() {
        return badge;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points = this.points + points;
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
