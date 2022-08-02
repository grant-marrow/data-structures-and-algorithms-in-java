package com.faith.techinterview.arrays;

public class ReverseString {
    public String reverse(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }

        if (text.length() < 2) {
            return text;
        }

        final StringBuilder builder = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }
}
