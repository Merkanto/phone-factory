package factory.phone.phone.service;

import factory.phone.phone.web.model.PhoneDto;

import java.util.UUID;

public interface PhoneService {
    PhoneDto getPhoneById(UUID phoneId);

    PhoneDto saveNewPhone(PhoneDto phoneDto);

    void updatePhone(UUID phoneId, PhoneDto phoneDto);

    void deleteById(UUID phoneId);
}
