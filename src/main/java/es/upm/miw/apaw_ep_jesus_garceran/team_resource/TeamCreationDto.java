package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

public class TeamCreationDto {

    private String name;

    private String city;

    private String badge;

    public TeamCreationDto(String name, String city, String badge) {
        this.name = name;
        this.city = city;
        this.badge = badge;
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


    @Override
    public String toString() {
        return "TeamCreationDto{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", badge='" + badge + '\'' +
                '}';
    }
}
