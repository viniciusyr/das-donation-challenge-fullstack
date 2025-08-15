package com.example.donation.challenge.fullstack.dto;

import com.example.donation.challenge.fullstack.model.enums.DonationType;
import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Schema(description = "Donation response object returned by the API")
public record DonationResponseDTO(
        @Schema(description = "Unique identifier of the donation", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
        UUID id,

        @Schema(description = "Name of the donor", example = "John Doe")
        String donorName,

        @Schema(description = "Type of donation", example = "MONEY")
        DonationType type,

        @Schema(description = "Quantity of the donation", example = "100.50")
        BigDecimal quantity,

        @Schema(description = "Date of the donation", example = "2025-08-15")
        LocalDate date,

        @Schema(description = "Timestamp when the donation was created", example = "2025-08-15T14:30:00Z")
        Instant createdAt,

        @Schema(description = "Timestamp when the donation was last updated", example = "2025-08-16T10:15:00Z")
        Instant updatedAt
) {}
