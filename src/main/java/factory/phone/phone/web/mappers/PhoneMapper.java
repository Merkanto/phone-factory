package factory.phone.phone.web.mappers;

import factory.phone.phone.domain.Phone;
import factory.phone.phone.web.model.PhoneDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface PhoneMapper {

        PhoneDto phoneToPhoneDto(Phone phone);

        Phone phoneDtoToPhone(PhoneDto dto);
}
