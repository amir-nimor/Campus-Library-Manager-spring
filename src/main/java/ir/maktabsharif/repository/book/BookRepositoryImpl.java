package ir.maktabsharif.repository.book;

import ir.maktabsharif.dao.BookDao;
import ir.maktabsharif.repository.base.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

@Component
public class BookRepositoryImpl extends BaseRepositoryImpl<BookDao,Integer> implements BookRepository {

    public BookRepositoryImpl() {
        super(BookDao.class);
    }

    @Override
    protected void updateEntity(BookDao dbEntity, BookDao newEntity) {
        dbEntity.setAuthorDao(newEntity.getAuthorDao());
        dbEntity.setTitle(newEntity.getTitle());
    }
}
