package pl.library.library.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    private int isbn;

//    @ManyToOne
//    @JoinColumn(name = "user_id")  // Foreign key in the books table
//    private User user;

    public Book() {
    }

    public Book(String title, String author, int isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
