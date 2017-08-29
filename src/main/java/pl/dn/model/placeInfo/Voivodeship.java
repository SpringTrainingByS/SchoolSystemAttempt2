package pl.dn.model.placeInfo;

import javax.persistence.*;

/**
 * Created by User on 10.08.2017.
 */
@Entity
public class Voivodeship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;



    public Voivodeship() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Voivodeship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
