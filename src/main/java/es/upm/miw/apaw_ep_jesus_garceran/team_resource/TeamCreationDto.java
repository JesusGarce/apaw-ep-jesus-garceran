package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.BadRequestException;

public class TeamCreationDto {

    private String name;

    private String city;

    private String badge;

    public TeamCreationDto() {
        // empty for framework
    }

    public TeamCreationDto(String name, String city, String badge) {
        this.name = name;
        this.city = city;
        this.badge = badge;
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
            throw new BadRequestException("Incomplete TeamCreationDto. ");
        }
    }

    @Override
    public String toString() {
        return "TeamDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", badge='" + badge + '\'' +
                '}';
    }
}