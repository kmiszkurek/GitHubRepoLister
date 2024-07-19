package com.example.githubrepolister.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Repository {
    private String name;
    private Owner owner;
    private List<Branch> branches;
}
