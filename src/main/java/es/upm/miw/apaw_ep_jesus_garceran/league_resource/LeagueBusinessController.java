package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.LinkedList;
import java.util.List;

@Controller
public class LeagueBusinessController {

    private LeagueDao leagueDao;
    private TeamDao teamDao;

    @Autowired
    public LeagueBusinessController(TeamDao teamDao, LeagueDao leagueDao) {
        this.teamDao = teamDao; this.leagueDao = leagueDao;
    }

    public LeagueDto create(LeagueDto leagueDto) {
        League league = new League(leagueDto.getName(), new LinkedList<>());
        this.leagueDao.save(league);
        return new LeagueDto(league);
    }


    public void addTeam(String id, String name, String city, String badge) {
        League league = this.findLeagueByIdAssured(id);
        Team team = this.teamDao.findByName(name);
        league.getTable().add(team);
        if (league.getTable().size() > 1)
            league.initializeCalendar();
        this.leagueDao.save(league);
    }

    private League findLeagueByIdAssured(String id) {
        return this.leagueDao.findById(id).orElseThrow(() -> new NotFoundException("League id: " + id));
    }

    public void changeResult(String idLeague, int idMatch, ResultDto resultDto){
        League league = this.findLeagueByIdAssured(idLeague);
        Match match = league.getCalendar().remove(idMatch);
        match.setResult(new Result(resultDto.getLocalScore(),resultDto.getAwayScore()));
        match.finishMatch();
        league.getCalendar().add(idMatch,match);
        this.leagueDao.save(league);
    }

}
