package edu.du.redis2.controller;

import edu.du.redis2.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/redis")
@RequiredArgsConstructor
public class RedisController {
    private final RedisService redisService;

    @PostMapping("/save")
    public String saveData(@RequestParam String key, @RequestParam String value, @RequestParam long timeout) {
        redisService.saveValue(key, value, timeout);
        return "저장 완료: " + key;
    }

    @GetMapping("/get")
    public String getData(@RequestParam String key) {
        String value = redisService.getValue(key);
        return value != null ? "조회 결과: " + value : "데이터 없음";
    }

    @DeleteMapping("/delete")
    public String deleteData(@RequestParam String key) {
        redisService.deleteValue(key);
        return "삭제 완료: " + key;
    }
}
