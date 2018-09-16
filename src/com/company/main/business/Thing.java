package com.company.main.business;

public class Thing implements IThing {

    private String name;
    private Long value;

    public Thing(String name, Long value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }
}
