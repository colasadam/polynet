package com.polytech.polynetwork.application;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity()
@Table(name = "story")

public class Story {
    @Id
    private int id;
    @Column(name = "content")
    private String content;
    @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_story")
    private List<Commentaire> commentaires = new ArrayList<>();

    public Story() {

    }

    public Story(String content) {
        this.content = content;
    }

    public Story(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public Story(int id, String content, List<Commentaire> commentaires) {
        this.id = id;
        this.content = content;
        this.commentaires = commentaires;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void addComments(Commentaire com) {
        this.commentaires.add(com);
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    @Override
    public String toString() {
        return "Story{" +
                "content='" + content + '\'' +
                '}';
    }
}