import { WebPlugin } from '@capacitor/core';

import type { appversionPlugin, rqType } from './definitions';

export class appversionWeb extends WebPlugin implements appversionPlugin {
  getInfoFromOs(_options: { requestFor: rqType}): Promise<{ results: any[]; }> {
    return Promise.resolve({results: [{ message: 'this plugin only developed for android!' }]})
  }
 
}
