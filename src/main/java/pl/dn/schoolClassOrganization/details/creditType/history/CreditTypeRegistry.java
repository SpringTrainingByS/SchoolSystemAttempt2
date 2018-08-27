package pl.dn.schoolClassOrganization.details.creditType.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.dn.base.BaseDetail;
import pl.dn.history.Registry;
import pl.dn.schoolClassOrganization.Credit;
import pl.dn.schoolClassOrganization.details.creditType.CreditType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CreditTypeRegistry extends Registry {

    @ManyToOne
    @JoinColumn(name = "class_prefix_id")
    @JsonIgnore
    private CreditType creditType;

    public CreditType getCreditType() {
        return creditType;
    }

    public void setCreditType(CreditType creditType) {
        this.creditType = creditType;
    }

    @Override
    public void setEntity(BaseDetail creditType) {
        this.creditType = (CreditType) creditType;
    }

    @Override
    public CreditType getEntity() {
        return creditType;
    }

}
