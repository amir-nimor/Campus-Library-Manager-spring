package ir.maktabsharif.service.book;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.dto.book.BookRequestDto;
import ir.maktabsharif.dto.book.BookResponseDto;
import ir.maktabsharif.service.base.BaseService;

public interface BookService extends BaseService<BookDao,Integer, BookRequestDto, BookResponseDto> {
}
