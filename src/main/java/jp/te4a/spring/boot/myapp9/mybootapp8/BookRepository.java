package jp.te4a.spring.boot.myapp9.mybootapp8;

// import java.util.ArrayList;
import java.util.List;
// import java.util.concurrent.ConcurrentHashMap;
// import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// import jp.te4a.spring.boot.myapp8.BookBean;

@Repository
public interface BookRepository extends JpaRepository<BookBean, Integer> {
    @Query("SELECT X FROM BookBean X ORDER BY X.title")
    List<BookBean> findAllOrderByTitle();

    // 控え
    // private final ConcurrentMap<Integer, BookBean> bookMap = new
    // ConcurrentHashMap<>();
    // private int BOOK_ID = 1;

    // 控え
    // public int getBookId() {
    // return BOOK_ID++;
    // }

    // ここからpublic→default変換
    default BookBean create(BookBean bookBean) {
        // return bookMap.put(bookBean.getId(), bookBean);
        // 控え

        save(bookBean);
        return bookBean;
        // 追加
    }

    default BookBean update(BookBean updateBookBean) {
        BookBean bookBean = findById(updateBookBean.getId()).orElse(null);
        // bookMap.get(updateBookBean.getId()) →
        // findById(updateBookBean.getId()).orElse(null)

        // BeanUtils.copyProperties(updateBookBean, bookBean);
        // return bookBean;
        // 控え

        if (bookBean != null) {
            BeanUtils.copyProperties(updateBookBean, bookBean);
            save(bookBean);
        }
        return bookBean;
        // 追加
    }

    default void delete(Integer bookId) {
        // bookMap.remove(bookId);
        // 控え

        findById(bookId).ifPresent(book -> delete(book));
        // 追加
    }

    @SuppressWarnings("null")
    default List<BookBean> findAll() {
        // return new ArrayList<>(bookMap.values());
        // 控え

        return findAll();
        // 追加
    }

    default BookBean findOne(Integer id) {
        // return bookMap.get(id);
        // 控え

        return findById(id).orElse(null);
        // 追加
    }
}