module.exports = {
  devServer: {
    proxy: {
      "/api": {
        target: "https://superheroapi.com", // URL de l'API SuperHero
        changeOrigin: true, // Permet de changer l'origine de la requête
        pathRewrite: { "^/api": "" }, // Remplace le préfixe "/api" par une chaîne vide
      },
    },
  },
};