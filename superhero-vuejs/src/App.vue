<template>
  <div id="app">
    <h1>SuperHero App</h1>
    <SearchForm @search="fetchSuperHero" />
    <SuperHeroDetails :superHero="superHero" :mappedSuperHero="mappedSuperHero" />
  </div>
</template>

<script>
import axios from "axios";
import SearchForm from "@/components/SearchForm.vue";
import SuperHeroDetails from "@/components/SuperHeroDetails.vue";

export default {
  name: "App",
  components: {
    SearchForm,
    SuperHeroDetails,
  },
  data() {
    return {
      superHero: null,
      mappedSuperHero: null,
    };
  },
  methods: {
    async fetchSuperHero(searchTerm) {
      try {
        const isId = !isNaN(searchTerm); // Vérifie si c'est un ID
        const url = isId
          ? `https://cors-anywhere.herokuapp.com/https://superheroapi.com/api/695776d3ba15f87d84f2b936387baae1/${searchTerm}`
          : `https://cors-anywhere.herokuapp.com/https://superheroapi.com/api/695776d3ba15f87d84f2b936387baae1/search/${searchTerm}`;

        const response = await axios.get(url);
        this.superHero = isId ? response.data : response.data.results[0];

        // Appeler l'API backend pour récupérer les données mappées
        this.fetchMappedSuperHero(searchTerm);
      } catch (error) {
        console.error("Erreur lors de la récupération des données brutes :", error);
        this.superHero = null;
        this.mappedSuperHero = null;
      }
    },
    async fetchMappedSuperHero(name) {
      try {
        const response = await axios.get(`http://localhost:8080/superheroes/fromexternal/?name=${name}`);
        this.mappedSuperHero = response.data;
      } catch (error) {
        console.error("Erreur lors de la récupération des données mappées :", error);
        this.mappedSuperHero = null;
      }
    },
  },
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>