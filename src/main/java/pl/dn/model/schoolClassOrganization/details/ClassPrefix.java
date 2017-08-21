package pl.dn.model.schoolClassOrganization.details;

import javax.persistence.*;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "class_prefix")
public class ClassPrefix {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    public ClassPrefix() {
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
