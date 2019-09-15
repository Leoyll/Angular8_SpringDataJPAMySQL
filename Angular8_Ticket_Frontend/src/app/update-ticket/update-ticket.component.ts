import { Component, OnInit } from '@angular/core';
import { Ticket } from '../ticket';
import { Router, ActivatedRoute } from '@angular/router';
import { TicketService } from '../ticket.service';

@Component({
  selector: 'app-update-ticket',
  templateUrl: './update-ticket.component.html',
  styleUrls: ['./update-ticket.component.css']
})
export class UpdateTicketComponent implements OnInit {

  id: number;
  ticket: Ticket;
  submitted: boolean;
  date: string;

  constructor(private route: ActivatedRoute, private router: Router,
              private ticketService: TicketService) {
              }

  ngOnInit() {
    this.ticket = new Ticket();
    this.submitted = false;
    this.date = new Date().toISOString().slice(0, 16);

    this.id = this.route.snapshot.params.id;

    this.ticketService.getTicket(this.id)
      .subscribe(data => {
        console.log(data);
        this.ticket = data;
      }, error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();
  }

  save() {
    this.ticketService.updateTicket(this.id, this.ticket)
      .subscribe(data => console.log(data), error => console.log(error));
    this.ticket = new Ticket();
    this.gotoList();
  }


  gotoList() {
    this.router.navigate(['/tickets']);
  }

  private toDateString(date: Date): string {
    return (date.getFullYear().toString() + '-'
       + ('0' + (date.getMonth() + 1)).slice(-2) + '-'
       + ('0' + (date.getDate())).slice(-2))
       + 'T' + date.toTimeString().slice(0, 5);
}
}
