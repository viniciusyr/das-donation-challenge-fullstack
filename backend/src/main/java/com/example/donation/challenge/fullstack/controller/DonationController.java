package com.example.donation.challenge.fullstack.controller;

import com.example.donation.challenge.fullstack.dto.DonationRecordDTO;
import com.example.donation.challenge.fullstack.dto.DonationResponseDTO;
import com.example.donation.challenge.fullstack.service.DonationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Donations", description = "API for managing donations")
@RestController
@RequestMapping("/donations")
@CrossOrigin(origins = "http://localhost:4200")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @Operation(summary = "Create a new donation", description = "Creates a new donation and returns the created donation object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Donation created successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DonationResponseDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid donation input", content = @Content)
    })
    @PostMapping
    public ResponseEntity<DonationResponseDTO> createDonation(
            @Valid @RequestBody DonationRecordDTO dto) {
        DonationResponseDTO created = donationService.createDonation(dto);
        return ResponseEntity.status(201).body(created);
    }

    @Operation(summary = "Get all donations", description = "Returns a list of all donations")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of donations",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DonationResponseDTO.class)))
    })
    @GetMapping
    public ResponseEntity<List<DonationResponseDTO>> findAllDonations() {
        List<DonationResponseDTO> donations = donationService.findAllDonations();
        return ResponseEntity.ok(donations);
    }

    @Operation(summary = "Get a donation by ID", description = "Returns a single donation by its UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Donation found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DonationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Donation not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<DonationResponseDTO> findDonationById(@PathVariable UUID id) {
        DonationResponseDTO donation = donationService.findDonationById(id);
        return ResponseEntity.ok(donation);
    }

    @Operation(summary = "Update a donation by ID", description = "Updates an existing donation by its UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Donation updated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = DonationResponseDTO.class))),
            @ApiResponse(responseCode = "404", description = "Donation not found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid input data", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<DonationResponseDTO> updateDonation(@PathVariable UUID id, @RequestBody DonationRecordDTO dto) {
        DonationResponseDTO updated = donationService.updateDonation(dto, id);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Delete a donation by ID", description = "Deletes an existing donation by its UUID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Donation deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Donation not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDonation(@PathVariable UUID id) {
        donationService.deleteDonation(id);
        return ResponseEntity.noContent().build();
    }
}


