package ir.maktabsharif.dao;

import ir.maktabsharif.dao.baseMode.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDao extends BaseModel<Integer> {

    private String title;

    @ManyToOne
    private AuthorDao authorDao;
}
