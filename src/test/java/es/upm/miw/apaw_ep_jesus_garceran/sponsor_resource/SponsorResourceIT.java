package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import es.upm.miw.apaw_ep_jesus_garceran.ApiTestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ApiTestConfig
class SponsorResourceIT {

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private SponsorDao sponsorDao;
    private Sponsor sponsor;

    private void createSponsor() {
        sponsor = sponsorDao.save(new Sponsor("Nuevo patrocinador", 123.00));
    }

    @Test
    void testDelete() {
        createSponsor();
        int sizeSponsorDao = sponsorDao.findAll().size();
        webTestClient.delete()
                .uri(SponsorResource.SPONSORS + SponsorResource.ID_ID, sponsor.getId())
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.OK);

        assertEquals(sizeSponsorDao - 1, sponsorDao.findAll().size());

    }

    @Test
    void testDeleteBadId() {
        webTestClient.delete()
                .uri(SponsorResource.SPONSORS + SponsorResource.ID_ID, "id")
                .exchange()
                .expectStatus().isEqualTo(HttpStatus.NOT_FOUND);
    }
}