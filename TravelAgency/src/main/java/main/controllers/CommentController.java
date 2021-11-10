package main.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import main.models.Comment;
import main.models.Tour;
import main.services.CommentService;
import main.services.TourService;

@Controller
public class CommentController {
	@Autowired
	private TourService tourService;
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/addComment")
	public String showCommentForm(Model model) {
		List<Tour> tours = tourService.findAll();
		model.addAttribute("tours", tours);
		model.addAttribute("comment", new Comment());
		return "comment-form";
	}
	
	@PostMapping("/processCommentFrom")
	public String addComment(@ModelAttribute Comment comment) {
		commentService.saveComment(comment);
		return "redirect:/showOffer";
	}
}
