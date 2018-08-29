package pl.dn.schoolClassOrganization.details.specialization;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.dn.base.BaseDetail;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;
import pl.dn.schoolClassOrganization.details.specialization.history.ClassSpecializationRegistry;

import java.util.Date;
import java.util.Set;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "class_specialization")
public class ClassSpecialization extends BaseDetail{

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "specialization")
    private Set<ClassSpecializationRegistry> registries;

    public Set<ClassSpecializationRegistry> getRegistries() {
        return registries;
    }

    public void setRegistries(Set<ClassSpecializationRegistry> registries) {
        this.registries = registries;
    }
}
