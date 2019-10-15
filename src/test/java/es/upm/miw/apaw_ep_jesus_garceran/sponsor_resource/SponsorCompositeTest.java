package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SponsorCompositeTest {


    private SponsorComposite sponsorComposite;
    private Sponsor sponsor1;
    private Sponsor sponsor2;
    private Sponsor sponsor3;

    @BeforeEach
    public void initialize() {
        sponsor1 = new Sponsor("Adidas", 750000.00);
        sponsor2 = new Sponsor("Nike", 600000.00);
        sponsor3 = new Sponsor("Puma", 500000.00);

        sponsorComposite = new SponsorComposite("Anuncios Temporada 19/20");
        sponsorComposite.add(sponsor1);
        sponsorComposite.add(sponsor2);
        sponsorComposite.add(sponsor3);
    }

    @Test
    public void testSumEconomicInputIfComposite() {
        assertEquals("Anuncios Temporada 19/20", sponsorComposite.getName());
        assertEquals(1850000.0, sponsorComposite.sumEconomicInput());
        sponsorComposite.remove(sponsor3);
        assertEquals(1350000.0, sponsorComposite.sumEconomicInput());
    }

    @Test
    public void testSumEconomicInputWithoutComposite() {
        assertEquals(750000.00, sponsor1.sumEconomicInput());
    }

}
