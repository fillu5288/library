package org.mksmv.Library.models;

import jakarta.validation.constraints.*;

public class Books {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 40, message = "Name should be between 2 and 40 characters")
    private String naming;

    @NotEmpty(message = "Name creator should not be empty")
    @Size(min = 2, max = 40, message = "Name creator should be between 2 and 40 characters")
    private String creator;

    @Min(value = 0, message = "Year books should be greater than 0")
    private int year;

    public Books() {

    }

    public Books(int id, String naming, String creator, int year) {
        this.id = id;
        this.naming = naming;
        this.creator = creator;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaming() {
        return naming;
    }

    public void setNaming(String naming) {
        this.naming = naming;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
