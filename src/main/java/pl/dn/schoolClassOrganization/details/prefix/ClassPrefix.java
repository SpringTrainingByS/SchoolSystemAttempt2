package pl.dn.schoolClassOrganization.details.prefix;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import pl.dn.base.BaseDetail;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "class_prefix")
@DynamicUpdate
public class ClassPrefix extends BaseDetail {
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "prefix")
	private Set<ClassPrefixRegistry> registries;

	public Set<ClassPrefixRegistry> getRegistries() {
		return registries;
	}

	public void setRegistries(Set<ClassPrefixRegistry> registries) {
		this.registries = registries;
	}
}
