package com.leo.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leo.entity.Ticket;

@Repository
//CrudRepository<Ticket, Long>: relative service should be Long as well.
public interface ITicketRepository extends CrudRepository<Ticket, Long>{
	//JPQL query
	@Query("FROM #{#entityName} c where c.activityName like %?1%")
	List<Ticket> findNameLike1(String nameLike1);

}
