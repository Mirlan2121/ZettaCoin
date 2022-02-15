package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "technology_stack")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TechnologyStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Byte images;

    @JoinColumn(name = "summary_id")
    @ManyToOne
    private Summary summary;
}
