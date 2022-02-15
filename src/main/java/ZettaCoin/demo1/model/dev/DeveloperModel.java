package ZettaCoin.demo1.model.dev;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeveloperModel {
    private String login;
    private String password;
    private String developerInfo;
    private Long active;
}
