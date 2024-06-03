import { WebPlugin } from '@capacitor/core';

import type { DataWedgePlugin } from './definitions';

export class DataWedgePluginWeb extends WebPlugin implements DataWedgePlugin {
  sendCommand(options: { command: string; }): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
