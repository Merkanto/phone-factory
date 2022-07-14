package factory.phone.phone.web.controller.v2;

import factory.phone.phone.web.model.v2.PhoneDtoV2;
import factory.phone.phone.service.v2.PhoneServiceV2;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v2/phone")
@RestController
public class PhoneControllerV2 {

    private final PhoneServiceV2 phoneServiceV2;

    @GetMapping({"/{phoneId}"})
    public ResponseEntity<PhoneDtoV2> getPhone(@NotNull @PathVariable("phoneId") UUID phoneId) {
        return new ResponseEntity<>(phoneServiceV2.getPhoneById(phoneId), HttpStatus.OK);
    }

    @PostMapping // create new phone
    public ResponseEntity handlePost(@Valid @NotNull @RequestBody PhoneDtoV2 phoneDto) {
        log.debug("in handle post...");

        val savedDto = phoneServiceV2.saveNewPhone(phoneDto);

        var headers = new HttpHeaders();
        headers.add("Location", "/api/v2/phone/" + savedDto.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping({"/{phoneId}"}) // update phone
    public ResponseEntity handleUpdate(@PathVariable("phoneId") UUID phoneId, @Valid @RequestBody PhoneDtoV2 phoneDto) {
        phoneServiceV2.updatePhone(phoneId, phoneDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping({"/{phoneId}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePhone(@PathVariable("phoneId") UUID phoneId) {
        phoneServiceV2.deleteById(phoneId);
    }

}
