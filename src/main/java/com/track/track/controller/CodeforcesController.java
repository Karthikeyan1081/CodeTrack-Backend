package com.track.track.controller;

import com.track.track.dto.CodeforcesStatsDto;
import com.track.track.service.CodeforcesService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codeforces")
@CrossOrigin(origins = "*")
public class CodeforcesController {

    private final CodeforcesService codeforcesService;

    public CodeforcesController(CodeforcesService codeforcesService) {
        this.codeforcesService = codeforcesService;
    }

    @GetMapping("/{username}")
    public CodeforcesStatsDto getStats(@PathVariable String username) {
        return codeforcesService.getCodeforcesStats(username);
    }
}