package com.leo.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.leo.DAO.ITicketRepository;
import com.leo.entity.Ticket;

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
	
	public Ticket findById(long id) {
		return ticketRepository.findById(id).get();	
	}
	
	public Iterable<Ticket> findAll(){
		return ticketRepository.findAll();
	}
		
}
