package com.example.userName;

import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    public String getName(String name) {
        return switch (name) {
            case "sato" -> "佐藤太郎";
            case "yamada" -> "山田花子";
            case "ito" -> "伊藤純";
            default -> "nameが入力されていない";
        };
    }

    public int getUserBirthdayByName(String name) {
        return switch (name) {
            case "sato" -> 19990523;
            case "yamada" -> 19990422;
            case "ito" -> 19990623;
            default -> 0;
        };
    }
}
