package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MatchBuilderTest {


    @Test
    public void buildMatch() {
        Match match = new Match.Builder().date(LocalDateTime.of(2019, 10, 10, 12, 55))
                .local(new Team("Local", "Madrid", "b", 0))
                .away(new Team("Away", "Barcelona", "b", 0))
                .finished(false)
                .result(new Result(0, 2))
                .build();

        assertEquals(LocalDateTime.of(2019, 10, 10, 12, 55), match.getDate());
        assertEquals(new Team("Local", "Madrid", "b", 0).getName(), match.getLocal().getName());
        assertEquals(new Team("Away", "Barcelona", "b", 0).getName(), match.getAway().getName());
        assertFalse(match.isFinished());
        assertEquals(new Result(0, 2).getAwayScore(), match.getResult().getAwayScore());
        assertEquals(new Result(0, 2).getLocalScore(), match.getResult().getLocalScore());

    }

}
