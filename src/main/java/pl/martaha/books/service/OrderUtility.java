package pl.martaha.books.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import pl.martaha.books.entity.Book;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OrderUtility {


    private Map<Long, Book> orderBookMap = new HashMap<>();


    /* Add Book to Cart */

    public void addToCart(Book book) {
        if (orderBookMap.containsKey(book.getId())) {
            orderBookMap.get(book.getId()).setQuantity(orderBookMap.get(book.getId()).getQuantity() + 1);
        } else {
            orderBookMap.put(book.getId(), book);
        }
    }

    /* Removing book */

    public void remove(Book cartBook) {
        this.orderBookMap.remove(cartBook.getId());
    }

    public void plus(Book book) {
        orderBookMap.get(book.getId()).setQuantity(orderBookMap.get(book.getId()).getQuantity() + 1);
        ;
    }


    public void minus(Book book) {
        if (orderBookMap.get(book.getId()).getQuantity() == 1) {
            this.orderBookMap.remove(book.getId());
        } else {
            orderBookMap.get(book.getId()).setQuantity(orderBookMap.get(book.getId()).getQuantity() - 1);
            ;
        }
    }

    /* Getter & Setter */


    public Map<Long, Book> getOrderItemMap() {
        return orderBookMap;
    }

    public void setOrderBookMap(Map<Long, Book> orderBookMap) {
        this.orderBookMap = orderBookMap;
    }
}

