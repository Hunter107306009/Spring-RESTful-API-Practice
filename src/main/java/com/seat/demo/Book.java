package com.seat.demo;

import java.util.*;

public class Book implements Comparable<Book> {
    public String id;
    public String name;
    public String date;

    public Book(String id,String name,String date){
        this.id=id;
        this.name=name;
        this.date=date;
    }

    @Override
    public int compareTo(Book b){
        return this.id.compareTo(b.id);
    }
}