package com.example.githubrepolister.service;

import com.example.githubrepolister.client.GitHubClient;
import com.example.githubrepolister.exception.UserNotFoundException;
import com.example.githubrepolister.model.Branch;
import com.example.githubrepolister.model.Repository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GitHubService {
    private final GitHubClient gitHubClient;

    @Autowired
    public GitHubService(GitHubClient gitHubClient) {
        this.gitHubClient = gitHubClient;
    }

    public List<Repository> getUserRepositories(String username) {
        try {
            return gitHubClient.getUserRepositories(username).stream()
                    .filter(repo -> !repo.isFork())
                    .map(repo -> {
                        List<Branch> branches = gitHubClient.getRepositoryBranches(repo.getOwner().getLogin(), repo.getName());
                        Repository repository = new Repository();
                        repository.setName(repo.getName());
                        repository.setOwner(repo.getOwner());
                        repository.setBranches(branches);
                        return repository;
                    })
                    .collect(Collectors.toList());
        } catch (FeignException.NotFound ex) {
            throw new UserNotFoundException("User not found: " + username);
        }
    }
}
