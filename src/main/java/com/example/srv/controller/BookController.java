package com.example.srv.controller;

import com.example.srv.bo.Book;
import com.example.srv.servie.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author
 * @DATE 2022/6/21 -14:04
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Resource
    private BookService bookService;
    @GetMapping("/bookList")
    public BaseRes<List<Book>> bookList(){
        List<Book> books = bookService.bookList();
        BaseRes<List<Book>> baseRes = new BaseRes<List<Book>>();
        baseRes.setResult(books);
        return baseRes;
    }
    @GetMapping("/findBook/{name}")
    public BaseRes<List<Book>> findBook(@PathVariable("name") String name){
        List<Book> books = bookService.finfBook(name);
        BaseRes<List<Book>> baseRes = new BaseRes<List<Book>>();
        baseRes.setResult(books);
        return baseRes;
    }
}
