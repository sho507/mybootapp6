package jp.te4a.spring.boot.myapp6.mybootapp6;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

//@RestController
//@RequestMapping("/books")
@Service
public class BookService {
    @Autowired
    private BookService bookService;

    //@PostMapping
    public BookBean save(BookBean bookBean) {
        return bookService.save(bookBean);
    }

    //@GetMapping
    public List<BookBean> findAll() {
        return bookService.findAll();
    }
}