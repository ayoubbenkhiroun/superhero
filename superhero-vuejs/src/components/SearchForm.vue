<template>
  <div class="search-form">
    <h2>Rechercher un Super Héros</h2>
    <form @submit.prevent="searchSuperHero">
      <label for="searchTerm">Nom ou ID du Super Héros :</label>
      <input
        type="text"
        id="searchTerm"
        v-model="searchTerm"
        placeholder="Ex: Batman ou 70"
      />
      <button type="submit">Rechercher</button>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      searchTerm: "",
    };
  },
  methods: {
    searchSuperHero() {
      this.$emit("search", this.searchTerm);
    },
  },
};
</script>

<style scoped>
.search-form {
  margin-bottom: 20px;
}
input {
  padding: 10px;
  margin-right: 10px;
}
button {
  padding: 10px 20px;
  background-color: #007bff;
  color: white;
  border: none;
  cursor: pointer;
}
</style>