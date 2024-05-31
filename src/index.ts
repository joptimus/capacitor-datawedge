import { registerPlugin } from '@capacitor/core';

import type { DataWedgePluginPlugin } from './definitions';


export interface DataWedgePlugin {
  sendCommand(options: { command: string }): Promise<void>;
}

const DataWedgePlugin = registerPlugin<DataWedgePluginPlugin>('DataWedgePlugin', {
  web: () => import('./web').then(m => new m.DataWedgePluginWeb()),
});

export * from './definitions';
export { DataWedgePlugin };
