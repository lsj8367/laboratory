package com.github.lsj8367.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CardViewer {

    @Id
    private Long id;

    @ManyToOne
    private Card card;

    @ManyToOne
    private User user;
}
