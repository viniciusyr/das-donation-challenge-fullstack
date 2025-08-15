import { Component, EventEmitter, Output} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Donation } from './donation.model';

@Component({
  selector: 'app-donation-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './donation-form.html'
})
export class DonationForm {
  donorName = '';
  type: 'MONEY' | 'FOOD' | 'CLOTHES' | 'OTHER' = 'MONEY';
  quantity: number | null = null;
  date = '';

  @Output() donationCreated = new EventEmitter<Donation>();

  submitDonation() {
    if (!this.donorName || !this.quantity || !this.date) return;

    this.donationCreated.emit({
      donorName: this.donorName,
      type: this.type,
      quantity: this.quantity,
      date: this.date
    });

    this.donorName = '';
    this.type = 'MONEY';
    this.quantity = null;
    this.date = '';
  }
}
