package com.example.userName;

import org.springframework.stereotype.Service;

@Service
public class BirthDay {
    public String birthday(String birthdays) {
        return switch (birthdays) {
            case "sato" -> "4月1日";
            case "yamada" -> "6月1日";
            case "ito" -> "7月7日";
            default -> "IDが入力されていません。";
        };
    }
}
