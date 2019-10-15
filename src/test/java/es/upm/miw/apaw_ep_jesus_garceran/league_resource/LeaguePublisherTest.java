package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.TeamDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.LinkedList;

@ApiTestConfig
public class LeaguePublisherTest {

    @Autowired
    LeagueDao leagueDao;
    @Autowired
    TeamDao teamDao;
    private LeagueBusinessController leagueBusinessController;
    private String idLeague;

    public void initialize() {
        leagueBusinessController = new LeagueBusinessController(teamDao, leagueDao);
        idLeague = leagueBusinessController.create(new LeagueDto(new League("Liga Española", new LinkedList<>()))).getId();

        this.teamDao.saveAll(Arrays.asList(
                new Team("Real Madrid C.F.", "Madrid", "https://www.stickpng.com/assets/images/584a9b47b080d7616d298778.png", 0),
                new Team("F.C. Barcelona", "Barcelona", "https://www.stickpng.com/assets/images/584a9b3bb080d7616d298777.png", 0)
                )
        );
    }

    @Test
    public void testPublisher() {
        initialize();
        StepVerifier
                .create(leagueBusinessController.publisher(idLeague))
                .then(() -> leagueBusinessController.addTeam(idLeague, "Real Madrid C.F."))
                .expectNext("Real Madrid C.F.")
                .then(() -> leagueBusinessController.addTeam(idLeague, "F.C. Barcelona"))
                .expectNext("F.C. Barcelona")
                .thenCancel()
                .verify();
    }
}
