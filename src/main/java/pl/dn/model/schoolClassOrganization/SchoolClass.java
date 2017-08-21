package pl.dn.model.schoolClassOrganization;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "school_class")
public class SchoolClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "specialization_id")
    private long specializationId;

    @Column(name = "type_id")
    private long typeId;

    @Column(name = "prefix_id")
    private long prefix_id;

    public SchoolClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(long specializationId) {
        this.specializationId = specializationId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public long getPrefix_id() {
        return prefix_id;
    }

    public void setPrefix_id(long prefix_id) {
        this.prefix_id = prefix_id;
    }
}
