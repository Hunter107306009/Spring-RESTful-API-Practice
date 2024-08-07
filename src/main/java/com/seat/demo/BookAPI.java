package com.seat.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.lang.*;

import com.google.gson.Gson;

@RestController
public class BookAPI {
    List<Book> bookList = new ArrayList<>();

    public BookAPI() {
        bookList.add(new Book("00A3", "黑心建商的告白", "2022-10-31"));
        bookList.add(new Book("FBA9", "Java編程入門", "2022-10-31"));
        bookList.add(new Book("9786132156437", "Head First Java, 3/e", "2022-10-31T09:00:00Z"));
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBook() {
        Collections.sort(bookList);
        Gson gson = new Gson();
        return gson.toJson(bookList);
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public String setBook(@RequestBody Book book) {
        try {
            bookList.add(book);
            return "{\"處理結果\":\"新增成功\"}";
        }
        catch(Exception e){
            return "{\"處理結果\":\"新增失敗\"}";
        }
    }
}