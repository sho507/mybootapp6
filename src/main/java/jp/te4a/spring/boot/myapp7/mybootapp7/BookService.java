package jp.te4a.spring.boot.myapp7.mybootapp7;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

//@RestController
//@RequestMapping("/books")
@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    //@PostMapping
    public BookBean save(BookBean bookBean) {
        return bookRepository.save(bookBean);
    }

    //@GetMapping
    public List<BookBean> findAll() {
        return bookRepository.findAll();
    }
}