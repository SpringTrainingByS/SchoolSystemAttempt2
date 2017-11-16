package pl.dn.model.inventory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Classroom {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private ClassroomType type;
	
	private int numberOfPeople;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ClassroomType getType() {
		return type;
	}

	public void setType(ClassroomType type) {
		this.type = type;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	
	
}
