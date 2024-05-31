export interface DataWedgePluginPlugin {
  sendCommand(options: { command: string }): Promise<void>;
}
