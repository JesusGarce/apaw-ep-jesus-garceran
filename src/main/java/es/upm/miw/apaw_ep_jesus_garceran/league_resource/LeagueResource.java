package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LeagueResource.LEAGUES)
public class LeagueResource {

    static final String LEAGUES = "/leagues";

    private LeagueBusinessController leagueBusinessController;

    @Autowired
    public LeagueResource(LeagueBusinessController leagueBusinessController) {
        this.leagueBusinessController = leagueBusinessController;
    }

    @PostMapping(consumes = "application/json")
    public LeagueDto create(@RequestBody LeagueDto leagueDto) {
        leagueDto.validate();
        return this.leagueBusinessController.create(leagueDto);
    }
}
