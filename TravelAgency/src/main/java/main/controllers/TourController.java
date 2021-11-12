package main.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import main.models.Tour;
import main.services.TourService;

@Controller
public class TourController {
	@Autowired
	private TourService tourService;
	

	@GetMapping("/addTour")
	public String showForm(Model model) {
		model.addAttribute("tour", new Tour());
		return "form";
	}
	
	@PostMapping("/processForm")
	public String showFormData(@Valid @ModelAttribute Tour tour, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return "form";
		}
		tourService.saveOrUpdate(tour);
		return "redirect:/showOffer";
	}
	
	@GetMapping("/showOffer")
	public String getTours(Model model) {
		List<Tour> tours = tourService.findAll();
		model.addAttribute("tours", tours);
		return "tours";
	}
	
	@GetMapping("/editTour/{id}")
	public String editTour(@PathVariable Long id, Model model) {
		Tour tour = tourService.getById(id);
		System.out.println(tour);
		System.out.println(id);
		if(tour != null) {
			
			model.addAttribute("tour", tour);	
			return "form";
		}
		return "redirect:/showOffer";
	}
	
	@GetMapping("/deleteTour/{id}")
	public String deleteTour(@PathVariable Long id) {
		Tour selectedTour = tourService.getById(id);
		if(selectedTour != null) {
			tourService.delete(id);
		}
		return "redirect:/showOffer";
	}
	
	@GetMapping("/addUserToTour/{id}/{userId}")
	public String addUserToTour(@PathVariable Long id, @PathVariable Long userId) {
		tourService.addUserToTour(id, userId);
		return "redirect:/showOffer";
	}

}
