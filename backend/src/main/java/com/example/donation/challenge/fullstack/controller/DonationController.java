package com.example.donation.challenge.fullstack.controller;

import com.example.donation.challenge.fullstack.dto.DonationRecordDTO;
import com.example.donation.challenge.fullstack.dto.DonationResponseDTO;
import com.example.donation.challenge.fullstack.service.DonationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping
    public ResponseEntity<DonationResponseDTO> createDonation(@RequestBody DonationRecordDTO dto) {
        DonationResponseDTO created = donationService.createDonation(dto);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping
    public ResponseEntity<List<DonationResponseDTO>> findAllDonations() {
        List<DonationResponseDTO> donations = donationService.findAllDonations();
        return ResponseEntity.ok(donations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DonationResponseDTO> findDonationById(@PathVariable UUID id) {
        DonationResponseDTO donation = donationService.findDonationById(id);
        return ResponseEntity.ok(donation);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DonationResponseDTO> updateDonation(@PathVariable UUID id, @RequestBody DonationRecordDTO dto) {
        DonationResponseDTO updated = donationService.updateDonation(dto, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable UUID id) {
        donationService.deleteDonation(id);
        return ResponseEntity.noContent().build();
    }
}


