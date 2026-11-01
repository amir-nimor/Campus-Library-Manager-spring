package ir.maktabsharif.command;

import ir.maktabsharif.dao.AuthorDao;
import ir.maktabsharif.dto.authors.AuthorsRequestDto;
import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import org.springframework.stereotype.Component;

@Component
public class AuthorCommand implements Commandable<AuthorDao, AuthorsRequestDto, AuthorsResponseDto> {
    @Override
    public AuthorDao requestToDao(AuthorsRequestDto authorsRequestDto) {
        AuthorDao authorDao = AuthorDao.builder()
                .name(authorsRequestDto.getName())
                .build();

        authorDao.setId(authorsRequestDto.getId());
        return authorDao;
    }

    @Override
    public AuthorsResponseDto daoToResponse(AuthorDao authorDao) {
        return AuthorsResponseDto.builder()
                .id(authorDao.getId())
                .name(authorDao.getName())
                .build();
    }
}
