package factory.phone.phone.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import factory.phone.phone.web.model.PhoneDto;
import factory.phone.phone.web.service.PhoneService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PhoneController.class)
public class PhoneControllerTest {

    @MockBean
    PhoneService phoneService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    PhoneDto validPhone;

    @Before
    public void setUp() {
        validPhone = PhoneDto.builder().id(UUID.randomUUID())
                .phoneName("Samsung Galaxy Z")
                .phoneStyle("Fold")
                .imei(123456789012L)
                .build();
    }

    @Test
    public void getPhone() throws Exception {
        given(phoneService.getPhoneById(any(UUID.class))).willReturn(validPhone);

        mockMvc.perform(get("/api/v1/phone/" + validPhone.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(validPhone.getId().toString())))
                .andExpect(jsonPath("$.phoneName", is("Samsung Galaxy Z")));
    }

    @Test
    public void handlePost() throws Exception {
        //given
        PhoneDto phoneDto = validPhone;
        phoneDto.setId(null);
        PhoneDto savedDto = PhoneDto.builder().id(UUID.randomUUID()).phoneName("New Phone").build();
        String phoneDtoJson = objectMapper.writeValueAsString(phoneDto);

        given(phoneService.saveNewPhone(any())).willReturn(savedDto);

        mockMvc.perform(post("/api/v1/phone/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(phoneDtoJson))
                .andExpect(status().isCreated());

    }

    @Test
    public void handleUpdate() throws Exception {
        //given
        PhoneDto phoneDto = validPhone;
        phoneDto.setId(null);
        String phoneDtoJson = objectMapper.writeValueAsString(phoneDto);

        //when
        mockMvc.perform(put("/api/v1/phone/" + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(phoneDtoJson))
                .andExpect(status().isNoContent());

        then(phoneService).should().updatePhone(any(), any());

    }
}