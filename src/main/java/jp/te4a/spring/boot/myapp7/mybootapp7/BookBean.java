package jp.te4a.spring.boot.myapp7.mybootapp7;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class BookBean {
    private Integer id;
    private String title;
    private String writer;
    private String publisher;
    private Integer price;
}
