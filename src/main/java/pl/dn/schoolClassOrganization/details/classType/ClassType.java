package pl.dn.schoolClassOrganization.details.classType;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.dn.base.BaseDetail;
import pl.dn.schoolClassOrganization.details.classType.history.ClassTypeRegistry;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;

import java.util.Set;

/**
 * Created by User on 14.08.2017.
 */
@Entity
public class ClassType extends BaseDetail {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classType")
    private Set<ClassTypeRegistry> registries;

    public Set<ClassTypeRegistry> getRegistries() {
        return registries;
    }

    public void setRegistries(Set<ClassTypeRegistry> registries) {
        this.registries = registries;
    }
}
