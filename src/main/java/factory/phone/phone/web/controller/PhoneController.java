package factory.phone.phone.web.controller;

import factory.phone.phone.web.model.PhoneDto;
import factory.phone.phone.web.service.PhoneService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/v1/phone")
@RestController
public class PhoneController {

    private final PhoneService phoneService;

    public PhoneController(PhoneService phoneService) {
        this.phoneService = phoneService;
    }

    @GetMapping({"/{phoneId}"})
    public ResponseEntity<PhoneDto> getPhone(@PathVariable("phoneId") UUID phoneId) {
        return new ResponseEntity<>(phoneService.getPhoneById(phoneId), HttpStatus.OK);
    }

    @PostMapping // create new phone
    public ResponseEntity handlePost(PhoneDto phoneDto) {
        PhoneDto savedDto = phoneService.saveNewPhone(phoneDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/phone" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{phoneId}"}) // update phone
    public ResponseEntity handleUpdate(@PathVariable("phoneId") UUID phoneId, PhoneDto phoneDto) {
        phoneService.updatePhone(phoneId, phoneDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{phoneId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhone(@PathVariable("phoneId") UUID phoneId) {
        phoneService.deleteById(phoneId);
    }
}
