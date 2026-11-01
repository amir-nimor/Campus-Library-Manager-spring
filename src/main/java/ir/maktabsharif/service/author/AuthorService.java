package ir.maktabsharif.service.author;

import ir.maktabsharif.dao.AuthorDao;
import ir.maktabsharif.dto.authors.AuthorsRequestDto;
import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import ir.maktabsharif.service.base.BaseService;

public interface AuthorService extends BaseService<AuthorDao,Integer, AuthorsRequestDto, AuthorsResponseDto> {
}
