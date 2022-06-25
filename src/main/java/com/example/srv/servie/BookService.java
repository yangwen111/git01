package com.example.srv.servie;

import com.example.srv.bo.Book;

import java.util.List;

/**
 * @author
 * @DATE 2022/6/21 -14:06
 */
public interface BookService {
    /**
     * 书籍列表
     * @return
     */
    List<Book> bookList();

    /**
     * 按名字赵书
     * @param name
     * @return
     */
    List<Book> findBook(String name);

    /**
     * 按id删除一本书
     * @param id
     * @return
     */
    List<Book> delBook(Integer id);

    /**
     * 按照id找书
     * @param id
     * @return
     */
    Book oneBook(Integer id);

    int changeBook(Book book);

    int addBook(Book book);
}
