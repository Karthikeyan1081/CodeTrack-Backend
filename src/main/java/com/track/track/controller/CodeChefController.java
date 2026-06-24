package com.track.track.controller;

import com.track.track.dto.CodeChefStatsDto;
import com.track.track.service.CodeChefService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/codechef")
@CrossOrigin(origins = "*")
public class CodeChefController {

    private final CodeChefService codeChefService;

    public CodeChefController(CodeChefService codeChefService) {
        this.codeChefService = codeChefService;
    }

    @GetMapping("/{username}")
    public CodeChefStatsDto getCodeChefStats(@PathVariable String username) {
        return codeChefService.getCodeChefStats(username);
    }
}