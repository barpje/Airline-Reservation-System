package com.ARSproject.utils;

public class ReservationUtil {
    private static  boolean hasLetter(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(Character.isLetter(c)) {
                return true;
            }
        }
        return false;
    }
    private static  boolean hasNumber(String name) {
        char[] chars = name.toCharArray();

        for (char c : chars) {
            if(Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkData(String email, String password,
                                    String name, String surname,
                                    String address, String phone){
        if(email.length() < 4 || (!email.contains("@")) || (!email.contains(".")) || email.length() > 40)
            return false;
        if(password.length() < 5 || password.length() > 50) return false;
        if(name.length() < 2 || hasNumber(name) || name.length() > 50) return false;
        if(surname.length() < 3 || hasNumber(surname) || surname.length() > 50) return false;
        if(address.length() < 3 || address.length() > 200) return false;
        if(phone.length() < 9 || hasLetter(phone) || phone.length() > 15) return false;
        return true;
    }
}
