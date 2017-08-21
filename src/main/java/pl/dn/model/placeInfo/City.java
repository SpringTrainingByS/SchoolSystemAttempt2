package pl.dn.model.placeInfo;

import javax.persistence.*;

/**
 * Created by User on 10.08.2017.
 */
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @Column(name = "voivodeship_id", insertable = false, updatable = false)
    private long voivodeshipId;

    @ManyToOne
    @JoinColumn(name = "voivodeship_id")
    private Voivodeship voivodeship;

    public City() {}


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

    public long getVoivodeshipId() {
        return voivodeshipId;
    }

    public void setVoivodeshipId(long voivodeshipId) {
        this.voivodeshipId = voivodeshipId;
    }

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }
}
