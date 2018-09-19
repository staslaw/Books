package pl.coderslab.dao;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void getAll() {

    }

    public Book getById(long id) {
    for (Book item : list) {
        if (item.getId() == id) {
            return item;
        }
    }
        return null;
    }

    public List<Book> edit(long id, String isbn, String title, String author, String publisher, String type) {
        for (Book item : list) {
            if (item.getId() == id) {
                item.setIsbn(isbn).setTitle(title).setAuthor(author).setPublisher(publisher).setType(type);
            }
        }
        return list;
    }

    public List<Book> delete(long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                list.remove(i);
            }
        }
        return list;

    }

    public List<Book> add(Book book) {
        int size = list.size();
        long lastId = list.get(size-1).getId();
        book.setId(lastId + 1);
        list.add(book);
        return list;
        //String isbn, String title, String author, String publisher, String type
    }
}
