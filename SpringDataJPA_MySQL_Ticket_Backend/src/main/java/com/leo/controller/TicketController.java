package com.leo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.leo.entity.Ticket;
import com.leo.service.TicketService;

//To enable CORS on the server, add a @CrossOrigin annotation
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class TicketController {
//	@Autowired
	@Resource
	private TicketService ticketService;	

	/**
	 * fetch all tickets
	 * @return
	 */	
	@GetMapping(value="/tickets")
	public List<Ticket> getAllTickets() {
        return (List<Ticket>) ticketService.findAll();
    }
	
	/*
	 * A new ticket is created.
	 * @return
	 */
	@PostMapping("/tickets")
    public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
        return ticketService.save(ticket);
    }
	
	/*
	 * One ticket with a certain Number is fetched.
	 */
	@GetMapping("/tickets/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable(value = "id") Long id) {
		Ticket ticket = ticketService.findById(id);
        return ResponseEntity.ok().body(ticket);
    }	
	
	/*
	 * A ticket with a certain Number is updated.
	 */
	@PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long number, @Valid @RequestBody Ticket ticketDetails) {
		Ticket ticket = ticketService.findById(number);

		ticket.setActivityName(ticketDetails.getActivityName());
		ticket.setBuyer(ticketDetails.getBuyer());
//		ticket.setId(ticketDetails.getId());	//don't need update
		ticket.setPrice(ticketDetails.getPrice());
		ticket.setPurDate(ticketDetails.getPurDate());
        final Ticket updatedTicket = ticketService.save(ticket);
        return ResponseEntity.ok(updatedTicket);
    }
    
	/*
	 * Ticket with a certain Number is deleted.
	 */
	@DeleteMapping("/tickets/{id}")
    public Map<String, Boolean> deleteTicket(@PathVariable(value = "id") Long number){
		ticketService.delete(number);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
