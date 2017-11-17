package pl.dn.model.timeOrganization;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pl.dn.model.schoolClassOrganization.OccupationalGroup;
import pl.dn.model.userType.User;

@Entity
public class Absence {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

	@ManyToOne
	@JoinColumn(name = "stduent_id")
	private User student;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_of_occuernce")
	private Date dateOfOccurence;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "insert_date")
	private Date insertDate;
	
	@ManyToOne
	@JoinColumn(name = "school_hour_id")
	private SchoolHour schoolHour;
	
	@ManyToOne
	@JoinColumn(name = "occupational_group_id")
	private OccupationalGroup occupationalGroup;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}

	public Date getDateOfOccurence() {
		return dateOfOccurence;
	}

	public void setDateOfOccurence(Date dateOfOccurence) {
		this.dateOfOccurence = dateOfOccurence;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public SchoolHour getSchoolHour() {
		return schoolHour;
	}

	public void setSchoolHour(SchoolHour schoolHour) {
		this.schoolHour = schoolHour;
	}

	public OccupationalGroup getOccupationalGroup() {
		return occupationalGroup;
	}

	public void setOccupationalGroup(OccupationalGroup occupationalGroup) {
		this.occupationalGroup = occupationalGroup;
	}
	
	
}
