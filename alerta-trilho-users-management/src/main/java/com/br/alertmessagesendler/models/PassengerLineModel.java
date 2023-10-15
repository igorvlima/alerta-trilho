package com.br.alertmessagesendler.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "PASSENGER_LINE")
@Getter
public class PassengerLineModel {
    @Id
    private Integer passenger_id;
    private Integer line_id;
}
