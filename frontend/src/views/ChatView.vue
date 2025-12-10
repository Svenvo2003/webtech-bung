<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'
import axios from "axios";

const router = useRouter();
const backendMessage = ref<string>('Lade...');

// Interface für TypeScript definieren
interface ChatUser {
  id: number;
  firstname: string;
  lastname: string;
  age: number; // Nicht als Array, sondern als Zahl
}

// ChatUser-Array initialisieren
const chatUsers = ref<ChatUser[]>([
  {
    id: 1,
    firstname: 'Bibs',
    lastname: 'pumps',
    age: 19, // Jetzt als Zahl
  },
  {
    id: 2,
    firstname: 'sven',
    lastname: 'vo',
    age: 20, // Jetzt als Zahl
  },
]);


async function loadPersonsSimple(): Promise<void> {
  try {
    const response = await fetch('https://bibs-chat-backend.onrender.com/api/v1/persons');
    const persons = await response.json();
    console.log('Personen:', persons);
  } catch (error) {
    console.error('Fehler:', error);
  }
}


onMounted(() => {
  requestmessage(); // Originale Methode
  loadPersons();    // NEUE Methode für Personen
});
function requestmessage(): void {  // <-- Funktion definiert AUßERHALB
  // ...
}

function loadPersons(): void {     // <-- Funktion definiert AUßERHALB
  // ...
}
</script>

<template>
  <div>
    <h1>💬 Bibs Chat</h1>
    <p>Frontend läuft erfolgreich! test ✅</p>
    <p>Backend Status: <strong>{{ backendMessage }}</strong></p>

    <!-- Template korrigiert: chatUsers statt users, user als einzelnes Element -->
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
