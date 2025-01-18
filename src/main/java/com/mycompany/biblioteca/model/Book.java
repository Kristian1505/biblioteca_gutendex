package com.mycompany.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

//DB
@Entity
@Table(name = "books")

public class Book {

    //DB
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Attributes
    @Column(unique = true)
    private Long idGutendex;

    // Relationship with Author
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_id") // Creates a foreign key in the authors table
    private List<Author> authors;

    private String title;

    // Basic collections
    //@ElementCollection
    //@CollectionTable(name = "book_languages", joinColumns = @JoinColumn(name = "book_id"))
    @Transient
    private List<String> languages;

    //@ElementCollection
    //@CollectionTable(name = "book_subjects", joinColumns = @JoinColumn(name = "book_id"))
    @Transient
    private List<String> subjects;

    private int downloadCount;

    //Getters
    public Long getIdGutendex() {
        return idGutendex;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public int getDownloadCount() {
        return downloadCount;
    }

    public Long getId() {
        return id;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setIdGutendex(Long idGutendex) {
        this.idGutendex = idGutendex;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public void setDownloadCount(int downloadCount) {
        this.downloadCount = downloadCount;
    }


    //Methods

}
