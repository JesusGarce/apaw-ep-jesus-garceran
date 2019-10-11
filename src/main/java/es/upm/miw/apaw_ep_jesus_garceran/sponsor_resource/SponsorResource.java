package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SponsorResource.SPONSORS)
public class SponsorResource {
    static final String SPONSORS = "/sponsors";
    static final String ID_ID = "/{id}";

    private SponsorBusinessController sponsorBusinessController;

    @Autowired
    public SponsorResource(SponsorBusinessController sponsorBusinessController) {
        this.sponsorBusinessController = sponsorBusinessController;
    }

    @DeleteMapping(value = ID_ID)
    public void deleteSponsor(@PathVariable String id) {
        this.sponsorBusinessController.delete(id);
    }

}
