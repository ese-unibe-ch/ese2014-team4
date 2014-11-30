package ch.unibe.ese2014.team4.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.IndexColumn;

@Entity
public class Visit {
	
	@Id
    @GeneratedValue
    private Long id;
	private String date;
	private String startTime;
	private String endTime;
	
	@IndexColumn(name="LIST_INDEX")
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "visitorList", joinColumns = @JoinColumn(name = "user_id"))
	private List<User> visitorList = new ArrayList<User>();
	
	public String toString(){
		return date + ", between " + startTime + " and " + endTime;
			
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
	
	

}
