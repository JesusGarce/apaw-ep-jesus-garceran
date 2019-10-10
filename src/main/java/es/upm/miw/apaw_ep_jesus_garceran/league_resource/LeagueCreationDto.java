package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

public class LeagueCreationDto {

    String name;

    public LeagueCreationDto() {
        // empty for framework
    }

    public LeagueCreationDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "LeagueCreationDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
