package pl.dn.model.timeOrganization;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Absence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@ManyToOne
	@JoinColumn(name = "stduent_id")
	private User student;
	
	private Date date;
	
	private SchoolHour schoolHour;
	
	private OccupationalGroup occupationGroup
}
