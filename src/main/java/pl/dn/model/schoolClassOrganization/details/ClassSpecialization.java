package pl.dn.model.schoolClassOrganization.details;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "class_specialization")
public class ClassSpecialization {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;


    public ClassSpecialization() {
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
