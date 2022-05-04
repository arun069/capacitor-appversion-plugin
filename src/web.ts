import { WebPlugin } from '@capacitor/core';

import type { appversionPlugin } from './definitions';

export class appversionWeb extends WebPlugin implements appversionPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
