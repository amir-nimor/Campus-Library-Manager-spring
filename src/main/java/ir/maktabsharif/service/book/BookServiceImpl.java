package ir.maktabsharif.service.book;

import ir.maktabsharif.command.BookCommand;
import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.repository.book.BookRepository;
import ir.maktabsharif.service.base.BaseServiceImpl;
import ir.maktabsharif.util.Ruls;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookServiceImpl extends BaseServiceImpl<BookDao,Integer, BookRequestDto, BookResponseDto, BookCommand, BookRepository> implements BookService {


    @Override
    @Cacheable("BookResponseDto")
    public List<BookResponseDto> findAll() {
        return super.findAll();
    }

    @Override
    @CacheEvict(value = "BookResponseDto",allEntries = true)
    public BookResponseDto create(BookRequestDto bookRequestDto) {
        return super.create(bookRequestDto);
    }

    public BookServiceImpl(BookRepository repository, BookCommand command) {
        super(repository, command);
    }

    @Override
    protected void validation(BookRequestDto bookRequestDto) {
        Ruls.check(bookRequestDto.getTitle().isBlank(),"your title is empty");
        Ruls.check(bookRequestDto.getAuthorId()==null,"your author is empty");
    }
}
