package pl.dn.model.timeOrganization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pl.dn.model.inventory.Classroom;
import pl.dn.model.schoolClassOrganization.OccupationalGroup;

@Entity
@Table(name = "school_class_hour")
public class SchoolClassHour {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne
	@JoinColumn(name = "school_hour_id")
	private SchoolHour schoolHour;
	
	@ManyToOne
	@JoinColumn(name = "school_day_id")
	private SchoolDay schoolDay;
	
	@ManyToOne
	@JoinColumn(name = "classroom_id")
	private Classroom classroom;
	
	@ManyToOne
	@JoinColumn(name = "occupational_group_id")
	private OccupationalGroup occupationalGroup;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public SchoolHour getSchoolHour() {
		return schoolHour;
	}

	public void setSchoolHour(SchoolHour schoolHour) {
		this.schoolHour = schoolHour;
	}

	public SchoolDay getSchoolDay() {
		return schoolDay;
	}

	public void setSchoolDay(SchoolDay schoolDay) {
		this.schoolDay = schoolDay;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public OccupationalGroup getOccupationalGroup() {
		return occupationalGroup;
	}

	public void setOccupationalGroup(OccupationalGroup occupationalGroup) {
		this.occupationalGroup = occupationalGroup;
	}
	
	
}
