<template>
  <div id="app">
    <nav class="navbar navbar-dark bg-primary">
      <div class="container">
        <a class="navbar-brand" href="#">💬 StereoChat</a>
        <div class="navbar-nav">
          <router-link to="/" class="nav-link">Chat</router-link>
          <router-link to="/about" class="nav-link">Über</router-link>
        </div>
      </div>
    </nav>
    <router-view/>
  </div>
</template>
