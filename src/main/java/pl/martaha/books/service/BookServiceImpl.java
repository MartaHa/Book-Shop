package pl.martaha.books.service;

import org.springframework.stereotype.Service;
import pl.martaha.books.entity.Book;
import pl.martaha.books.repository.BookRepository;
@Service
public class BookServiceImpl implements BookService {


    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void saveBook(Book book) {
        book.setQuantity(1);
        bookRepository.save(book);
    }
}
