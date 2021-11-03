package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import main.dao.TourDAO;
import main.models.Tour;

@Controller
public class TourController {
	@Autowired
	private TourDAO tourRepository;
	
	/*@GetMapping("editTour/{id}")
	public String editTour(@PathVariable Long id, Model model) {
		Tour selectedTour = tourRepository.getById(id);
		if(selectedTour != null) {
			tourRepository.saveOrUpdate(selectedTour);
			
		}
		return "redirect:showOffer";
	}*/
	
	@GetMapping("deleteTour/{id}")
	public String deleteTour(@PathVariable Long id) {
		Tour selectedTour = tourRepository.getById(id);
		if(selectedTour != null) {
			tourRepository.delete(id);
		}
		return "redirect:showOffer";
	}

}
