package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

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
        League league = new League(leagueDto.getName());
        this.leagueDao.save(league);
        return new LeagueDto(league);
    }
}
