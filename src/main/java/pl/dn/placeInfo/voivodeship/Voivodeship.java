package pl.dn.placeInfo.voivodeship;

import javax.persistence.Entity;

import pl.dn.base.BaseDetail;

/**
 * Created by User on 10.08.2017.
 */
@Entity
public class Voivodeship extends BaseDetail {

    public Voivodeship() {
    }

    public Voivodeship(String name) {
        super(name);
    }
}
