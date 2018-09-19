package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.MemoryBookService;
import pl.coderslab.model.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/loadAll")
    public List<Book> loadAll() {
        List<Book> list = memoryBookService.getList();
        return list;
    }

    @RequestMapping("/loadById/{id}")
    public Book loadById(@PathVariable long id) {
        return memoryBookService.getById(id);
    }

    @PostMapping("/addBook")
    public void aadBook(@RequestBody Book book) {
        List<Book> list = memoryBookService.add(book);
    }

    //@RequestParam String isbn, @RequestParam String title, @RequestParam String author,
    //                              @RequestParam String publisher, @RequestParam String type
    @RequestMapping("/editBook/{id}")
    public List<Book> editdBook(@PathVariable int id, @RequestParam String isbn, @RequestParam String title, @RequestParam String author,
                              @RequestParam String publisher, @RequestParam String type) {
        List<Book> list = memoryBookService.edit(id, isbn, title, author, publisher, type);
        return list;
    }

    @RequestMapping("/delete/{id}")
    public List<Book> deleteById(@PathVariable long id) {
        List<Book> list = memoryBookService.delete(id);
        return list;
    }


}