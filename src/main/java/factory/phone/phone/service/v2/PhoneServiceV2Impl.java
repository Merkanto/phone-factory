package factory.phone.phone.service.v2;

import factory.phone.phone.web.model.v2.PhoneDtoV2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PhoneServiceV2Impl implements PhoneServiceV2 {
    @Override
    public PhoneDtoV2 getPhoneById(UUID phoneId) {
        return null;
    }

    @Override
    public PhoneDtoV2 saveNewPhone(PhoneDtoV2 phoneDto) {
        return null;
    }

    @Override
    public void updatePhone(UUID phoneId, PhoneDtoV2 phoneDto) {

    }

    @Override
    public void deleteById(UUID phoneId) {

    }
}
