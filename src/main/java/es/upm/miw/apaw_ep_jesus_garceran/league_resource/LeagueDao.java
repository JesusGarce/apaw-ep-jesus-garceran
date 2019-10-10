package es.upm.miw.apaw_ep_jesus_garceran.league_resource;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LeagueDao extends MongoRepository<League, String> {
}
