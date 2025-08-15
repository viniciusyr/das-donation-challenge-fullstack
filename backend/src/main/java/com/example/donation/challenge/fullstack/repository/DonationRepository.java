package com.example.donation.challenge.fullstack.repository;

import com.example.donation.challenge.fullstack.model.DonationModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DonationRepository extends JpaRepository<DonationModel, UUID> {
}
