package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;

public class TeamDto {

    private String id;

    private String name;

    private String city;

    private String badge;

    public TeamDto() {
        // empty for framework
    }

    public TeamDto(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.city = team.getCity();
        this.badge = team.getBadge();
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

    public void validate() {
        if (name.isEmpty() || badge.isEmpty() || city.isEmpty()) {
            throw new BadRequestException("Incomplete TeamDto. ");
        }
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", badge='" + badge + '\'' +
                '}';
    }
}
