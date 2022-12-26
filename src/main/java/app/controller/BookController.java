package app.controller;


import app.dao.BookDAO;
import app.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDAO bookDAO;

    @Autowired
    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String index(Model model){
        model.addAttribute("books", bookDAO.index());
        return "/books/index";
    }

    @GetMapping("/{id}")
    public String show(Model model, @PathVariable("id") int id_book){
        model.addAttribute("book", bookDAO.show(id_book));
        return "/books/show";
    }

    @GetMapping("/new")
    public String newBook(Model model){
        model.addAttribute("book", new Book());
        return "/books/new";
    }

    @PostMapping()
    public String createBook(@ModelAttribute("book") Book book){
        bookDAO.createBook(book);
        return "redirect:books";
    }
}
