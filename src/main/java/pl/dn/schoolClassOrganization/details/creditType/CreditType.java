package pl.dn.schoolClassOrganization.details.creditType;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.dn.base.BaseDetail;
import pl.dn.schoolClassOrganization.details.creditType.history.CreditTypeRegistry;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;

import java.util.Set;

/**
 * Created by User on 14.08.2017.
 */
@Entity
@Table(name = "")
public class CreditType extends BaseDetail {

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "creditType")
    private Set<CreditTypeRegistry> registries;

    public Set<CreditTypeRegistry> getRegistries() {
        return registries;
    }

    public void setRegistries(Set<CreditTypeRegistry> registries) {
        this.registries = registries;
    }
}
