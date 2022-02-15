package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "summary")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer skill;

    private String developmentExperience;


    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;



}
