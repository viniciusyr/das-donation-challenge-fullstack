import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Donation } from './donation.model';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class DonationService {
  private baseUrl = 'http://localhost:8080/donations';

  constructor(private http: HttpClient) {}

  getDonations(): Observable<Donation[]> {
    return this.http.get<Donation[]>(this.baseUrl);
  }

  createDonation(donation: Donation): Observable<Donation> {
    return this.http.post<Donation>(this.baseUrl, donation);
  }

  updateDonation(donation: Donation) {
    return this.http.put<Donation>(`http://localhost:8080/donations/${donation.id}`, donation);
  }

  deleteDonation(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
