package com.company.main.resource;

public class Transaction implements Comparable<Transaction>{

    public static String GROCERY = "grocery";

    private String type;
    private Integer value;
    private Integer id;

    public Transaction(Integer id) {
        this.type = GROCERY;
        this.value = 1;
        this.id = id;
    }

    public Transaction(String type, Integer value, Integer id) {
        this.type = type;
        this.value = value;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /*
    private static class ById implements Comparator<Transaction> {
        public int compare(Transaction v, Transaction w){
            // v.name is a String, and a String object is Comparable
            // id?
            return v.id.compareTo(w.id);
        }
    }
    */

    @Override
    public int compareTo(Transaction o) {
        if(this.id > o.id) return 1;
        if(this.id < o.id) return -1;
        else               return 0;
    }
}
