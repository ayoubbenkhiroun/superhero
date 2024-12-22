package com.superhero.infrastructure.web;

import com.superhero.domain.model.SuperHero;
import com.superhero.application.ports.input.SuperHeroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/superheroes")
@Tag(name = "SuperHero", description = "Endpoints for managing superheroes")
public class SuperHeroController {

    private final SuperHeroService superHeroService;

    public SuperHeroController(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }

    @Operation(summary = "Get all superheroes", description = "Retrieve a list of all superheroes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of superheroes"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public List<SuperHero> getAllSuperHeroes() {
        return superHeroService.getAllSuperHeroes();
    }

    @Operation(summary = "Get a superhero by ID", description = "Retrieve a superhero by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the superhero"),
            @ApiResponse(responseCode = "404", description = "Superhero not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/{id}")
    public ResponseEntity<SuperHero> getSuperHeroById(@PathVariable Long id) {
        return superHeroService.getSuperHeroById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create a new superhero", description = "Create a new superhero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created the superhero"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping
    public ResponseEntity<SuperHero> createSuperHero(@RequestBody SuperHero superHero) {
        SuperHero createdSuperHero = superHeroService.createSuperHero(superHero);
        return ResponseEntity.ok(createdSuperHero);
    }

    @Operation(summary = "Delete a superhero by ID", description = "Delete a superhero by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted the superhero"),
            @ApiResponse(responseCode = "404", description = "Superhero not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSuperHeroById(@PathVariable Long id) {
        if (superHeroService.getSuperHeroById(id).isPresent()) {
            superHeroService.deleteSuperHeroById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }






    @Operation(summary = "Get a superhero by name", description = "Retrieve a superhero by their name from the external API and map it to the internal domain model.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Superhero found", content = @Content(schema = @Schema(implementation = SuperHero.class))),
            @ApiResponse(responseCode = "404", description = "Superhero not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/fromexternal/")
    public ResponseEntity<SuperHero> getSuperHeroByName(
            @Parameter(description = "Name of the superhero to search for", example = "Batman")
            @RequestParam String name) {
        try {
            SuperHero superhero = superHeroService.getSuperHeroByName(name);
            return ResponseEntity.ok(superhero);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


}