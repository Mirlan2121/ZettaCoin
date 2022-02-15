package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "partners")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Partners {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String partnersName;
    private String email;
    private String address;
    private Long phone;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;
}
