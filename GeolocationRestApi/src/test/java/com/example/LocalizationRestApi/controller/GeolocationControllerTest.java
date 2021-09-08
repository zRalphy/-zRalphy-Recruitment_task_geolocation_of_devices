package com.example.LocalizationRestApi.controller;

import com.example.LocalizationRestApi.model.Geolocation;
import com.example.LocalizationRestApi.repository.GeolocationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser
class GeolocationControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private GeolocationRepository geolocationRepository;

    @Test
    @Transactional
    void shouldGetSingleGeolocation() throws Exception {
        // given
        Geolocation newGeolocation = new Geolocation();
        newGeolocation.setId(11L);
        newGeolocation.setDeviceId(123987);
        newGeolocation.setLatitiude(123123);
        newGeolocation.setLongitude(321321);
        geolocationRepository.save(newGeolocation);

        // when
        MvcResult mvcResult = mockMvc.perform(get("/geolocations/" + newGeolocation.getId()))
                .andDo(print())
                .andExpect(status().is(200))
                .andReturn();

        // then
        Geolocation geolocation = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), Geolocation.class);
        assertThat(geolocation).isNotNull();
        assertThat(geolocation.getId()).isEqualTo(newGeolocation.getId());
        assertThat(geolocation.getDeviceId()).isEqualTo(123987);
        assertThat(geolocation.getLatitiude()).isEqualTo(123123);
        assertThat(geolocation.getLongitude()).isEqualTo(321321);
    }
}