package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "developers")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private String developerInfo;
    private Long active;


}
