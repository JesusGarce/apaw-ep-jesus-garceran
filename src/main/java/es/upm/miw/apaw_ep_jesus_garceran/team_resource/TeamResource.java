package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TeamResource.TEAMS)
public class TeamResource {

    static final String TEAMS = "/teams";

    private TeamBusinessController teamBusinessController;

    @Autowired
    public TeamResource(TeamBusinessController teamBusinessController) {
        this.teamBusinessController = teamBusinessController;
    }

    @PostMapping(consumes = "application/json")
    public TeamDto create(@RequestBody TeamDto teamDto) {
        teamDto.validate();
        return this.teamBusinessController.create(teamDto);
    }




}
