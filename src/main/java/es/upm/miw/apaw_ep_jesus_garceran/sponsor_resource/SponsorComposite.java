package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import java.util.LinkedList;
import java.util.List;

public class SponsorComposite implements SponsorInterface {
    private String name;
    private List<Sponsor> sponsorList;

    SponsorComposite(String name) {
        this.name = name;
        this.sponsorList = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(Sponsor sponsor) {
        this.sponsorList.add(sponsor);
    }

    @Override
    public void remove(Sponsor sponsor) {
        this.sponsorList.remove(sponsor);
    }

    @Override
    public double sumEconomicInput() {
        return this.sponsorList.stream().mapToDouble(Sponsor::sumEconomicInput).sum();
    }


}
