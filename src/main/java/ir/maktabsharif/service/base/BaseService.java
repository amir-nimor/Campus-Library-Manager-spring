package ir.maktabsharif.service.base;

import ir.maktabsharif.dao.baseMode.BaseModel;

import java.util.List;

public interface BaseService <T extends BaseModel<ID>,ID extends Number,Q,S>{
    S create(Q q);

    S update(Q q);

    ID delete(ID id);

    S read (ID id);

    List<S> findAll();

}
