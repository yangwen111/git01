package com.example.srv.controller;

import com.example.srv.bo.Book;
import com.example.srv.controller.params.BaseRes;
import com.example.srv.servie.BookService;
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
        List<Book> books = bookService.findBook(name);
        BaseRes<List<Book>> baseRes = new BaseRes<List<Book>>();
        baseRes.setResult(books);
        return baseRes;
    }
    @DeleteMapping("/delBook/{id}")
    public BaseRes<List<Book>> delBook(@PathVariable Integer id){
        List<Book> books = bookService.delBook(id);
        BaseRes<List<Book>> baseRes = new BaseRes<List<Book>>();
        baseRes.setResult(books);
        return baseRes;
    }
    @GetMapping("/oneBook/{id}")
    public BaseRes<Book> oneBook(@PathVariable Integer id){
        Book book = bookService.oneBook(id);
        BaseRes<Book> baseRes = new BaseRes<>();
        baseRes.setResult(book);
        return baseRes;
    }
    @PostMapping("/changeBook")
    public BaseRes<Integer>  changeBook(@RequestBody Book book){
        BaseRes<Integer> baseRes=new BaseRes<Integer>();
        int i = bookService.changeBook(book);
        baseRes.setResult(i);
        return baseRes;
    }
    @PostMapping("/addBook")
    public BaseRes<Integer>  addBook(@RequestBody Book book){
        BaseRes<Integer> baseRes=new BaseRes<Integer>();
        int i = bookService.addBook(book);
        baseRes.setResult(i);
        return baseRes;
    }
}
