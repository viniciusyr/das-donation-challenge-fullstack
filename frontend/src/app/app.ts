import { Component} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { DonationService } from './donation/donation.service';
import { DonationForm } from './donation/donation-form';
import { DonationList } from './donation/donation-list';
import { Donation } from './donation/donation.model';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, FormsModule, DonationForm, DonationList],
  templateUrl: './app.html',
  styles: [`
    .modal {
      position: fixed; top: 50%; left: 50%;
      transform: translate(-50%, -50%);
      background: white; padding: 1rem; border: 1px solid #ccc;
      z-index: 1000;
    }
  `]
})
export class App {
  donations: Donation[] = [];
  editingDonation: Donation | null = null;

  constructor(private donationService: DonationService) {
    this.loadDonations();
  }

  loadDonations() {
    this.donationService.getDonations().subscribe(data => this.donations = data);
  }

  addDonation(donation: Donation) {
    this.donationService.createDonation(donation).subscribe(() => this.loadDonations());
  }

  removeDonation(id: number) {
    this.donationService.deleteDonation(id).subscribe(() => this.loadDonations());
  }

  openEditModal(donation: Donation) {
    this.editingDonation = { ...donation };
  }

  closeEditModal() {
    this.editingDonation = null;
  }

  saveEdit() {
    if (!this.editingDonation) return;
    this.donationService.updateDonation(this.editingDonation)
      .subscribe(() => {
        this.loadDonations();
        this.closeEditModal();
      });
  }
}
