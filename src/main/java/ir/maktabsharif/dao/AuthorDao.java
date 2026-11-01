package ir.maktabsharif.dao;

import ir.maktabsharif.dao.baseMode.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "authoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorDao extends BaseModel<Integer> {

    private String name;
}
