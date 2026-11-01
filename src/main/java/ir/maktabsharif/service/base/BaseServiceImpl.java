package ir.maktabsharif.service.base;

import ir.maktabsharif.command.Commandable;
import ir.maktabsharif.dao.baseMode.BaseModel;
import ir.maktabsharif.exception.BuisenesException;
import ir.maktabsharif.exception.RepositoryException;
import ir.maktabsharif.exception.ValidationExceptio;
import ir.maktabsharif.repository.base.BaseRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public abstract class BaseServiceImpl <
        T extends BaseModel<ID>,
        ID extends Number,
        Q,S
        ,C extends Commandable<T,Q,S>,
        R extends BaseRepository<T,ID>
        > implements BaseService<T,ID,Q,S>{

    private final R repository;
    private final C command;


    public BaseServiceImpl(R repository, C command) {
        this.repository = repository;
        this.command = command;
    }


    protected abstract void validation(Q q);

    @Override
    public S create(Q q) {
        try {
            validation(q);
            T model = command.requestToDao(q);
            return command.daoToResponse(repository.create(model));
        }catch (ValidationExceptio | RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public S update(Q q) {
        try {
            validation(q);
            T model = command.requestToDao(q);
            return command.daoToResponse(repository.update(model));
        }catch (ValidationExceptio | RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public ID delete(ID id) {
        try {
            return repository.delete(id);
        }catch (RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public S read(ID id) {
        try {
            return command.daoToResponse(repository.read(id));
        }catch ( RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }

    @Override
    public List<S> findAll() {
        try {
            List<T> tList =  repository.findAll();
            return tList.stream().map(t -> command.daoToResponse(t)).toList();
        }catch ( RepositoryException e){
            throw new BuisenesException("service is failed => "+e.getMessage());
        }
    }
}
