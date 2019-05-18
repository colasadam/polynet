package com.polytech.polynetwork.application;

import javax.persistence.*;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="com")
    private String com;

    public Commentaire(){}



    public String getCom(){
        return com;
    }

    public void setCom(String com){
        this.com = com;
    }


}
