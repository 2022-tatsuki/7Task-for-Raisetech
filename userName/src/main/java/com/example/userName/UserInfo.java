package com.example.userName;

import org.springframework.stereotype.Service;

@Service
public class UserInfo {

    public String service(String name) {
        return switch (name) {
            case "sato" -> "佐藤太郎";
            case "yamada" -> "山田花子";
            case "ito" -> "伊藤純";
            default -> "IDが入力されていない";
        };
    }
    public int userBirthDays(String Birthdays){
        return switch (Birthdays){
            case "sato"-> 19990523;
            case "yamada"->19990422;
            case "ito"->19990623;
            default -> 0;
        };
    }
}
