import { WebPlugin } from '@capacitor/core';

import type { DataWedgePluginPlugin } from './definitions';

export class DataWedgePluginWeb extends WebPlugin implements DataWedgePluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
