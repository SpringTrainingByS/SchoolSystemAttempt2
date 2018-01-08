package pl.dn.model.schoolClassOrganization.details;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import pl.dn.model.base.BaseDetail;

/**
 * Created by User on 11.08.2017.
 */
@Entity
@Table(name = "class_prefix")
@DynamicUpdate
public class ClassPrefix extends BaseDetail {
	
}
