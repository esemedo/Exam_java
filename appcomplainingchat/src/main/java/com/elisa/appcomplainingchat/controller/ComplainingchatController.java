package com.elisa.appcomplainingchat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.HttpStatusCodeException;

import com.elisa.appcomplainingchat.model.User;
import com.elisa.appcomplainingchat.service.MessageService;
import com.elisa.appcomplainingchat.service.QuoteApiService;
import com.elisa.appcomplainingchat.service.UserService;

@Controller
public class ComplainingchatController {
	MessageService messageService;
	QuoteApiService quoteApiService;
	UserService userService;
	private User currentUser;
	
	public ComplainingchatController(MessageService messageService, QuoteApiService quoteApiService, UserService userService) {
		this.messageService = messageService;
		this.quoteApiService = quoteApiService;
		this.userService = userService;
	}
	@GetMapping("chat")
	public String getChat(Model model) {
		//A enlever
		//this.currentUser = userService.findOrCreateUser("noemie");
		if(this.currentUser == null) {
			return "redirect:/user";
		}else {
			model.addAttribute("allMessages", this.messageService.findMessagesByUser(currentUser));
		}
		model.addAttribute("username", this.currentUser.getFirstname()+" "+ this.currentUser.getLastname());
		return "chat";
	}
	@GetMapping("user")
	public String getUser(Model model) {
		this.currentUser = null;
		return "formUser";
	}
	
	@GetMapping("/")
	public String getHome(Model model) {
		return "redirect:/chat";
	}
	@PostMapping("submitMessage")
	public String postForm(Model model, @RequestParam String message) {
			if(currentUser == null) {
				return "redirect:/user";
			}
			messageService.saveMessage(message, currentUser, quoteApiService.getQuote().getQuotes());
			return "redirect:/chat";
	}
	@PostMapping("submitUser")
	public String postUser(Model model, @RequestParam String firstname,  @RequestParam String lastname) {
		this.currentUser = userService.findOrCreateUser(firstname, lastname);
		return "redirect:/chat";
	}
}
