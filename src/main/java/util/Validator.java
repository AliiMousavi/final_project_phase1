package util;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean isValidPassword(String password){
        String pattern = "^(?=.*[a-zA-Z])(?=.*\\d)[a-zA-Z\\d]{8}$";
        return Pattern.matches(pattern,password);
    }

    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return Pattern.matches(emailRegex,email);
    }

    public static boolean isValidImage(File file){
        String fileName = file.getName();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
        if (!fileExtension.equalsIgnoreCase("jpg")) {
            System.out.println("File format must be JPG.");
            return false;
        }
        long fileSize = file.length();
        long maxSize = 300 * 1024;
        if (fileSize > maxSize) {
            System.out.println("File size exceeds 300 KB.");
            return false;
        }
        return true;
    }

}
