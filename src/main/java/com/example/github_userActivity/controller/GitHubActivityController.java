package com.example.github_userActivity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class GitHubActivityController {

    private final RestTemplate restTemplate;

    public GitHubActivityController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping("/{userName}")
    public List<Object> getUserActivity(@PathVariable String userName) {
        Object[] quote = restTemplate.getForObject(String.format("https://api.github.com/users/%s/events", userName), Object[].class);

        if (quote == null)
            return List.of();

        return Arrays.asList(quote);
    }
}
