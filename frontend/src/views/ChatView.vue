<script setup lang="ts">
import { useRouter } from 'vue-router'
import { ref, onMounted } from 'vue'

const router = useRouter();
const backendMessage = ref<string>('Lade...');
const postResult = ref<string>('');
const isPosting = ref<boolean>(false);

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
      backendMessage.value = ` Backend läuft`; // " Hallo Wilkoomen, Backend geht!"
    } else {
      backendMessage.value = ` Backend-Fehler: ${response.status}`;
    }
  } catch (error) {
    backendMessage.value = ' Backend nicht erreichbar';
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

// 3. POST-FUNKTION FÜR DIE DEADLINE
async function testPostRoute() {
  isPosting.value = true;
  postResult.value = ' Sende POST an Backend...';

  try {
    const response = await fetch('https://bibs-chat-backend.onrender.com/api/v1/persons', {
      method: 'POST', // WICHTIG für Deadline!
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        firstname: 'Test',
        lastname: 'User',
        age: 25
      })
    });

    const result = await response.text();
    console.log('POST-Ergebnis:', result);

    if (response.ok) {
      postResult.value = ` POST erfolgreich! ${result}`;
      // Personenliste neu laden
      await loadPersonsSimple();
    } else {
      postResult.value = ` POST-Fehler: ${result}`;
    }

  } catch (error) {
    postResult.value = ' Netzwerkfehler beim POST';
    console.error('POST-Fehler:', error);
  } finally {
    isPosting.value = false;
  }
}

// 4. ALLES BEIM START LADEN
onMounted(() => {
  requestmessage();    // Backend testen
  loadPersonsSimple(); // Personen laden
});
</script>

<template>
  <div>
    <h1>💬 Bibs Chat</h1>
    <p>Frontend läuft erfolgreich! test </p>
    <p>Backend Status: <strong>{{ backendMessage }}</strong></p>

    <!-- POST-Button für die Deadline -->
    <div class="deadline-section">
      <h3>📤 POST-Route Test </h3>
      <button @click="testPostRoute" :disabled="isPosting" class="post-button">
        {{ isPosting ? ' Speichere...' : ' POST-Route testen' }}
      </button>

      <div v-if="postResult" class="post-result">
        {{ postResult }}
      </div>

      <p class="hint">
        <small>Klick = Frontend ruft POST-Route auf → Daten werden in Datenbank gespeichert</small>
      </p>
    </div>

    <!-- Personen-Liste -->
    <h3>Personen im Chat ({{ chatUsers.length }})</h3>
    <div v-if="chatUsers.length === 0">
      <p>Keine Personen geladen...</p>
    </div>

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

/* Styling für POST-Button */
.deadline-section {
  margin: 2rem 0;
  padding: 1.5rem;
  background: #f8f9fa;
  border: 2px dashed #007bff;
  border-radius: 10px;
}

.post-button {
  background: #007bff;
  color: white;
  border: none;
  padding: 12px 24px;
  border-radius: 6px;
  font-size: 16px;
  cursor: pointer;
  font-weight: bold;
  margin-bottom: 1rem;
}

.post-button:hover:not(:disabled) {
  background: #0056b3;
}

.post-button:disabled {
  background: #6c757d;
  cursor: not-allowed;
}

.post-result {
  padding: 1rem;
  background: white;
  border-radius: 6px;
  border-left: 4px solid #28a745;
  font-family: monospace;
  margin: 1rem 0;
}

.hint {
  color: #666;
  font-size: 0.9rem;
  margin-top: 0.5rem;
}
</style>
