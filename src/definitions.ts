export interface DataWedgePlugin {
  sendCommand(options: { command: string }): Promise<void>;
}
