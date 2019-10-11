package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import es.upm.miw.apaw_ep_jesus_garceran.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SponsorBusinessController {

    private SponsorDao sponsorDao;

    @Autowired
    public SponsorBusinessController(SponsorDao sponsorDao) {
        this.sponsorDao = sponsorDao;
    }


    public void delete(String id) {
        sponsorDao.delete(sponsorDao.findById(id).orElseThrow(() -> new NotFoundException("Sponsor id: " + id)));
    }
}
