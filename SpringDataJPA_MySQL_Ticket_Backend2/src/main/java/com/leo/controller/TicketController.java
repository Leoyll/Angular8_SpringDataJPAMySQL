package com.leo.controller;

import java.util.List;
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
		return ticketService.findById(id)
				.map(record->ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
    }	
	
	/*
	 * A ticket with a certain Number is updated.
	 */
	@PutMapping("/tickets/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long number, @Valid @RequestBody Ticket ticketDetails) {
		return ticketService.findById(number)
				.map(record->{
					record.setActivityName(ticketDetails.getActivityName());
					record.setBuyer(ticketDetails.getBuyer());
					record.setPrice(ticketDetails.getPrice());
					record.setPurDate(ticketDetails.getPurDate());
					Ticket updatedTicket = ticketService.save(record);
					return ResponseEntity.ok().body(updatedTicket);
				}).orElse(ResponseEntity.notFound().build());
    }
    
	/*
	 * Ticket with a certain Number is deleted.
	 */
	@DeleteMapping("/tickets/{id}")
    public ResponseEntity<?> deleteTicket(@PathVariable(value = "id") Long number){
		return ticketService.findById(number)
				.map(record->{
					ticketService.delete(number);
					return ResponseEntity.ok().build();
				}).orElse(ResponseEntity.notFound().build());
    }

}
