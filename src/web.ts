import { WebPlugin } from '@capacitor/core';

import type { DataWedgePlugin } from './definitions';

export class DataWedgeWeb extends WebPlugin implements DataWedgePlugin {
  async enable(): Promise<void> {
    throw 'DataWedge is not supported on web';
  }

  async disable(): Promise<void> {
    throw 'DataWedge is not supported on web';
  }

  async enableScanner(): Promise<void> {
    throw 'DataWedge is not supported on web';
  }

  async disableScanner(): Promise<void> {
    throw 'DataWedge is not supported on web';
  }

  async startScanning(): Promise<void> {
    throw 'DataWedge is not supported on web';
  }

  async stopScanning(): Promise<void> {
    throw 'DataWedge is not supported on web';
  }

  async __registerReceiver(): Promise<void> {
    // no-op
  }

  setConfigProfile(_options: { config: any; }): Promise<void> {
    throw new Error('Method not implemented.');
  }
  sendCommand(options: { command: string; }): Promise<void> {
    console.log(options);
    throw new Error('Method not implemented.');
  }
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
