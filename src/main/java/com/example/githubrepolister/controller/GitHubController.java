package com.example.githubrepolister.controller;

import com.example.githubrepolister.model.Repository;
import com.example.githubrepolister.service.GitHubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GitHubController {
    private final GitHubService gitHubService;

    public GitHubController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/users/{username}/repos")
    public ResponseEntity<List<Repository>> listUserRepositories(@PathVariable String username) {
        List<Repository> repositories = gitHubService.getUserRepositories(username);
        return ResponseEntity.ok(repositories);
    }
}
