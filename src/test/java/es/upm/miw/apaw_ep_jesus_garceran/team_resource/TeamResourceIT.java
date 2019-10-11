package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Test
    void testCreateWithoutName() {
        TeamCreationDto teamCreationDto = new TeamCreationDto("", "Ciudad anónima", "Escudo");
        this.webTestClient
                .post().uri(TeamResource.TEAMS)
                .body(BodyInserters.fromObject(teamCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateWithoutCity() {
        TeamCreationDto teamCreationDto = new TeamCreationDto("Name", "", "Escudo");
        this.webTestClient
                .post().uri(TeamResource.TEAMS)
                .body(BodyInserters.fromObject(teamCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testCreateWithoutBadge() {
        TeamCreationDto teamCreationDto = new TeamCreationDto("Name", "Ciudad anónima", "");
        this.webTestClient
                .post().uri(TeamResource.TEAMS)
                .body(BodyInserters.fromObject(teamCreationDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void testGetAllTeams() {
        this.webTestClient
                .get().uri(TeamResource.TEAMS)
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK)
                .expectBodyList(TeamDto.class).returnResult().getResponseBody();
    }

}