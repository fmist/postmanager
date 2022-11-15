package com.rustcohle.postmanager.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "title")
    @NotEmpty(message = "Введите имя заголовка (минимум 3 символа)")
    @Size(min = 3, message = "Заголовок должен содержать минимум 3 символа")
    private String title;

    @Column(name = "text", columnDefinition = "text")
    @NotEmpty(message = "Описание не может быть пустым")
    private String text;

    public Post(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public Post() {
    }

    LocalDateTime timeCreated;

    @PrePersist
    @PreUpdate
    public void getDateTimeCreated() {
        timeCreated = LocalDateTime.now();
    }

    public String getTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
        return formatter.format(timeCreated);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
