package es.upm.miw.apaw_ep_jesus_garceran;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.NotFoundException;
import es.upm.miw.apaw_ep_jesus_garceran.league_resource.League;
import es.upm.miw.apaw_ep_jesus_garceran.league_resource.LeagueDao;
import es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource.Sponsor;
import es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource.SponsorDao;
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
    private SponsorDao sponsorDao;

    @Autowired
    public DatabaseSeeder(TeamDao teamDao, LeagueDao leagueDao, SponsorDao sponsorDao) {
        this.teamDao = teamDao;
        this.leagueDao = leagueDao;
        this.sponsorDao = sponsorDao;
        this.seederTeams();
        this.seederLeague();
        this.seederSponsor();
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

    private void seederLeague() {
        League league = this.leagueDao.save(new League("LaLiga Santander", new LinkedList<>()));
        league = this.leagueDao.findById(league.getId()).orElseThrow(() -> new NotFoundException("League error: "));
        league.getTable().addAll(this.teamDao.findAll());
        league.initializeCalendar();
        this.leagueDao.save(league);
    }

    private void seederSponsor() {
        this.sponsorDao.saveAll(Arrays.asList(
                new Sponsor("Adidas", 3000000.00),
                new Sponsor("Nike", 1232142.00),
                new Sponsor("ElPozo", 12222222.00)
        ));
    }
}
