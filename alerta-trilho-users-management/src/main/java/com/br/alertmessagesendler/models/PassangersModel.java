package com.br.alertmessagesendler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "PASSENGERS")
@Getter
public class PassangersModel {

    @Id
    private Integer id;
    private String cpf;
    private String email;
    private String phoneNumber;


}
