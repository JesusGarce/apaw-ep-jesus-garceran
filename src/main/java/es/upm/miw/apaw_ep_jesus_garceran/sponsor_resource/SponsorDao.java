package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SponsorDao extends MongoRepository<Sponsor, String> {
}
