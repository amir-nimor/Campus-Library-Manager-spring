package ir.maktabsharif.repository.author;

import ir.maktabsharif.dao.AuthorDao;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

@Component
public class AuthorRepositoryImpl extends BaseRepositoryImpl<AuthorDao,Integer> implements AuthorRepository {
    public AuthorRepositoryImpl() {
        super(AuthorDao.class);
    }

    @Override
    protected void updateEntity(AuthorDao dbEntity, AuthorDao newEntity) {
        dbEntity.setName(newEntity.getName());
    }
}
