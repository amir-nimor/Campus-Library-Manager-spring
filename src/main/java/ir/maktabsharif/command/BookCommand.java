package ir.maktabsharif.command;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.repository.author.AuthorRepositoryImpl;
import org.springframework.stereotype.Component;

@Component
public class BookCommand implements Commandable<BookDao, BookRequestDto, BookResponseDto> {

    private final AuthorRepositoryImpl authorRepository;

    public BookCommand(AuthorRepositoryImpl authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public BookDao requestToDao(BookRequestDto bookRequestDto) {
        BookDao bookDao = BookDao.builder()
                .title(bookRequestDto.getTitle())
                .authorDao(authorRepository.read(bookRequestDto.getAuthorId()))
                .build();
        bookDao.setId(bookRequestDto.getId());
        return bookDao;
    }

    @Override
    public BookResponseDto daoToResponse(BookDao bookDao) {
        return BookResponseDto.builder()
                .title(bookDao.getTitle())
                .authorId(bookDao.getAuthorDao().getId())
                .id(bookDao.getId())
                .build();

    }
}
