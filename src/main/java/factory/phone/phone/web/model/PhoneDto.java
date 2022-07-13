package factory.phone.phone.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhoneDto {

    private UUID id;
    private String phoneName;
    private String phoneStyle;
    private Long imei;
}
