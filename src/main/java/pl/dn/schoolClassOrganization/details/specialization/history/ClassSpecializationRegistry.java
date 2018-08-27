package pl.dn.schoolClassOrganization.details.specialization.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.dn.base.BaseDetail;
import pl.dn.history.Registry;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;
import pl.dn.schoolClassOrganization.details.specialization.ClassSpecialization;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassSpecializationRegistry  extends Registry {

    @ManyToOne
    @JoinColumn(name = "class_prefix_id")
    @JsonIgnore
    private ClassSpecialization specialization;

    public ClassSpecialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(ClassSpecialization specialization) {
        this.specialization = specialization;
    }

    @Override
    public void setEntity(BaseDetail specialization) {
        this.specialization = (ClassSpecialization) specialization;
    }

    @Override
    public BaseDetail getEntity() {
        return this.specialization;
    }
}
