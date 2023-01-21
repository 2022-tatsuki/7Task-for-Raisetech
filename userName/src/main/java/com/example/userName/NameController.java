package com.example.userName;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;


@RestController
public class NameController {
    private final UserInfoService userInfoService;

    private NameController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }


    @GetMapping("/userinfo")
    public String getUserinfo(@RequestParam(value = "name", defaultValue = "name") String userName, @RequestParam(value = "name", defaultValue = "birthdays") String userBirthDay) {
        return "私の名前は" + userInfoService.getName(userName) + "です。生年月日は" + userInfoService.getUserBirthdayByName(userBirthDay) + "です。";

    }

    @GetMapping("/birthday")
    public String getBirthDay(@RequestParam(value = "name", defaultValue = "birthdays") String userBirthDay) {
        return "生年月日は" + userInfoService.getUserBirthdayByName(userBirthDay) + "です。";
    }

    @GetMapping("/names")
    public String getNames(@RequestParam(value = "name", defaultValue = "name") String userName) {
        return "私の名前は" + userInfoService.getName(userName) + "です。";
    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create( @RequestBody @Validated CreateForm form,  UriComponentsBuilder uriBuilder) {
        // 登録処理は省略 <>はジェネリクス→型に依存しない。
        String name = form.getName();
        URI url = uriBuilder
                .path("/names/" + name) // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "name successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable("id") int id) {
        return ResponseEntity.ok(Map.of("message", "name successfully deleted"));
    }
}
