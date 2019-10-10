package es.upm.miw.apaw_ep_jesus_garceran;

import es.upm.miw.apaw_ep_jesus_garceran.league_resource.League;
import es.upm.miw.apaw_ep_jesus_garceran.league_resource.LeagueDao;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;

@Service
public class DatabaseSeeder {
    private TeamDao teamDao;
    private LeagueDao leagueDao;

    @Autowired
    public DatabaseSeeder(TeamDao teamDao, LeagueDao leagueDao) {
        this.teamDao = teamDao;
        this.leagueDao = leagueDao;
        this.seederTeams();
        this.seederLeague();
    }

    private void seederTeams() {
        this.teamDao.saveAll(Arrays.asList(
                new Team("Real Madrid C.F.", "Madrid", "https://www.stickpng.com/assets/images/584a9b47b080d7616d298778.png", 0),
                new Team("F.C. Barcelona", "Barcelona", "https://www.stickpng.com/assets/images/584a9b3bb080d7616d298777.png", 0),
                new Team("Sevilla F.C.", "Sevilla", "https://upload.wikimedia.org/wikipedia/en/thumb/3/3b/Sevilla_FC_logo.svg/1200px-Sevilla_FC_logo.svg.png", 0),
                new Team("Real Murcia F.C.", "Murcia", "https://upload.wikimedia.org/wikipedia/en/thumb/9/93/Real_Murcia_CF_logo.svg/1200px-Real_Murcia_CF_logo.svg.png", 0)
                )
        );
    }

    private void seederLeague(){
        League league = this.leagueDao.save(new League("LaLiga Santander", new LinkedList<>()));
        league = this.leagueDao.findById(league.getId()).get();
        league.getTable().addAll(this.teamDao.findAll());
        league.initializeCalendar();
        this.leagueDao.save(league);
    }

}
