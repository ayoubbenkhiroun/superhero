<template>
    <div v-if="superHero" class="superhero-details">
      <h2>Détails du Super Héros</h2>
      <div class="details-container">
        <!-- Colonne 1 : Format Brut (API Externe) -->
        <div class="raw-details">
          <h3>Format Brut (API Externe)</h3>
          <div class="json-container">
            <pre>{{ superHero }}</pre>
          </div>
        </div>
  
        <!-- Colonne 2 : Format Transformé (API Backend) -->
        <div class="mapped-details">
          <h3>Format Transformé (API Backend)</h3>
          <div v-if="mappedSuperHero">
            <!-- Section : Image du Super-Héros -->
            <div class="section image-section">
              <img :src="superHero.image.url" :alt="superHero.name" />
            </div>
  
            <!-- Section : Nom et Alias -->
            <div class="section">
              <p><strong>Nom :</strong> {{ mappedSuperHero.name }}</p>
              <p><strong>Alias :</strong> {{ mappedSuperHero.alias }}</p>
            </div>
  
            <!-- Section : Pouvoirs -->
            <div class="section">
              <h4>Pouvoirs</h4>
              <ul>
                <li v-for="power in mappedSuperHero.powers" :key="power.name">
                  <strong>{{ power.name }}</strong> : {{ power.description }}
                </li>
              </ul>
            </div>
  
            <!-- Section : Compétences -->
            <div class="section">
              <h4>Compétences</h4>
              <ul>
                <li v-for="ability in mappedSuperHero.abilities" :key="ability.name">
                  <strong>{{ ability.name }}</strong> : {{ ability.description }}
                </li>
              </ul>
            </div>
  
            <!-- Section : Capacités Magiques -->
            <div class="section">
              <h4>Capacités Magiques</h4>
              <ul>
                <li v-for="magic in mappedSuperHero.magicalAbilities" :key="magic.name">
                  <strong>{{ magic.name }}</strong> : {{ magic.description }}
                </li>
              </ul>
            </div>
          </div>
          <div v-else>
            <p>Aucune donnée mappée trouvée.</p>
          </div>
        </div>
      </div>
    </div>
    <div v-else>
      <p>Aucun super-héros trouvé.</p>
    </div>
  </template>

<script>
export default {
  props: {
    superHero: {
      type: Object,
      default: null,
    },
    mappedSuperHero: {
      type: Object,
      default: null,
    },
  },
};
</script>

<style scoped>
.superhero-details {
  font-family: Arial, sans-serif;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}

h2 {
  text-align: center;
  color: #333;
  margin-bottom: 20px;
}

.details-container {
  display: flex;
  justify-content: space-between;
  gap: 20px;
}

.raw-details,
.mapped-details {
  flex: 1;
  padding: 20px;
  border: 1px solid #ddd;
  border-radius: 8px;
  background-color: #fff;
}

.raw-details h3,
.mapped-details h3 {
  color: #555;
  margin-bottom: 15px;
}

/* Conteneur pour le JSON brut */
.json-container {
  max-height: 400px; /* Limite la hauteur pour un défilement vertical */
  overflow-y: auto; /* Ajoute un défilement vertical si nécessaire */
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 10px;
  background-color: #f4f4f4;
  font-size: 14px;
  color: #333;
}

pre {
  margin: 0; /* Supprime la marge par défaut */
  white-space: pre-wrap; /* Permet de passer à la ligne si le texte est trop long */
  word-break: break-all; /* Permet de casser les mots si nécessaire */
}

.mapped-details .section {
  margin-bottom: 20px;
}

.mapped-details h4 {
  color: #007bff;
  margin-bottom: 10px;
}

.mapped-details ul {
  list-style-type: none;
  padding: 0;
}

.mapped-details li {
  background-color: #f1f1f1;
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 4px;
  color: #333;
}

.mapped-details li strong {
  color: #007bff;
}

/* Styles pour l'image du super-héros */
.image-section {
  text-align: center;
  margin-bottom: 20px;
}

.image-section img {
  max-width: 100%;
  height: auto;
  border-radius: 8px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
</style>