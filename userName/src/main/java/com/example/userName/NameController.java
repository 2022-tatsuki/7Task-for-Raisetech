package com.example.userName;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;


@RestController
@RequestMapping("/User")
public class NameController {
    private final UserName userName;

    private NameController(UserName userName) {
        this.userName = userName;
    }

    @GetMapping("/names")
    public String getNames(@RequestParam(value = "name", defaultValue = "name") String UserName) {
        return "私の名前は" + userName.service(UserName) + "です。";

    }

    @PostMapping("/names")
    public ResponseEntity<Map<String, String>> create(@RequestBody CreateForm form) {
        // 登録処理は省略 <>はジェネリクス→型に依存しない。
        URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
                .path("/names/id") // id部分は実際に登録された際に発⾏したidを設定する
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message","name successfully created"));
    }

    @PatchMapping("/names/{id}")
    public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id, @RequestBody UpdateForm form) {
        return ResponseEntity.ok(Map.of("message", "name successfully updated"));
    }

    @DeleteMapping("/names")
    public String deleteList() {
        return "delete names list";
    }
}
