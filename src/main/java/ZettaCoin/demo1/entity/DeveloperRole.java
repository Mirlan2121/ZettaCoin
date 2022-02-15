package ZettaCoin.demo1.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "developer_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeveloperRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name")
    private String roleName;

    @OneToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;
}
