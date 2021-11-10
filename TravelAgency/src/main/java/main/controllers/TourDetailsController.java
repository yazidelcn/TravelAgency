package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.models.Tour;
import main.models.TourDetails;
import main.services.TourDetailsService;
import main.services.TourService;

@Controller
public class TourDetailsController {
	@Autowired
	private TourDetailsService tourDetailsService;
	@Autowired
	private TourService tourService;
	
	@GetMapping("/showTourDetails/{tourId}")
	public String showTourDetails(@PathVariable Long tourId, Model model) {
		Tour tour = tourService.getById(tourId);
		if(tour != null) {
			tourService.addTourDetailsIfNotExist(tour);
			model.addAttribute("tour", tour);
			return "tour-details";
		}
		
		return "redirect:/showOffer";
	}
	
	@GetMapping("/editTourDetails/{tourId}")
	public String editTourDetails(@PathVariable Long tourId, Model model) {
		Tour tour = tourService.getById(tourId);
		if(tour != null) {
			tourService.addTourDetailsIfNotExist(tour);
			TourDetails tourDetails = tour.getTourDetails();
			model.addAttribute("tourDetails", tourDetails);
			return "form-tour-details";
		}
		
		return "redirect:/showOffer";
	}
	
	@PostMapping("/processFormTourDetails")
	public String processFrom(@ModelAttribute TourDetails tourDetails){
		tourDetailsService.saveOrUpdate(tourDetails);
		return "redirect:/showOffer";
	}

}
