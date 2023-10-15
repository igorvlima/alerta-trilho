package com.br.alertatrilhonotification.domain;

import jakarta.validation.Validation;
import jakarta.validation.ValidationException;

public enum Line {
    AZUL,
    VERDE,
    VERMELHA,
    AMARELA,
    LILÁS,
    RUBI,
    DIAMANTE,
    ESMERALDA,
    TURQUESA,
    CORAL,
    SAFIRA,
    JADE,
    PRATA;

    public static Line fromString(String lineString) {
        for (Line line : Line.values()) {
            if (line.toString().equalsIgnoreCase(lineString)) {
                return line;
            }
        }
        return null;
    }
}
