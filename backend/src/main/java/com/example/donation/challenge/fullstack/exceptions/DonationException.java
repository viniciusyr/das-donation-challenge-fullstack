package com.example.donation.challenge.fullstack.exceptions;

public class DonationException extends RuntimeException {
    public DonationException(String message) {
        super(message);
    }

    public static class DonationNotFound extends DonationException {
        public DonationNotFound(String message) {
            super(message);
        }
    }
}
