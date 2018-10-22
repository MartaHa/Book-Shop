package pl.martaha.books.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.martaha.books.entity.Author;
import pl.martaha.books.repository.AuthorRepository;

public class AuthorConverter implements Converter<String, Author> {


    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Author convert(String s) {
        return authorRepository.getOne(Long.parseLong(s));
    }
}

