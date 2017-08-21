package pl.dn.model.schoolClassOrganization.details;

import javax.persistence.*;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "")
public class CreditType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    public CreditType() {
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
}
