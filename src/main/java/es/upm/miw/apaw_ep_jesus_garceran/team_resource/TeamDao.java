package es.upm.miw.apaw_ep_jesus_garceran.team_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamDao extends MongoRepository<Team, String> {
}
