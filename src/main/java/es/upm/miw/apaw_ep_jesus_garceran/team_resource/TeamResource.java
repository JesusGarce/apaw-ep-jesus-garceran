package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TeamResource.TEAMS)
public class TeamResource {

    public static final String TEAMS = "/teams";

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

    @GetMapping
    public List<TeamDto> getAll() {
        return this.teamBusinessController.getAll();
    }

}
