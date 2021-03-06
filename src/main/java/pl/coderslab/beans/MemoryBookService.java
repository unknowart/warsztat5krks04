package pl.coderslab.beans;

import org.springframework.stereotype.Service;
import pl.coderslab.model.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private static int NEXT_ID = 1;
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        this.insertBook(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        this.insertBook(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        this.insertBook(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public void deleteByID(long id) {
        for(int i=0; i<this.list.size(); i++){
            if(this.list.get(i).getId() == id){
                this.list.remove(i);
                break;
            }
        }
    }

    public Book getById(long id) {
        for(int i=0; i<this.list.size(); i++){
            if(this.list.get(i).getId() == id){
                return this.list.get(i);
            }
        }
        return null;
    }


    public void insertBook(Book book) {
        this.list.add(book);
        book.setId(NEXT_ID++);
    }
}