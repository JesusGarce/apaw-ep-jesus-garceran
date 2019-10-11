package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import es.upm.miw.apaw_ep_jesus_garceran.team_data.Team;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SponsorDao extends MongoRepository<Sponsor, String> {

    Team findByName(String name);
}
