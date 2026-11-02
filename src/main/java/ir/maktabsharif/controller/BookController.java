package ir.maktabsharif.controller;

import ir.maktabsharif.dto.authors.AuthorsRequestDto;
import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.service.author.AuthorService;
import ir.maktabsharif.service.author.AuthorServiceImpl;
import ir.maktabsharif.service.book.BookService;
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

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
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


    @GetMapping("/add")
    public void AddNewBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<AuthorsResponseDto> authorsResponseDtos = authorService.findAll();
        request.setAttribute("authors",authorsResponseDtos);
        request.getRequestDispatcher("/WEB-INF/page/addBook.jsp").forward(request,response);
    }


    @PostMapping("/add")
    public void AddNewBookPost(HttpServletRequest request, HttpServletResponse response,@RequestParam("title") String title,@RequestParam("authorId") Integer authorId) throws ServletException, IOException {
        BookRequestDto bookRequestDto = BookRequestDto.builder().title(title).authorId(authorId).build();
        bookService.create(bookRequestDto);
        System.out.println("sfghbsrthsrthgsrtgsrtdg");
        List<BookResponseDto> bookResponseDtos = bookService.findAll();
        request.setAttribute("books",bookResponseDtos);
        request.getRequestDispatcher("/WEB-INF/page/ShowAllBook.jsp").forward(request,response);

    }









}
