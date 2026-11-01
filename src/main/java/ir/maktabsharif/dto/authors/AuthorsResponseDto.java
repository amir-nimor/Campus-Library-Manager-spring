package ir.maktabsharif.dto.authors;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthorsResponseDto {

    private Integer id;

    private String name;

    @Override
    public String toString() {
        return "AuthorsResponseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
