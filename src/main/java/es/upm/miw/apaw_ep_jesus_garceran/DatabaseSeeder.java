package es.upm.miw.apaw_ep_jesus_garceran;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DatabaseSeeder {



    @Autowired
    public DatabaseSeeder() {

        this.seederSponsors();
        this.seederLeague();
        this.seederTeams();
    }

    public void seederSponsors() {

    }

    public void seederLeague(){

    }

    public void seederTeams() {

    }
}
