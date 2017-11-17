package pl.dn.model.placeInfo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.MappedSuperclass;

/**
 * Created by User on 01.09.2017.
 */

@MappedSuperclass
public class Place {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                '}';
    }

    @JsonIgnore
    public boolean isNameEmpty() {

        if (name == null || name.isEmpty()) {
            return true;
        }

        return false;
    }
}
