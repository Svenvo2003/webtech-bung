<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'
// axios import nicht nötig, wenn du fetch verwendest
// import axios from "axios";

const router = useRouter();
const backendMessage = ref<string>('Lade...');

// Interface für TypeScript definieren
interface ChatUser {
  id: number;
  firstname: string;
  lastname: string;
  age: number;
}

// ChatUser-Array (am Anfang leer, wird mit API-Daten gefüllt)
const chatUsers = ref<ChatUser[]>([]);

// 1. BACKEND VERBINDUNG TESTEN
async function requestmessage(): Promise<void> {
  try {
    const response = await fetch('https://bibs-chat-backend.onrender.com/api/v1/test');

    if (response.ok) {
      const text = await response.text();
      backendMessage.value = `✅ backend läuft`; // "✅ Hallo Wilkoomen, Backend geht!"
    } else {
      backendMessage.value = `❌ Backend-Fehler: ${response.status}`;
    }
  } catch (error) {
    backendMessage.value = '❌ Backend nicht erreichbar';
    console.error('Backend-Fehler:', error);
  }
}

// 2. PERSONEN VOM BACKEND LADEN
async function loadPersonsSimple(): Promise<void> {
  try {
    const response = await fetch('https://bibs-chat-backend.onrender.com/api/v1/persons');
    const persons = await response.json();
    console.log('Personen vom Backend:', persons);

    // WICHTIG: API-Daten in chatUsers speichern!
    chatUsers.value = persons.map((person: any, index: number) => ({
      id: index + 1, // Temporäre ID
      firstname: person.firstname,
      lastname: person.lastname,
      age: person.age
    }));

  } catch (error) {
    console.error('Fehler beim Laden der Personen:', error);
    backendMessage.value = '⚠️ Backend läuft, aber Personen konnten nicht geladen werden';
  }
}

// 3. BEIM START BEFÜLLEN
onMounted(() => {
  requestmessage();    // Backend testen
  loadPersonsSimple(); // Personen laden (RICHTIGE Funktion!)
});
</script>

<template>
  <div>
    <h1>💬 Bibs Chat</h1>
    <p>Frontend läuft erfolgreich! test ✅</p>

    <!-- Jetzt zeigt es das echte Backend-Status -->
    <p>Backend Status: <strong>{{ backendMessage }}</strong></p>

    <!-- Jetzt werden echte API-Daten angezeigt -->
    <div v-for="user in chatUsers" :key="user.id" class="col">
      <div class="card-body">
        <h5 class="card-title">{{ user.firstname }} {{ user.lastname }}</h5>
        <p class="card-text">
          {{ user.firstname }} {{ user.lastname }} ist im Chat und ist {{ user.age }} Jahre alt
        </p>
      </div>
    </div>

    <router-link to="/about">Zur About-Seite</router-link>
  </div>
</template>

<style scoped>
.col {
  margin-bottom: 1rem;
}
.card-body {
  padding: 1rem;
  border: 1px solid #ddd;
  border-radius: 8px;
  background-color: #f9f9f9;
}
.card-title {
  margin: 0 0 0.5rem 0;
  color: #333;
}
.card-text {
  margin: 0;
  color: #666;
}
</style>
