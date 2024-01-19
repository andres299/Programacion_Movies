package com.esliceu.demoMovies.DTO;

import jakarta.persistence.Entity;

public class FetchEntitiDTO {
    private String operation;
    private String entity;
    private String id;
    private String input1;
    private String input2;

    public FetchEntitiDTO() {
    }

    public FetchEntitiDTO(String operation, String entity, String id, String input1, String input2) {
        this.operation = operation;
        this.entity = entity;
        this.id = id;
        this.input1 = input1;
        this.input2 = input2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
    }

    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
    }
}
