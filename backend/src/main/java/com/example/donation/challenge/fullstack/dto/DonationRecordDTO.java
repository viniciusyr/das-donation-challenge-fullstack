package com.example.donation.challenge.fullstack.dto;

import com.example.donation.challenge.fullstack.model.enums.DonationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DonationRecordDTO(
        @Schema(description = "Name of the donor", example = "John Doe")
        @NotNull @Size(min = 2, max = 40)
        String donorName,

        @Schema(description = "Type of donation", example = "MONEY")
        @NotNull
        DonationType type,

        @Schema(description = "Quantity of the donation", example = "10")
        @NotNull
        BigDecimal quantity,

        @Schema(description = "Date of the donation", example = "2025-08-15")
        @NotNull
        LocalDate date
) {
}
