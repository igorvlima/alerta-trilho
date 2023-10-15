package com.br.alertmessagesendler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "LINES")
@Getter
public class LinesModel {
    @Id
    private Integer id;
    private String name;
    private String owner;
}
