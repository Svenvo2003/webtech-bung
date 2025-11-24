<script setup lang="ts">
import { ref, onMounted } from 'vue'

const backendMessage = ref('Lade...');

// API-Call zu deinem Render Backend
onMounted(async () => {
  try {
    const response = await fetch('https://bibs-chat-backend.onrender.com/api/v1/test');
    backendMessage.value = await response.text();
  } catch (error) {
    backendMessage.value = 'Backend nicht erreichbar';
  }
});
</script>

<template>
  <div>
    <h1>💬 Bibs Chat</h1>
    <p>Frontend läuft erfolgreich! ✅</p>
    <p>Backend Status: <strong>{{ backendMessage }}</strong></p>
    <div style="background: #e8f5e8; padding: 20px; border-radius: 10px; margin: 20px;">
      <h3>Chat-Funktion:</h3>
      <p>✅ Nachrichten senden</p>
      <p>✅ Kontaktliste</p>
      <p>✅ Echtzeit-Kommunikation</p>
    </div>
    <router-link to="/about">Zur About-Seite</router-link>
  </div>
</template>
