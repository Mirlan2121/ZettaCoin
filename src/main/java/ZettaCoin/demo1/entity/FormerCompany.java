package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "former_company")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FormerCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "former_company_name")
    private String name;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;


}
