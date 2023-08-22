package com.LoadBalancer.OTPGenerator;

import java.util.Random;

public class OTPGenerator {
    private static final String OTP_CHARS = "0123456789";
    private static final int OTP_LENGTH = 6;

    // Generate a random OTP
    public static String generateOTP() {
        StringBuilder otp = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < OTP_LENGTH; i++) {
            int index = random.nextInt(OTP_CHARS.length());
            otp.append(OTP_CHARS.charAt(index));
        }

        return otp.toString();
    }

    // In a real application, this method would send the OTP to the user's mobile number via SMS
    public static void sendOTP(String mobileNumber, String otp) {
        // Implement the code to send the OTP to the user's mobile number
        // You might use a third-party SMS gateway service for this
        System.out.println("Sending OTP to " + mobileNumber + ": " + otp);
    }

    public static void main(String[] args) {
        String mobileNumber = "+917829326858"; // Replace with the user's actual mobile number
        String otp = generateOTP();

        sendOTP(mobileNumber, otp);

        // Store the OTP in a secure manner (e.g., database) for later validation
    }
}

