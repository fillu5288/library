package org.mksmv.Library.controllers;

import org.mksmv.Library.dao.BooksDAO;
import org.mksmv.Library.models.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/book")
public class BooksController {

    private final BooksDAO booksDAO;

    @Autowired
    public BooksController(BooksDAO booksDAO) {this.booksDAO = booksDAO;}

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("book", booksDAO.index());
        return "book/index";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", booksDAO.info(id));
        return "book/info";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("book")Books books) {
        return "book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Validated Books books) {
        booksDAO.save(books);
        return "redirect:/book";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", booksDAO.info(id));
        return "book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Validated Books books,
                         @PathVariable("id") int id) {
        booksDAO.update(id, books);
        return "redirect:/book";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        booksDAO.delete(id);
        return "redirect:/book";
    }
}
