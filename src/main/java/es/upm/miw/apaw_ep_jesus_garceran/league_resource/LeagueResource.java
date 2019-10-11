package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LeagueResource.LEAGUES)
public class LeagueResource {

    static final String LEAGUES = "/leagues";
    static final String TABLE = "/table";
    static final String ID_ID = "/{id}";
    static final String MATCHES = "/matches";
    static final String ID_IDLEAGUE = "/{idLeague}";
    static final String ID_IDMATCH = "/{idMatch}";

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

    @PutMapping(value = ID_ID + TABLE, consumes = "application/json")
    public void addTeam(@PathVariable String id, @RequestBody TeamDto teamDto) {
        teamDto.validate();
        this.leagueBusinessController.addTeam(id, teamDto.getName(), teamDto.getCity(), teamDto.getBadge());
    }

    @PatchMapping(value = ID_IDLEAGUE + MATCHES + ID_IDMATCH, consumes = "application/json")
    public void changeResult(@PathVariable String idLeague, @PathVariable int idMatch, @RequestBody ResultDto resultDto) {
        //resultDto.validate();
        this.leagueBusinessController.changeResult(idLeague, idMatch, resultDto);
    }

}
