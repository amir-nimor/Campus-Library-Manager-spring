package ir.maktabsharif.controller;

import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import ir.maktabsharif.service.author.AuthorService;
import ir.maktabsharif.service.author.AuthorServiceImpl;
import ir.maktabsharif.service.book.BookService;
import ir.maktabsharif.service.book.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final BookService bookService;
    private final AuthorService authorService;

    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/all")
    public void AllAuthors(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AuthorsResponseDto> authorsResponseDtos = authorService.findAll();
        request.setAttribute("authors",authorsResponseDtos);
        request.getRequestDispatcher("/WEB-INF/page/allAuhtors.jsp").forward(request,response);
    }


}
