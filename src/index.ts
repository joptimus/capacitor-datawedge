import { registerPlugin } from '@capacitor/core';



export interface DataWedgePlugin {
  sendCommand(options: { command: string }): Promise<void>;
  setConfigProfile(options: { config: any }): Promise<void>;
  echo(options: { value: string }): Promise<{ value: string }>;
}

const DataWedge = registerPlugin<DataWedgePlugin>('DataWedgePlugin', {
  web: () => import('./web').then(m => new m.DataWedgePluginWeb()),
});

export * from './definitions';
export { DataWedge };
