package com.leo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.entity.Ticket;

@RestController
public class TestController {
	
	@GetMapping("/test")
	public Ticket getTicket() {
		Ticket ticket = new Ticket();
		ticket.setActivityName("test");
		
		return ticket;
	}

}
