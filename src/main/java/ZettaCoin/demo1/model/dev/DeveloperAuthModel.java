package ZettaCoin.demo1.model.dev;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeveloperAuthModel {
    private String login;
    private String password;
}
