package ZettaCoin.demo1.model.meta;

import ZettaCoin.demo1.enam.Checkbox;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MetaDataModel {
    private Checkbox checkbox;
    private Long developer;
    private Long currentCompany;
    private Long formerCompany;
    private Long desiredPosition;
}
