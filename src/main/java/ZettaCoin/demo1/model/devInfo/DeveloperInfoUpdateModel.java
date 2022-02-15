package ZettaCoin.demo1.model.devInfo;

import lombok.*;

import java.time.LocalDate;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeveloperInfoUpdateModel {
    private String name;
    private String serName;
    private Byte image;
    private LocalDate dateOfBirth;
}
