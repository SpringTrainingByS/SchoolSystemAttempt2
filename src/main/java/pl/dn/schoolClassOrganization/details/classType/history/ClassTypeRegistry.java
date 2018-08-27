package pl.dn.schoolClassOrganization.details.classType.history;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.dn.base.BaseDetail;
import pl.dn.history.Registry;
import pl.dn.schoolClassOrganization.details.classType.ClassType;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClassTypeRegistry extends Registry {

    @ManyToOne
    @JoinColumn(name = "class_type_id")
    @JsonIgnore
    private ClassType classType;

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    @Override
    public void setEntity(BaseDetail baseDetail) {
        this.classType = (ClassType) baseDetail;
    }

    @Override
    public BaseDetail getEntity() {
        return classType;
    }
}
