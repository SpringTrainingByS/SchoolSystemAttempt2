package pl.dn.schoolClassOrganization;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pl.dn.schoolClassOrganization.details.creditType.CreditType;
import pl.dn.schoolClassOrganization.occupationalGroup.OccupationalGroup;

/**
 * Created by User on 14.08.2017.
 */

@Entity
@Table(name = "credit")
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    private CreditType creditType;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "occupational_group_id")
    private OccupationalGroup occupationalGroupId;

    @Temporal(TemporalType.DATE)
    @Column(name = "creation_date")
    private Date creationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "event_date")
    private Date event_date;

    public Credit() {
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CreditType getCreditType() {
		return creditType;
	}

	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}

	public OccupationalGroup getOccupationalGroupId() {
		return occupationalGroupId;
	}

	public void setOccupationalGroupId(OccupationalGroup occupationalGroupId) {
		this.occupationalGroupId = occupationalGroupId;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getEvent_date() {
		return event_date;
	}

	public void setEvent_date(Date event_date) {
		this.event_date = event_date;
	}
}
