package com.example.githubrepolister.client;

import com.example.githubrepolister.model.Branch;
import com.example.githubrepolister.model.GitHubRepository;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "githubClient", url="https://api.github.com")
public interface GitHubClient {
    @GetMapping("/users/{username}/repos")
    List<GitHubRepository> getUserRepositories(@PathVariable("username") String username);

    @GetMapping("/repos/{owner}/{repo}/branches")
    List<Branch> getRepositoryBranches(@PathVariable("owner") String owner, @PathVariable("repo") String repo);
}
