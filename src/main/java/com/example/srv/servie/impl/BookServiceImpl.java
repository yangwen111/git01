package com.example.srv.servie.impl;

import com.example.srv.bo.Book;
import com.example.srv.bo.BookExample;
import com.example.srv.dao.BookMapper;
import com.example.srv.servie.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @DATE 2022/6/21 -14:06
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public List<Book> bookList() {
        List<Book> books = bookMapper.selectByExample(null);
        return books;
    }

    @Override
    public List<Book> findBook(String name) {
        BookExample example=new BookExample();
        BookExample.Criteria criteria = example.createCriteria();
        criteria.andNameLike(name);
        List<Book> books = bookMapper.selectByExample(example);
        return books;
    }

    @Override
    public List<Book> delBook(Integer id) {
        bookMapper.deleteByPrimaryKey(id);
        List<Book> books = bookList();
        return books;
    }

    @Override
    public Book oneBook(Integer id) {
        Book book = bookMapper.selectByPrimaryKey(id);
        return book;
    }
}
