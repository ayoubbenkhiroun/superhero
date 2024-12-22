package com.superhero.application.services;

import com.superhero.application.ports.output.SuperHeroRepositoryPort;
import com.superhero.domain.model.SuperHero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class SuperHeroServiceImplTest {

    @Mock
    private SuperHeroRepositoryPort superHeroRepositoryPort;

    @InjectMocks
    private SuperHeroServiceImpl superHeroService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateSuperHero() {
        // Arrange
        SuperHero superHero = new SuperHero();
        superHero.setName("Spiderman");
        superHero.setAlias("Peter Parker");

        when(superHeroRepositoryPort.save(any(SuperHero.class))).thenReturn(superHero);

        // Act
        SuperHero createdSuperHero = superHeroService.createSuperHero(superHero);

        // Assert
        assertThat(createdSuperHero).isNotNull();
        assertThat(createdSuperHero.getName()).isEqualTo("Spiderman");
        verify(superHeroRepositoryPort, times(1)).save(any(SuperHero.class));
    }

    @Test
    void testGetSuperHeroById() {
        // Arrange
        SuperHero superHero = new SuperHero();
        superHero.setId(1L);
        superHero.setName("Spiderman");
        superHero.setAlias("Peter Parker");

        when(superHeroRepositoryPort.findById(1L)).thenReturn(Optional.of(superHero));

        // Act
        Optional<SuperHero> foundSuperHero = superHeroService.getSuperHeroById(1L);

        // Assert
        assertThat(foundSuperHero).isPresent();
        assertThat(foundSuperHero.get().getName()).isEqualTo("Spiderman");
        verify(superHeroRepositoryPort, times(1)).findById(1L);
    }

    @Test
    void testDeleteSuperHeroById() {
        // Arrange
        doNothing().when(superHeroRepositoryPort).deleteById(1L);

        // Act
        superHeroService.deleteSuperHeroById(1L);

        // Assert
        verify(superHeroRepositoryPort, times(1)).deleteById(1L);
    }
}