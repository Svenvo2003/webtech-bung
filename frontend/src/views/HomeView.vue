<template>
  <div class="container mt-4">
    <div class="row">
      <!-- Linke Spalte - Kontaktliste -->
      <div class="col-md-4">
        <div class="card">
          <div class="card-header">
            <h5>Kontakte</h5>
          </div>
          <div class="list-group">
            <div class="list-group-item">
              <strong>Max Mustermann</strong> <span class="badge bg-success">online</span>
            </div>
            <div class="list-group-item">
              <strong>Anna Schmidt</strong> <span class="badge bg-secondary">offline</span>
            </div>
          </div>
        </div>
      </div>

      <!-- Rechte Spalte - Chatbereich -->
      <div class="col-md-8">
        <div class="card">
          <div class="card-header bg-light">
            <strong>Chat mit Max Mustermann</strong>
          </div>
          <div class="card-body chat-window">
            <div class="message them">Hallo, wie geht es dir?</div>
            <div class="message me">Alles gut, danke!</div>
          </div>
          <div class="card-footer">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="Nachricht schreiben...">
              <button class="btn btn-primary">Senden</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.chat-window {
  height: 400px;
  overflow-y: auto;
}
.message {
  padding: 8px 12px;
  margin: 5px;
  border-radius: 15px;
  max-width: 70%;
}
.message.them {
  background: #e9ecef;
  align-self: flex-start;
}
.message.me {
  background: #007bff;
  color: white;
  align-self: flex-end;
  margin-left: auto;
}
</style>
