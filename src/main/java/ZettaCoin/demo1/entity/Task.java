package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "task")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "company_id")
    @ManyToOne
    private Company company;
}
