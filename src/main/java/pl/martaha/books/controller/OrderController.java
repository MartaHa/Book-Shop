package pl.martaha.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.martaha.books.entity.Book;
import pl.martaha.books.repository.BookRepository;
import pl.martaha.books.service.BookServiceImpl;
import pl.martaha.books.service.OrderUtility;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final BookRepository bookRepository;
    private final BookServiceImpl bookServiceImpl;
    private final OrderUtility orderUtility;

    public OrderController(BookRepository bookRepository, BookServiceImpl bookServiceImpl, OrderUtility orderUtility) {
        this.bookRepository = bookRepository;
        this.bookServiceImpl = bookServiceImpl;
        this.orderUtility = orderUtility;
    }

    /* Add book to order */

    @GetMapping("/add/{id}")
    public String add(@PathVariable long id) {
        Book book = bookRepository.getOne(id);
        orderUtility.addToCart(book);
        return "redirect:/order/summary";
    }


    /* Remove the book from the order */

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable long id) {
        Book book = bookRepository.getOne(id);
        orderUtility.remove(book);
        return "redirect:/order/summary";
    }

    /* summary of the order */


    @GetMapping("/summary")
    public String summary(Model model){
        model.addAttribute("orderBook", orderUtility.getOrderBookMap().values());
        return "order/summary";
    }


    @GetMapping("/plus/{id}")
    public String plus(@PathVariable long id){
        Book book = bookRepository.getOne(id);
        orderUtility.plus(book);
        return "redirect:/order/summary";
    }


    @GetMapping("/minus/{id}")
    public String minus(@PathVariable long id){
        Book book = bookRepository.getOne(id);
        orderUtility.minus(book);
        return "redirect:/order/summary";
    }
}

