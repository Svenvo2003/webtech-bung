<script setup lang="ts">
import { useRouter } from 'vue-router'

const router = useRouter();
function navigateSite() {
  router.push('/home');
}
</script>

<template>
  <div>
    <h1>💬 Bibs Chat </h1>
    <p>Frontend läuft erfolgreich! ✅</p>
    <div style="background: #e8f5e8; padding: 20px; border-radius: 10px; margin: 20px;">
      <h3>Chat-Funktion:</h3>
      <p>✅ Nachrichten senden</p>
      <p>✅ Kontaktliste</p>
      <p>✅ Echtzeit-Kommunikation</p>
    </div>
    <router-link to="/about">Zur About-Seite</router-link>
  </div>
</template>

<script setup lang="ts">
</script>
