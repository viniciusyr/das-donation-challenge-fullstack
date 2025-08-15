package com.example.donation.challenge.fullstack.service;

import com.example.donation.challenge.fullstack.dto.DonationRecordDTO;
import com.example.donation.challenge.fullstack.dto.DonationResponseDTO;
import com.example.donation.challenge.fullstack.exceptions.DonationException;
import com.example.donation.challenge.fullstack.mapper.DonationMapper;
import com.example.donation.challenge.fullstack.model.DonationModel;
import com.example.donation.challenge.fullstack.repository.DonationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
public class DonationService {

    private final DonationRepository donationRepository;

    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public DonationResponseDTO createDonation(DonationRecordDTO donationDto) {
        if(donationDto == null){
            throw new DonationException.DonationNotFound("Donation DTO is null!");
        }

        DonationModel donation = DonationMapper.createFromRequest(donationDto);
        donationRepository.save(donation);

        log.info("Donation created successfully: {}", donation.getId());
        return DonationMapper.toResponseDTO(donation);
    }

    public DonationResponseDTO updateDonation(DonationRecordDTO updateDto, UUID id){
        DonationModel existingDonation = donationRepository.findById(id)
                .orElseThrow(() -> new DonationException.DonationNotFound("Donation not found: " + id));

        DonationMapper.applyUpdates(updateDto, existingDonation);
        DonationModel updatedDonation = donationRepository.save(existingDonation);

        log.info("Donation updated successfully: {}", updatedDonation.getId());
        return DonationMapper.toResponseDTO(updatedDonation);
    }

    public void deleteDonation(UUID id) {
        DonationModel existingDonation = donationRepository.findById(id)
                .orElseThrow(() -> new DonationException.DonationNotFound("Donation not found: " + id));

        log.info("Donation successfully deleted: {}", id);
        donationRepository.delete(existingDonation);
    }

    public DonationResponseDTO findDonationById(UUID id) {
        DonationModel donation = donationRepository.findById(id)
                .orElseThrow(() -> new DonationException.DonationNotFound("Donation not found: " + id));

        return DonationMapper.toResponseDTO(donation);
    }

    public List<DonationResponseDTO> findAllDonations() {
        return donationRepository.findAll()
                .stream()
                .map(DonationMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

}
