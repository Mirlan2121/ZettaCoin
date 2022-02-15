package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "developersInfo")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeveloperInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "developer_name", nullable = false)
    private String name;

    @Column(name = "developer_ser_name", nullable = false)
    private String serName;

    @Column(name = "images", nullable = false)
    private Byte images;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "phone")
    private Long phone;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

}
