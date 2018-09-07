package pl.dn.placeInfo.zipCode;

import javax.persistence.Entity;

import pl.dn.base.BaseDetail;

/**
 * Created by User on 10.08.2017.
 */
@Entity
public class ZipCode extends BaseDetail {

    public ZipCode() {
    }

    public ZipCode(String name) {
        super(name);
    }
}
