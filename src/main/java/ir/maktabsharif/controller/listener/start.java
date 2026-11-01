package ir.maktabsharif.controller.listener;

import ir.maktabsharif.command.AuthorCommand;
import ir.maktabsharif.command.BookCommand;
import ir.maktabsharif.dto.authors.AuthorsRequestDto;
import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.repository.author.AuthorRepositoryImpl;
import ir.maktabsharif.repository.book.BookRepositoryImpl;
import ir.maktabsharif.service.author.AuthorServiceImpl;
import ir.maktabsharif.service.book.BookServiceImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class start implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {



        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        AuthorRepositoryImpl authorRepository = new AuthorRepositoryImpl();

        BookCommand bookCommand = new BookCommand(authorRepository);
        AuthorCommand authorCommand = new AuthorCommand();

        BookServiceImpl bookService = new BookServiceImpl(bookRepository,bookCommand);
        AuthorServiceImpl authorService = new AuthorServiceImpl(authorRepository,authorCommand);


        AuthorsRequestDto authorsRequestDto1 = AuthorsRequestDto.builder().name("amir").build();
        AuthorsRequestDto authorsRequestDto2 = AuthorsRequestDto.builder().name("ali").build();
        AuthorsRequestDto authorsRequestDto3 = AuthorsRequestDto.builder().name("reza").build();

        AuthorsResponseDto authorsResponseDto1 = authorService.create(authorsRequestDto1);
        AuthorsResponseDto authorsResponseDto2 = authorService.create(authorsRequestDto2);
        AuthorsResponseDto authorsResponseDto3 = authorService.create(authorsRequestDto3);

        BookRequestDto bookRequestDto1 = BookRequestDto.builder().title("python").authorId(authorsResponseDto1.getId()).build();
        BookRequestDto bookRequestDto2 = BookRequestDto.builder().title("java").authorId(authorsResponseDto2.getId()).build();
        BookRequestDto bookRequestDto3 = BookRequestDto.builder().title("c++").authorId(authorsResponseDto2.getId()).build();
        BookRequestDto bookRequestDto4 = BookRequestDto.builder().title("c#").authorId(authorsResponseDto3.getId()).build();

        bookService.create(bookRequestDto1);
        bookService.create(bookRequestDto2);
        bookService.create(bookRequestDto3);
        bookService.create(bookRequestDto4);

        System.out.println("========================add a objects =========================");


    }
}
