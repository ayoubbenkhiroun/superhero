package com.superhero.infrastructure.persistence;

import com.superhero.infrastructure.persistence.entity.SuperHeroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuperHeroJpaRepository extends JpaRepository<SuperHeroEntity, Long> {
}