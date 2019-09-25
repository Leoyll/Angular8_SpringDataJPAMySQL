package com.leo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/*
 * 	@Entity		create a table based on the class
 * 	can define the table name which will be created by jpa(hibernate) automatically if there is not a table with same name in DATABASE.
 * 	if not parameter name, a table with same name as class will be created by jpa(hibernate) automatically if there is not a table with same name in DATABASE.
 * 	@Table		define table name
 * 	@id			define as PRIMARY KEY
 * 	@Column(name = "ticket_price")	define table column name as ticket_price
 * 	@GeneratedValue(strategy=GenerationType.AUTO)	define generation strategy of PRIMARY KEY
*/

@Entity
@Table(name="ticket_angular2")
@Data	//generate getter and setter automatically with lombok tool
public class Ticket {
	@Id
	@Column (name="ticket_id", length = 16)
	private long id;
	
	@Column(name="ticket_act_name", nullable= false, length = 24)
	private String activityName;
	
	@Column(name="ticket_price", nullable= false, precision = 12, scale = 2)
	private BigDecimal price;
	
	@Column(name="ticket_buyer", length = 24)
	private String buyer;
	
	@Column(name="ticket_pur_date")	
	private Date purDate;
	
}
/*	
 *		@MappedSuperclass is used in superclass
 *		The superclass which is labeled by @MappedSuperclass can not be mapped to a table in database.
 *		The superclass which is labeled by @MappedSuperclass can not be labeled with annotation @Entity and @Table.
 */
