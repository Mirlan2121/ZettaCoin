package ZettaCoin.demo1.entity;

import ZettaCoin.demo1.enam.Checkbox;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "MetaData")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Checkbox checked;


    @OneToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @OneToOne
    @JoinColumn(name = "current_company_id")
    private CurrentCompany currentCompany;

    @OneToOne
    @JoinColumn(name = "former_company_id")
    private FormerCompany formerCompany;

    @OneToOne
    @JoinColumn(name = "desired_position_id")
    private DesiredPosition desiredPosition;

    @OneToOne
    @JoinColumn(name = "")
    private Company company;



}
