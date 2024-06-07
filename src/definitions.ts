export interface DataWedgePlugin {
  sendCommand(options: { command: string }): Promise<void>;
  setConfigProfile(options: { config: any }): Promise<void>;
  echo(options: { value: string }): Promise<{ value: string }>;
}
