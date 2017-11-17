package pl.dn.model.placeInfo;

import javax.persistence.*;

/**
 * Created by User on 10.08.2017.
 */
@Entity
public class Voivodeship extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public Voivodeship() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Voivodeship{" +
                "id=" + id +
                '}';
    }
}
