package ir.maktabsharif.service.author;

import ir.maktabsharif.command.AuthorCommand;
import ir.maktabsharif.dao.AuthorDao;
import ir.maktabsharif.dto.authors.AuthorsRequestDto;
import ir.maktabsharif.dto.authors.AuthorsResponseDto;
import ir.maktabsharif.repository.author.AuthorRepository;
import ir.maktabsharif.service.base.BaseServiceImpl;
import ir.maktabsharif.util.Ruls;
import org.springframework.stereotype.Component;

@Component
public class AuthorServiceImpl extends BaseServiceImpl<
        AuthorDao
        , Integer
        , AuthorsRequestDto
        , AuthorsResponseDto
        , AuthorCommand
        , AuthorRepository>
        implements AuthorService {

    public AuthorServiceImpl(AuthorRepository repository, AuthorCommand command) {
        super(repository, command);
    }

    @Override
    protected void validation(AuthorsRequestDto authorsRequestDto) {
        Ruls.check(authorsRequestDto.getName().isBlank(),"your name is empty");
    }
}
