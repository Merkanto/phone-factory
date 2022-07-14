package factory.phone.phone.service;

import factory.phone.phone.web.model.PhoneDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
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

    @Override
    public void deleteById(UUID phoneId) {
        log.debug("Deleting a phone...");
    }
}
