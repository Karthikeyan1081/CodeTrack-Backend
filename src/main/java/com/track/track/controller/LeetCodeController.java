package com.track.track.controller;

import com.track.track.dto.LeetCodeStatsDto;
import com.track.track.service.LeetCodeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leetcode")
@CrossOrigin(origins = "*")
public class LeetCodeController {

    private final LeetCodeService leetCodeService;

    public LeetCodeController(LeetCodeService leetCodeService) {
        this.leetCodeService = leetCodeService;
    }

    @GetMapping("/{username}")
    public LeetCodeStatsDto getLeetCodeStats(@PathVariable String username) {
        return leetCodeService.getLeetCodeStats(username);
    }
}