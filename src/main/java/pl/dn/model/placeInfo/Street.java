package pl.dn.model.placeInfo;

import javax.persistence.*;

/**
 * Created by User on 10.08.2017.
 */
@Entity
public class Street extends Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Street() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Street{" +
                "id=" + id +
                '}';
    }
}
