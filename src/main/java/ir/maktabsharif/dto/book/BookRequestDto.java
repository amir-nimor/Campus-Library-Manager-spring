package ir.maktabsharif.dto.book;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequestDto {

    private Integer id;

    private String title;

    private Integer authorId;

}
