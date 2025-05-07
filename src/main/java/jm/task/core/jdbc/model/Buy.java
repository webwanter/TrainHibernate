package jm.task.core.jdbc.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "buys")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buy_id")
    private Long id;

    @Column(name = "buy_description")
    private String description;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "buy_book",
            joinColumns = { @JoinColumn(name = "buy_id") },
            inverseJoinColumns = { @JoinColumn(name = "book_id") }
    )
    Set<Book> books = new HashSet<>();

    public Buy() {
    }

    public Buy(String description) {
        this.description = description;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", books=" + books +
                '}';
    }
}
