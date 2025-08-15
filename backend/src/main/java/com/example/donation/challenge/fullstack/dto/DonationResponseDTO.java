package com.example.donation.challenge.fullstack.dto;

import com.example.donation.challenge.fullstack.model.enums.DonationType;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public record DonationResponseDTO(
        UUID id,
        String donorName,
        DonationType type,
        BigDecimal quantity,
        LocalDate date,
        Instant createdAt,
        Instant updatedAt
) {
}
