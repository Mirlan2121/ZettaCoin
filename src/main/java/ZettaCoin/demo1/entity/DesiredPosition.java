package ZettaCoin.demo1.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "desired_position")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DesiredPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "speciality")
    @OneToOne
    private Speciality speciality;

}
