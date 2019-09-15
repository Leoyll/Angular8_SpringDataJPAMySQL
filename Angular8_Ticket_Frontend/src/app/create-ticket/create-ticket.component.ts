import { TicketService } from '../ticket.service';
import { Ticket } from '../ticket';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-ticket',
  templateUrl: './create-ticket.component.html',
  styleUrls: ['./create-ticket.component.css']
})
export class CreateTicketComponent implements OnInit {

  ticket: Ticket = new Ticket();
  submitted = false;

  constructor(private ticketService: TicketService,
              private router: Router) { }

  ngOnInit() {
  }

  newTicket(): void {
    this.submitted = false;
    this.ticket = new Ticket();
  }

  save() {
    this.ticketService.createTicket(this.ticket)
      .subscribe(data => console.log(data), error => console.log(error));
    this.ticket = new Ticket();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  gotoList() {
    this.router.navigate(['/tickets']);
  }
}
