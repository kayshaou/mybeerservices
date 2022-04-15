package com.anocha.learn.controller;

import com.anocha.learn.config.BeerConstants;
import com.anocha.learn.model.BeerDto;
import com.anocha.learn.model.BeerStyleEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@RunWith(SpringRunner.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(get(BeerConstants.BEER_ENDPOINT_V1 + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void saveBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("ABC")
                .version(2)
                .createdDatetime(OffsetDateTime.now())
                .lastModified(OffsetDateTime.now())
                .beerStyle(BeerStyleEnum.GOSE)
                .price(new BigDecimal(14.50))
                .quantityOnHand(300)
                .upc(23000449000l)
                .build();

        mockMvc.perform(post(BeerConstants.BEER_ENDPOINT_V1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beerDto)))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerById() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        mockMvc.perform(put(BeerConstants.BEER_ENDPOINT_V1 + UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(beerDto)))
                .andExpect(status().isNoContent());
    }
}