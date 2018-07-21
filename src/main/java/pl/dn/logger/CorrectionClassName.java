package pl.dn.logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.dn.base.BaseDetail;

@Entity
@Table(name = "correction_class_name")
public class CorrectionClassName extends BaseDetail {
	
}
