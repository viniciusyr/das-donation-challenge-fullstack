package com.example.donation.challenge.fullstack.mapper;

import com.example.donation.challenge.fullstack.dto.DonationRecordDTO;
import com.example.donation.challenge.fullstack.dto.DonationResponseDTO;
import com.example.donation.challenge.fullstack.model.DonationModel;

import java.time.Instant;

public class DonationMapper {
    public static DonationModel createFromRequest(DonationRecordDTO donationDto){
        return new DonationModel(
                donationDto.donorName(),
                donationDto.type(),
                donationDto.quantity(),
                donationDto.date(),
                Instant.now(),
                Instant.now()
        );
    }

    public static DonationResponseDTO toResponseDTO(DonationModel donationModel){
        return new DonationResponseDTO(
                donationModel.getId(),
                donationModel.getDonorName(),
                donationModel.getType(),
                donationModel.getQuantity(),
                donationModel.getDate(),
                donationModel.getCreatedAt(),
                donationModel.getUpdatedAt()
        );
    }

    public static void applyUpdates(DonationRecordDTO updateDto, DonationModel existingDonation){
        if(updateDto.donorName() != null){
            existingDonation.setDonorName(updateDto.donorName());
        }

        if(updateDto.type() != null){
            existingDonation.setType(updateDto.type());
        }

        if(updateDto.quantity() != null){
            existingDonation.setQuantity(updateDto.quantity());
        }

        if(updateDto.date() != null){
            existingDonation.setDate(updateDto.date());
        }

        existingDonation.setUpdatedAt(Instant.now());
    }
}
