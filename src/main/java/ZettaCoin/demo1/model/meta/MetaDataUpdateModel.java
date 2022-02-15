package ZettaCoin.demo1.model.meta;


import ZettaCoin.demo1.enam.Checkbox;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MetaDataUpdateModel {
    private Long id;
    private Checkbox checkbox;
    private Long developerId;
    private Long currentCompanyId;
    private Long formerCompanyId;
    private Long desiredPositionId;
}
