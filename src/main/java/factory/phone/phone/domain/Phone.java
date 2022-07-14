package factory.phone.phone.domain;

import factory.phone.phone.web.model.v2.PhoneStyleEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Phone {

    private UUID id;
    private String phoneName;
    private PhoneStyleEnum phoneStyle;
    private Long imei;

    private Timestamp createdData;
    private Timestamp lastUpdatedDate;
}
