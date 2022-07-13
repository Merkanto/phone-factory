package factory.phone.phone.web.service;

import factory.phone.phone.web.model.PhoneDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Override
    public PhoneDto getPhoneById(UUID phoneId) {
        return PhoneDto.builder()
                .id(UUID.randomUUID())
                .phoneName("Samsung Galaxy Z")
                .phoneStyle("Flip")
                .build();
    }

    @Override
    public PhoneDto saveNewPhone(PhoneDto phoneDto) {
        return PhoneDto.builder()
                .id(UUID.randomUUID())
                .build();
    }

    @Override
    public void updatePhone(UUID phoneId, PhoneDto phoneDto) {

    }
}
