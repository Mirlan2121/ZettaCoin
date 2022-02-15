package ZettaCoin.demo1.model.company;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentCompanyUpdateModel {
    private Long id;
    private String name;
    private Long company;
}
