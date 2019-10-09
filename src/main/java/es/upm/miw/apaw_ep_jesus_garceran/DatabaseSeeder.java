package es.upm.miw.apaw_ep_jesus_garceran;

import es.upm.miw.apaw_ep_jesus_garceran.team_resource.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DatabaseSeeder {
    private TeamDao teamDao;

    @Autowired
    public DatabaseSeeder(TeamDao teamDao) {
        this.teamDao = teamDao;
        this.seederTeams();
    }

    public void seederTeams() {
        this.teamDao.saveAll(Arrays.asList(
                    new Team("Real Madrid C.F.", "Madrid", "", 0),
                    new Team("F.C. Barcelona", "Barcelona", "", 0),
                    new Team("Sevilla F.C.", "Sevilla", "", 0),
                    new Team("Valencia C.F.", "Valencia", "", 0),
                    new Team("Real Murcia F.C.", "Murcia", "",0)
                )
        );
    }
}
