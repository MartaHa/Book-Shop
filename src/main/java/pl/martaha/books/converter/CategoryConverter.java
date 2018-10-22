package pl.martaha.books.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.martaha.books.entity.Category;
import pl.martaha.books.repository.CategoryRepository;

public class CategoryConverter implements Converter<String, Category> {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category convert(String s) {
        return categoryRepository.getOne(Long.parseLong(s));
    }
}
