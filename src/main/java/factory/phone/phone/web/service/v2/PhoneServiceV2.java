package factory.phone.phone.web.service.v2;

import factory.phone.phone.web.model.v2.PhoneDtoV2;

import java.util.UUID;

public interface PhoneServiceV2 {
    PhoneDtoV2 getPhoneById(UUID phoneId);

    PhoneDtoV2 saveNewPhone(PhoneDtoV2 phoneDto);

    void updatePhone(UUID phoneId, PhoneDtoV2 phoneDto);

    void deleteById(UUID phoneId);
}
