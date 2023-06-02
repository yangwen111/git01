package com.example.srv;

import com.example.srv.bo.Book;
import com.example.srv.dao.BookMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
// 主程序
@SpringBootTest
class SrvApplicationTests {
    @Resource
    private BookMapper bookMapper;
    @Test
    void contextLoads() {
        List<Book> books = bookMapper.selectByExample(null);
        System.out.println(books);
    }

}
