package kr.co.swh.lecture.springboot;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="diseasePlace")
public class ExchangeValue {
	
	@Id
	private int Id;
	
	private String date;
	
	private String place;
	
	private String disease;
	
	private int caused;
	

    public ExchangeValue() {
		// TODO Auto-generated constructor stub
	}
    
    
    public ExchangeValue(String date, String place, String disease, int caused, int Id) {
        super();
        this.Id = Id;
        this.date = date;
        this.place = place;
        this.disease = disease;
        this.caused = caused;
    }
    

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public int getCaused() {
		return caused;
	}

	public void setCaused(int caused) {
		this.caused = caused;
	}
    
}
