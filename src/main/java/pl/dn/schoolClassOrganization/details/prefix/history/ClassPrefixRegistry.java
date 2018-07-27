package pl.dn.schoolClassOrganization.details.prefix.history;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import pl.dn.base.BaseDetail;
import pl.dn.history.Registry;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;

@Entity
public class ClassPrefixRegistry extends Registry {

	@ManyToOne
	@JoinColumn(name = "class_prefix_id")
	private ClassPrefix prefix;

	public ClassPrefix getPrefix() {
		return prefix;
	}

	public void setPrefix(ClassPrefix prefix) {
		this.prefix = prefix;
	}

	@Override
	public void setEntity(BaseDetail prefix) {
		this.prefix = (ClassPrefix) prefix;
	}

	@Override
	public ClassPrefix getEntity() {
		return prefix;
	}
}
