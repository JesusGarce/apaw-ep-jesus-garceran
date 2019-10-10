package es.upm.miw.apaw_ep_jesus_garceran.team_data;

import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDto;

import java.util.LinkedList;
import java.util.List;

public class CreatedTeams {

    private static List<TeamDto> teamList;

    private CreatedTeams() {
        this.teamList = new LinkedList<>();
    }

    public static List<TeamDto> getInstance() {
        if (teamList == null)
            new CreatedTeams();
        return teamList;
    }


}
