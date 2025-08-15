package com.example.donation.challenge.fullstack.dto;

import com.example.donation.challenge.fullstack.model.enums.DonationType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record DonationRecordDTO(
        @NotEmpty @Size(min = 2, max = 100)
        String donorName,
        DonationType type,
        BigDecimal quantity,
        LocalDate date
) {
}
