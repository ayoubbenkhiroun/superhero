<template>
    <div class="home">
      <SearchForm @search="fetchSuperHero" />
      <SuperHeroDetails :superHero="superHero" />
    </div>
  </template>
  
  <script>
  import axios from "axios";
  import SearchForm from "@/components/SearchForm.vue";
  import SuperHeroDetails from "@/components/SuperHeroDetails.vue";
  
  export default {
    components: {
      SearchForm,
      SuperHeroDetails,
    },
    data() {
      return {
        superHero: null,
      };
    },
    methods: {
      async fetchSuperHero(searchTerm) {
        try {
          const isId = !isNaN(searchTerm); // Vérifie si c'est un ID
          const url = isId
            ? `https://superheroapi.com/api/695776d3ba15f87d84f2b936387baae1/${searchTerm}`
            : `https://superheroapi.com/api/695776d3ba15f87d84f2b936387baae1/search/${searchTerm}`;
  
          const response = await axios.get(url);
          this.superHero = isId ? response.data : response.data.results[0];
        } catch (error) {
          console.error("Erreur lors de la récupération des données :", error);
          this.superHero = null;
        }
      },
    },
  };
  </script>
  
  <style scoped>
  .home {
    padding: 20px;
  }
  </style>