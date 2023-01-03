package com.example.calculator.utils;

public class StringUtils {
    private StringUtils() {
    }

    public static String stringCheckBeforeCalculation(String string) {
        if (string.isEmpty()) {
            return "0";
        }

        char lastChar = string.charAt(string.length() - 1);

        if (!Character.isDigit(lastChar)) {
            if (string.length() == 1) {
                return "0";
            }

            return string.substring(0, string.length() - 1);
        }

        return string;
    }

    public static String inputVerifier(String string, char button) {
        if (string.isEmpty()) {
            switch (button) {
                case ('.'):
                    return "0.";
                case ('0'):
                case ('+'):
                case ('/'):
                case ('*'):
                    return "";
            }

            return string + button;
        }

        char lastChar = string.charAt(string.length() - 1);

        if (!Character.isDigit(lastChar) && !Character.isDigit(button)) {
            String truncatedString = string.substring(0, string.length() - 1);

            switch (button) {
                case ('.'):
                    if (lastChar == '.') {
                        return string;
                    }

                    return string + "0.";
                case ('+'):
                    return truncatedString + "+";
                case ('-'):
                    return truncatedString + "-";
                case ('/'):
                    return truncatedString + "/";
                case ('*'):
                    return truncatedString + "*";
            }
        }

        return string + button;
    }

    public static String removeFirstChar(String string) {
        if (string.isEmpty()) {
            return string;
        }

        return string.substring(1);
    }
}
