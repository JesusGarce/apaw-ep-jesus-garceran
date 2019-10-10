package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LeagueBusinessController {

    private LeagueDao leagueDao;

    @Autowired
    public LeagueBusinessController(LeagueDao leagueDao) {
        this.leagueDao = leagueDao;
    }

    public LeagueDto create(LeagueDto leagueDto) {
        League league = new League(leagueDto.getId(), leagueDto.getName());
        this.leagueDao.save(league);
        return new LeagueDto(league);
    }

    public void addTeam(String id, String name, String city, String badge){
        League league = this.findLeagueByIdAssured(id);
        Team team = new Team(name, city, badge, 0);
        league.getTable().add(team);
        this.leagueDao.save(league);
    }

    private League findLeagueByIdAssured(String id) {
        return this.leagueDao.findById(id).orElseThrow(() -> new NotFoundException("League id: " + id));
    }
}
