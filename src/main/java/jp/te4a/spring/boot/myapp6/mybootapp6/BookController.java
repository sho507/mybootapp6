package jp.te4a.spring.boot.myapp6.mybootapp6;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// import ch.qos.logback.core.model.Model;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String index(Model model) {
        //�C���|�[�g�ԈႢ�ŃG���[���o�Ă���
        model.addAttribute("msg", "this is setting message");
        return "index";
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public ModelAndView postForm(@RequestParam("id") String id,
            @RequestParam("title") String title, @RequestParam("writter") String writter,
            @RequestParam("publisher") String publisher, @RequestParam("price") String price) {
        ModelAndView mv = new ModelAndView("index");
        bookService.save(new BookBean(Integer.valueOf(id), title, writter, publisher, Integer.valueOf(price)));
        StringBuffer buff = new StringBuffer();
        buff.append("<HR>");
        for (BookBean bean : bookService.findAll()) {
            buff.append("ID:" + bean.getId() + "<BR>" + "�^�C�g��:" + bean.getTitle() + 
                    "<BR>" + "����:" + bean.getWriter() + "<BR>" + "�o�Ŏ�:" + bean.getPublisher() + 
                    "<BR>" + "���i:" + bean.getPrice() + "<BR><HR>");
        }
        mv.addObject("msg", buff.toString());
        return mv;
    }
}
