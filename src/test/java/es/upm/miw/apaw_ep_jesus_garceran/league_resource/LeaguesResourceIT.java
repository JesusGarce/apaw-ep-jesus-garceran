package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamResource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
class LeaguesResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        LeagueDto leagueDto = this.webTestClient
                .post().uri(LeagueResource.LEAGUES)
                .body(BodyInserters.fromObject(new LeagueCreationDto("Liga Española")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(LeagueDto.class).returnResult().getResponseBody();

        assertNotNull(leagueDto);
        assertEquals("Liga Española", leagueDto.getName());
    }

    @Test
    void testCreateException() {
        LeagueCreationDto leagueCreationDto = new LeagueCreationDto("");
        this.webTestClient
                .post().uri(LeagueResource.LEAGUES)
                .body(BodyInserters.fromObject(leagueCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }
}
