package main.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tour_details")
public class TourDetails {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String country;
	@Column(length = 2000)
	private String description;
	
	/*for bidirectional 
	@OneToOne(mappedBy = "tourDetails")
	private Tour tour;*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	/*public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	*/
	
}
