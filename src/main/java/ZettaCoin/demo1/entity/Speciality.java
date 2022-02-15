package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "speciality")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Speciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Byte image;

    @JoinColumn(name = "summary_id")
    @ManyToOne
    private Summary summary;
}
