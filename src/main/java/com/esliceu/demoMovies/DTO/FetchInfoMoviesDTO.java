package com.esliceu.demoMovies.DTO;

public class FetchInfoMoviesDTO {

    private int movieId;
    private String operation;
    private String entity;
    private String input1;
    private String input2;
    private String selected;
    private int gender;
    public FetchInfoMoviesDTO() {
    }

    public FetchInfoMoviesDTO(int movieId, String operation, String entity, String input1, String input2, String selected, int gender) {
        this.movieId = movieId;
        this.operation = operation;
        this.entity = entity;
        this.input1 = input1;
        this.input2 = input2;
        this.selected = selected;
        this.gender = gender;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
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

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }


}
