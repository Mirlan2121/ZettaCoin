package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "company")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_name", unique = true)
    private String name;
    @Column(name = "address", unique = true)
    private String address;
    @Column(name = "phone", unique = true)
    private Long phone;
    @Column(name = "description", unique = false)
    private String description;

}
