package com.superhero.infrastructure.web;

import com.superhero.domain.model.SuperHero;
import com.superhero.infrastructure.persistence.SuperHeroJpaRepository;
import com.superhero.infrastructure.persistence.entity.SuperHeroEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class SuperHeroControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SuperHeroJpaRepository superHeroJpaRepository;

    @BeforeEach
    void setUp() {
        // Clean up the database before each test
        superHeroJpaRepository.deleteAll();
    }

    @Test
    void testCreateSuperHero() throws Exception {
        // Arrange
        String superHeroJson = "{\"name\": \"Spiderman\", \"alias\": \"Peter Parker\"}";

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/superheroes")
                        .contentType("application/json")
                        .content(superHeroJson))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Spiderman"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.alias").value("Peter Parker"));
    }

    @Test
    void testGetSuperHeroById() throws Exception {
        // Arrange
        SuperHeroEntity superHeroEntity = new SuperHeroEntity();
        superHeroEntity.setName("Spiderman");
        superHeroEntity.setAlias("Peter Parker");
        superHeroJpaRepository.save(superHeroEntity);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/superheroes/{id}", superHeroEntity.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Spiderman"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.alias").value("Peter Parker"));
    }

    @Test
    void testDeleteSuperHeroById() throws Exception {
        // Arrange
        SuperHeroEntity superHeroEntity = new SuperHeroEntity();
        superHeroEntity.setName("Spiderman");
        superHeroEntity.setAlias("Peter Parker");
        superHeroJpaRepository.save(superHeroEntity);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/superheroes/{id}", superHeroEntity.getId()))
                .andDo(print())
                .andExpect(status().isOk()); // Vérifie que la suppression réussit

        // Vérifie que le super-héro n'existe plus
        mockMvc.perform(MockMvcRequestBuilders.get("/superheroes/{id}", superHeroEntity.getId()))
                .andDo(print())
                .andExpect(status().isNotFound()); // Vérifie que la réponse est un statut 404
    }
}