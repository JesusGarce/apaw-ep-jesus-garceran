package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

import java.util.LinkedList;

public class LeaguePublisherTest {

    @Test
    void testPublisher() {
        Team teamMadrid = new Team("Real Madrid CF","Madrid","escudo",0);
        Team teamBarcelona = new Team("FC Barcelona","Barcelona","escudo",0);


        League league = new League("Liga Española", new LinkedList<>());
        StepVerifier
                .create(league.publisher())
                .then(() -> league.addTeam(teamMadrid))
                .expectNext(teamMadrid)
                .then(() -> league.addTeam(teamBarcelona))
                .expectNext(teamBarcelona)
                .thenCancel()
                .verify();
    }
}
