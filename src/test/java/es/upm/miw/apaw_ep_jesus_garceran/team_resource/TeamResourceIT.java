package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ApiTestConfig
class TeamResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate() {
        TeamDto teamDto = this.webTestClient
                .post().uri(TeamResource.TEAMS)
                .body(BodyInserters.fromObject(new TeamCreationDto("Test", "Ciudad anónima", "Escudo")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(TeamDto.class).returnResult().getResponseBody();
        assertNotNull(teamDto);
        assertEquals("Test", teamDto.getName());
        assertEquals("Ciudad anónima", teamDto.getCity());
        assertEquals("Escudo", teamDto.getBadge());
    }

}