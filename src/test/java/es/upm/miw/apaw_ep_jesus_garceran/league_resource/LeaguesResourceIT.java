package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import es.upm.miw.apaw_ep_jesus_garceran.team_resource.TeamDto;
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
    private LeagueDto leagueDto;

    @Test
    void testCreate() {
        leagueDto = this.webTestClient
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

    private void createLeague() {
        leagueDto = this.webTestClient
                .post().uri(LeagueResource.LEAGUES)
                .body(BodyInserters.fromObject(new LeagueCreationDto("Liga Española")))
                .exchange()
                .expectStatus().isOk()
                .expectBody(LeagueDto.class).returnResult().getResponseBody();
    }

    @Test
    void testAddTeam() {
        createLeague();
        TeamDto teamDto = new TeamDto(new Team("Equipo anónimo", "Ciudad anónima", "Escudo", 0));

        this.webTestClient
                .put().uri(LeagueResource.LEAGUES + LeagueResource.ID_ID + LeagueResource.TABLE, leagueDto.getId())
                .body(BodyInserters.fromObject(teamDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK);
    }

    @Test
    void TestAddWrongTeamException() {
        createLeague();
        TeamDto teamDto = new TeamDto(new Team("", "Ciudad anónima", "Escudo", 0));

        this.webTestClient
                .put().uri(LeagueResource.LEAGUES + LeagueResource.ID_ID + LeagueResource.TABLE, leagueDto.getId())
                .body(BodyInserters.fromObject(teamDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.BAD_REQUEST);
    }

    @Test
    void TestAddWrongIdLeagueException() {
        createLeague();
        TeamDto teamDto = new TeamDto(new Team("Equipo anónimo", "Ciudad anónima", "Escudo", 0));

        this.webTestClient
                .put().uri(LeagueResource.LEAGUES + LeagueResource.ID_ID + LeagueResource.TABLE, "malaId")
                .body(BodyInserters.fromObject(teamDto))
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }

}
