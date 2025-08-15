import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Donation } from './donation.model';

@Component({
  selector: 'app-donation-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './donation-list.html',
})
export class DonationList {
  @Input() donations: Donation[] = [];
  @Output() donationUpdated = new EventEmitter<Donation>();
  @Output() donationDeleted = new EventEmitter<number>();

  updateDonation(donation: Donation) {
    this.donationUpdated.emit(donation);
  }

  deleteDonation(id?: number) {
    if (id != null) this.donationDeleted.emit(id);
  }
}
