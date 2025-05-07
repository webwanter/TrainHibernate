package jm.task.core.jdbc.model;

import javax.persistence.*;

@Entity
@Table(name = "buy_book")
public class BuyBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "buy_book_id")
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "buy_id", nullable = false)
    private Buy buy;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "amount", nullable = false)
    private int amount;

    public BuyBook() {}

    public BuyBook(Buy buy, Book book, int amount) {
        this.buy = buy;
        this.book = book;
        this.amount = amount;
    }
}
