import { registerPlugin } from '@capacitor/core';



export interface DataWedgePlugin {
  sendCommand(options: { command: string }): Promise<void>;
}

const DataWedge = registerPlugin<DataWedgePlugin>('DataWedgePlugin', {
  web: () => import('./web').then(m => new m.DataWedgePluginWeb()),
});

export * from './definitions';
export { DataWedge };
