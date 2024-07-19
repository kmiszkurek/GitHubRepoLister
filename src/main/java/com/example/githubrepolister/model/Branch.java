package com.example.githubrepolister.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Branch {
    private String name;
    private Commit commit;
}
