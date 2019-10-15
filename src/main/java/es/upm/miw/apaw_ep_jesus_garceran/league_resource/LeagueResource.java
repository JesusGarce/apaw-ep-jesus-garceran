package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.BadRequestException;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(LeagueResource.LEAGUES)
public class LeagueResource {

    static final String LEAGUES = "/leagues";
    static final String TABLE = "/table";
    static final String MATCHES = "/matches";
    static final String ID_IDLEAGUE = "/{idLeague}";
    static final String ID_IDMATCH = "/{idMatch}";
    static final String SEARCH = "/search";

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

    @PutMapping(value = ID_IDLEAGUE + TABLE, consumes = "application/json")
    public void addTeam(@PathVariable String idLeague, @RequestBody TeamDto teamDto) {
        teamDto.validate();
        this.leagueBusinessController.addTeam(idLeague, teamDto.getName());
    }

    @PatchMapping(value = ID_IDLEAGUE + MATCHES + ID_IDMATCH, consumes = "application/json")
    public void changeResult(@PathVariable String idLeague, @PathVariable int idMatch, @RequestBody ResultDto resultDto) {
        this.leagueBusinessController.changeResult(idLeague, idMatch, resultDto);
    }

    @GetMapping(value = ID_IDLEAGUE + MATCHES + SEARCH)
    public List<MatchDto> searchMatchesOfADate(@PathVariable String idLeague, @RequestParam String q) {
        if (!"date".equals(q.split(":=")[0])) {
            throw new BadRequestException("query param q is incorrect, missing 'date:='");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse(q.split(":=")[1], formatter);
        return this.leagueBusinessController.findMatchesByDate(idLeague, localDateTime);
    }

    @GetMapping(value = ID_IDLEAGUE + TABLE)
    public List<TeamDto> getTable(@PathVariable String idLeague) {
        return this.leagueBusinessController.getTable(idLeague);
    }

}
