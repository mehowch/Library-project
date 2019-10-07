package pl.chmiel.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("bookadd", new Book());
        return "bookgui";
    }

//    @GetMapping("/bookprofile")
//    private String bookProfile(@RequestParam("bookId") Long theId) {
//        bookRepo.findById(theId);
//        return "bookprofile";
//    }

//    @GetMapping("/bookprofile")
//    private String bookProfile(@RequestParam("bookId") Long theId) {
//        Optional<Book> bookInfo = bookRepo.findById(theId);
//        System.out.println(bookInfo.toString());
//        return "/bookprofile";
//    }

    @GetMapping("/bookprofile")
    private String bookProfile(@ModelAttribute("bookId") Book book, Model model, Long theId) {
        bookRepo.findById(theId = 1l);
        model.addAttribute("title", book.getTitle());
        return "/bookprofile";
    }


    @GetMapping("/showallbooks")
    private String showAllBooks(Model model) {
        model.addAttribute("books", bookRepo.findAll());
        return "showbooks";
    }

//    @GetMapping("/findall")
//    private List<Book> showAllBooks() {
//
//        List<Book> list = new ArrayList<>();
//
//        list.add(new Book("Booke1", "Authore", 1999));
//        list.add(new Book("Booke2", "Authore2", 19992));
//
//        return list;
//    }

    @GetMapping(value = "/findbytitleorauthor")
    private String findByTitle(@RequestParam(name = "title") Model model, String title) {
        model.addAttribute("booksfromsearch", bookRepo.findByTitle(title));
        return showAllBooks(model);
//        return "redirect:/showbooks";
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
