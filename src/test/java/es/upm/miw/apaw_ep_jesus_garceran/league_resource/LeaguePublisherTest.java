package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.util.LinkedList;

@ApiTestConfig
public class LeaguePublisherTest {

    LeagueBusinessController leagueBusinessController;
    @Autowired
    LeagueDao leagueDao;
    @Autowired
    TeamDao teamDao;

    private String idLeague;

    public void initialize() {
        leagueBusinessController = new LeagueBusinessController(teamDao, leagueDao);
        idLeague = leagueBusinessController.create(new LeagueDto(new League("Liga Española", new LinkedList<>()))).getId();
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
