package com.leo.service;

import java.util.Optional;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.leo.entity.Ticket;
import com.leo.repository.ITicketRepository;

@Service
public class TicketService {
//	@Autowired
	@Resource
	private ITicketRepository ticketRepository;
	
	@Transactional
	public Ticket save(Ticket ticket) {
		return ticketRepository.save(ticket);
	}
	
	@Transactional
	public void delete(long id) {
		ticketRepository.deleteById(id);
	}
	
	public Optional<Ticket> findById(long id) {
		return ticketRepository.findById(id);	
	}
	
	public Iterable<Ticket> findAll(){
		return ticketRepository.findAll();
	}
		
}
