package com.superhero.infrastructure.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SuperHeroControllerValidationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testCreateSuperHeroWithInvalidData() throws Exception {
        String invalidSuperHeroJson = "{\"alias\": \"Peter Parker\", \"powers\": [], \"abilities\": [], \"magicalAbilities\": []}";

        mockMvc.perform(post("/superheroes")
                        .contentType("application/json")
                        .content(invalidSuperHeroJson))
                .andExpect(status().isBadRequest());
    }
}