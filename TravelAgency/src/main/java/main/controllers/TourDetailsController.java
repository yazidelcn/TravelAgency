package main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import main.services.TourDetailsService;

@Controller
public class TourDetailsController {
	@Autowired
	private TourDetailsService tourDetailsService;
	
	

}
