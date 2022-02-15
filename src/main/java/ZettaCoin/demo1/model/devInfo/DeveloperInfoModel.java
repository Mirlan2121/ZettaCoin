package ZettaCoin.demo1.model.devInfo;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DeveloperInfoModel {
private String name;
private String serName;
private Long phone;
private Byte images;
private LocalDate dateOfBirth;
private String email;
}
