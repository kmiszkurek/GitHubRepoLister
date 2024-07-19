package com.example.githubrepolister.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class GitHubRepository {
    private String name;
    private Owner owner;
    private boolean fork;
}
