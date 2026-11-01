package ir.maktabsharif.controller;

import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.service.author.AuthorServiceImpl;
import ir.maktabsharif.service.book.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ir.maktabsharif.dto.book.BookResponseDto;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookService;
    private final AuthorServiceImpl authorService;

    public BookController(BookServiceImpl bookService, AuthorServiceImpl authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }


    @GetMapping("/all")
    public void getAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookResponseDto> bookResponseDtos = bookService.findAll();
        request.setAttribute("books",bookResponseDtos);
        request.getRequestDispatcher("/WEB-INF/page/ShowAllBook.jsp").forward(request,response);
    }


    @GetMapping("/details/{id}")
    public void getDeatialsBook(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookResponseDto bookResponseDto  = bookService.read(id);
        AuthorsResponseDto authorsResponseDto = authorService.read(bookResponseDto.getAuthorId());
        request.setAttribute("book",bookResponseDto);
        request.setAttribute("author",authorsResponseDto);
        request.getRequestDispatcher("/WEB-INF/page/ShowBookDeatils.jsp").forward(request,response);
    }







}
