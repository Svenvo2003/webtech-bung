<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'
import axios from "axios";

const router = useRouter();
const backendMessage = ref('Lade...');


function requestmessage(): void {
  axios.get<string>('https://bibs-chat-backend.onrender.com/api/v1/test')
    .then((response) => {
      backendMessage.value = response.data;
    })
    .catch((error) => console.log(error));
}

onMounted(() => requestmessage());
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
