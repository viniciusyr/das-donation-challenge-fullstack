package com.example.donation.challenge.fullstack.controller;

import com.example.donation.challenge.fullstack.dto.DonationRecordDTO;
import com.example.donation.challenge.fullstack.dto.DonationResponseDTO;
import com.example.donation.challenge.fullstack.model.enums.DonationType;
import com.example.donation.challenge.fullstack.service.DonationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(DonationController.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class DonationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private DonationService donationService;

    @Autowired
    private ObjectMapper objectMapper;

    private DonationResponseDTO donation;

    @BeforeEach
    void setup() {
        donation = new DonationResponseDTO(
                UUID.randomUUID(),
                "John Doe",
                DonationType.MONEY,
                BigDecimal.valueOf(100),
                LocalDate.now(),
                Instant.now(),
                Instant.now()
        );
    }

    @Test
    void testFindAllDonations() throws Exception {
        when(donationService.findAllDonations()).thenReturn(List.of(donation));

        mockMvc.perform(get("/donations"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].donorName").value("John Doe"))
                .andExpect(jsonPath("$[0].type").value("MONEY"));
    }

    @Test
    void testCreateDonation() throws Exception {
        DonationRecordDTO recordDTO = new DonationRecordDTO(
                "John Doe",
                DonationType.MONEY,
                BigDecimal.valueOf(100),
                LocalDate.now()
        );

        when(donationService.createDonation(recordDTO)).thenReturn(donation);

        mockMvc.perform(post("/donations")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(recordDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.donorName").value("John Doe"))
                .andExpect(jsonPath("$.type").value("MONEY"));
    }

    @Test
    void testFindDonationById() throws Exception {
        UUID id = donation.id();
        when(donationService.findDonationById(id)).thenReturn(donation);

        mockMvc.perform(get("/donations/{id}", id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.donorName").value("John Doe"));
    }

    @Test
    void testDeleteDonation() throws Exception {
        UUID id = donation.id();

        mockMvc.perform(delete("/donations/{id}", id))
                .andExpect(status().isNoContent());
    }
}