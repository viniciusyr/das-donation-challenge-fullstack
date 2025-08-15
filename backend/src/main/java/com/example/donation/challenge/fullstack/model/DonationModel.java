package com.example.donation.challenge.fullstack.model;

import com.example.donation.challenge.fullstack.model.enums.DonationType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_DONATIONS")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DonationModel {

    @Id
    @GeneratedValue()
    private UUID id;
    private String donorName;
    private DonationType type;
    private BigDecimal quantity;
    private LocalDate date;

    @Timestamp
    private Instant createdAt;
    @Timestamp
    private Instant updatedAt;

    public DonationModel(String donorName, DonationType type, BigDecimal quantity, LocalDate date, Instant createdAt, Instant updatedAt) {
        this.donorName = donorName;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
