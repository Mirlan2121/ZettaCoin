package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "current_company")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "current_company_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;



}
