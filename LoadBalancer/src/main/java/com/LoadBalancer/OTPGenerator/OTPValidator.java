package com.LoadBalancer.OTPGenerator;

public class OTPValidator {
    // In a real application, retrieve the stored OTP from your database based on the user's mobile number
    private static String getStoredOTP(String mobileNumber) {
        // Replace this with code to fetch the stored OTP from your database
        return "123456"; // Example: Fetch OTP for the user with the given mobile number
    }

    public static boolean validateOTP(String mobileNumber, String enteredOTP) {
        String storedOTP = getStoredOTP(mobileNumber);

        // Compare the entered OTP to the stored OTP
        return enteredOTP.equals(storedOTP);
    }

    public static void main(String[] args) {
        String mobileNumber = "+1234567890"; // Replace with the user's actual mobile number
        String enteredOTP = "123456"; // Replace with the OTP entered by the user

        boolean isValid = validateOTP(mobileNumber, enteredOTP);

        if (isValid) {
            System.out.println("OTP is valid.");
            // Allow the user to proceed with their task
        } else {
            System.out.println("OTP is invalid. Please try again.");
            // Display an error message to the user
        }
    }
}
