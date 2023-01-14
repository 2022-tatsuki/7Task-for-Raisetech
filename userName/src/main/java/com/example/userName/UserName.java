package com.example.userName;

import org.springframework.stereotype.Service;

@Service
public class UserName {

    public String service(String name) {
        return switch (name) {
            case "sato" -> "佐藤太郎";
            case "yamada" -> "山田花子";
            case "ito" -> "伊藤純";
            default -> "IDが入力されていない";
        };
    }
}
