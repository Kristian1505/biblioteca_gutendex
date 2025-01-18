package com.mycompany.biblioteca.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(

        @JsonAlias("id") Long id,
        @JsonAlias("authors") List<AuthorData>authors,
        @JsonAlias("title") String title,
        @JsonAlias("languages") List<String> languages,
        @JsonAlias("subjects") List<String> subjects,
        @JsonAlias("download_count") int downloadCount
) {
}
