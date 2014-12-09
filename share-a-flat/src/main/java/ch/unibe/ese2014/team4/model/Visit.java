package ch.unibe.ese2014.team4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.IndexColumn;
import org.hibernate.annotations.Type;

@Entity
public class Visit {
	
	@Id
    @GeneratedValue
    private Long id;
	private String date;
	private String startTime;
	private String endTime;
	
	
	private long adId;
	
    @ManyToMany( fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name = "visits_user", joinColumns = @JoinColumn(name = "visit_id", referencedColumnName = "id"), 
     inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"))
    @GenericGenerator(name="hilo-gen", strategy="hilo")
    @CollectionId(columns = @Column(name = "COL_ID"), generator = "hilo-gen", type = @Type(type="int"))
	private List<User> visitorList = new ArrayList<User>();
	
	public String toString(){
		return date + ", " + startTime + " - " + endTime;
			
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public List<User> getVisitorList() {
		return visitorList;
	}
	public void setVisitorList(List<User> visitorList) {
		this.visitorList = visitorList;
	}

	public long getAdId() {
		return adId;
	}

	public void setAdId(long adId) {
		this.adId = adId;
	}
	
	

}
