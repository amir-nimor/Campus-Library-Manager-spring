package ir.maktabsharif.controller;

import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.service.book.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    public final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @GetMapping("/all")
    public List<BookResponseDto> getAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BookResponseDto> bookResponseDtos = bookService.findAll();
        request.setAttribute("books",bookResponseDtos);
        request.getRequestDispatcher("/WEB-INF/page/ShowAllBook.jsp").forward(request,response);
        return bookResponseDtos;
    }








}
