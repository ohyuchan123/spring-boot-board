package com.study.board.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//jpa가 읽어들인다.
    private Integer id;

    private String title;

    private String content;

    private String filename;

    private String filepass;
}
