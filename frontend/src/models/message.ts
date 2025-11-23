export interface Message {
  userName: string;
  message: string;
  timestamp?: Date; // Optional: für Zeitstempel
}

// Oder als Klasse:
export class MessageClass {
  constructor(
    public userName: string,
    public message: string,
    public timestamp: Date = new Date()
  ) {}
}
