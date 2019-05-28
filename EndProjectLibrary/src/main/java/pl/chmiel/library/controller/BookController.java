package pl.chmiel.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.chmiel.library.component.Book;
import pl.chmiel.library.repository.BookRepo;

import java.util.Optional;

@Controller
//@RequestMapping("/gui")
public class BookController {

    @Autowired
    BookRepo bookRepo;

    @GetMapping("/bookgui")
    public String showGui(Model model) {
        model.addAttribute("book", new Book());
        return "bookgui";
    }

    @GetMapping("/bookprofile")
    private String bookProfile(@RequestParam Model model, Long id) {
        model.addAttribute("books", bookRepo.findById(id));
        return "bookprofile";
    }

    @GetMapping("/showallbooks")
    private String showAllBooks(Model model) {
//        Iterable<Book> allBooks = bookRepo.findAll();
        model.addAttribute("books", bookRepo.findAll());
        return "showbooks";
    }

    @GetMapping("/findbytitleorauthor")
    private String findByTitleOrAuthor(@RequestParam("books") Model model, String str) {
        model.addAttribute("books", bookRepo.findByTitleOrAuthor(str));
        return "showbooks";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute Book book, Model model) {
        bookRepo.save(book);
        return showAllBooks(model);
    }

    @GetMapping("/updatebook")
    private String updateBook(@RequestParam("bookId") Long theId, Model model) {
        Optional<Book> theBook = bookRepo.findById(theId);
        model.addAttribute("book", theBook);
        return "redirect:/bookgui";
    }

    @GetMapping("/deletebook")
    private String deleteBook(@RequestParam("bookId") Long theId) {
        bookRepo.deleteById(theId);
        return "redirect:/showallbooks";
    }

}
