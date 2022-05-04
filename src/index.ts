import { registerPlugin } from '@capacitor/core';

import type { appversionPlugin } from './definitions';

const appversion = registerPlugin<appversionPlugin>('appversion', {
  web: () => import('./web').then(m => new m.appversionWeb()),
});

export * from './definitions';
export { appversion };
