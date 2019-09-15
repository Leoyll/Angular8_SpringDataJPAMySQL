package com.leo.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name="ticket_angular")	
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Date getPurDate() {
		return purDate;
	}

	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}
	
}
/*	
 *		@MappedSuperclass is used in superclass
 *		The superclass which is labeled by @MappedSuperclass can not be mapped to a table in database.
 *		The superclass which is labeled by @MappedSuperclass can not be labeled with annotation @Entity and @Table.
 */
