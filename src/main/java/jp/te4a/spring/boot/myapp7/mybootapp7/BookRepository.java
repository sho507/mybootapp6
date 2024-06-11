package jp.te4a.spring.boot.myapp7.mybootapp7;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class BookRepository {
    private final ConcurrentMap<Integer, BookBean> bookMap = new ConcurrentHashMap<>();

    public BookBean save(BookBean bookBean) {
        return bookMap.put(bookBean.getId(), bookBean);
    }

    public void delete(Integer bookId) {
        bookMap.remove(bookId);
    }

    public List<BookBean> findAll() {
        return new ArrayList<>(bookMap.values());
    }
}
