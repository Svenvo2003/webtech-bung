<template>
  <div class="dynamic-form">
    <h2>{{ title }}</h2>

    <!-- HIER IST DAS v-for -->
    <ul>
      <li v-for="item in items" :key="item.id">
        {{ item.name }}
      </li>
    </ul>

    <form>
      <input type="text" placeholder="Name">
      <button type="submit">Senden</button>
    </form>
  </div>
</template>

<script setup lang="ts">
defineProps<{
  title: string
}>()

// Daten für v-for
const items = [
  { id: 1, name: 'Chat 1' },
  { id: 2, name: 'Chat 2' },
  { id: 3, name: 'Chat 3' }
]
</script>d
