package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.BadRequestException;

public class LeagueDto {

    private String id;

    private String name;

    public LeagueDto() {
        // empty for framework
    }

    public LeagueDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public LeagueDto(League league) {
        this.id = league.getId();
        this.name = league.getName();

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void validate() {
        if (name.isEmpty()) {
            throw new BadRequestException("Incomplete LeagueDto. ");
        }
    }

    @Override
    public String toString() {
        return "LeagueDto{" +
                "name='" + name + '\'' +
                '}';
    }

}
