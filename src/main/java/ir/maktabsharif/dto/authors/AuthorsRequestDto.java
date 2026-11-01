package ir.maktabsharif.dto.authors;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorsRequestDto {

    private Integer id;

    private String name;

}
