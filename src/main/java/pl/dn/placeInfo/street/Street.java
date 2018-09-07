package pl.dn.placeInfo.street;

import javax.persistence.Entity;

import pl.dn.base.BaseDetail;

/**
 * Created by User on 10.08.2017.
 */
@Entity
public class Street extends BaseDetail {

    public Street() {
    }

    public Street(String name) {
        super(name);
    }
}
