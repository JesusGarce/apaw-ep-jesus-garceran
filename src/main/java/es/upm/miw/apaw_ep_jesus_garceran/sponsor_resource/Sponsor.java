package es.upm.miw.apaw_ep_jesus_garceran.sponsor_resource;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sponsor {

    @Id
    private String id;

    @UniqueElements
    private String name;

    private double economicInput;

    public Sponsor(String name, double economicInput) {
        this.name = name;
        this.economicInput = economicInput;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getEconomicInput() {
        return economicInput;
    }

    @Override
    public String toString() {
        return "Sponsor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", economicInput=" + economicInput +
                '}';
    }
}
