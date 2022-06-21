package com.example.srv.servie;

import com.example.srv.bo.Book;

import java.util.List;

/**
 * @author
 * @DATE 2022/6/21 -14:06
 */
public interface BookService {
    List<Book> bookList();
    List<Book> finfBook(String name);
}
