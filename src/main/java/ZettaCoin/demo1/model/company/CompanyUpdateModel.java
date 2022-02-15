package ZettaCoin.demo1.model.company;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyUpdateModel {
    private Long id;
    private String name;
    private String address;
    private Long phone;
    private String description;
}
