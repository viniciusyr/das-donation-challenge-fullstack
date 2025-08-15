package com.example.donation.challenge.fullstack.dto;

import com.example.donation.challenge.fullstack.model.enums.DonationType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DonationRecordDTO(
        @NotNull @Size(min = 2, max = 100)
        String donorName,

        @NotNull
        DonationType type,

        @NotNull
        BigDecimal quantity,

        @NotNull
        LocalDate date
) {
}
