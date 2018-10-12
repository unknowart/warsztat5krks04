package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.beans.MemoryBookService;
import pl.coderslab.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private MemoryBookService mbs;

    @GetMapping("/hello")
    public String hello() {
        return "{msg: hello}";
    }

    @GetMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping("")
    public List<Book> getBookList(){
        return mbs.getList();
    }


}
