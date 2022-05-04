export interface appversionPlugin {
  getInfoFromOs(_options: { requestFor: rqType} ): Promise<{ results: any[] }>;
}
export enum rqType{
  // get app name
  appName,
  //get app package name
  PackageName,
  //get app version number
  VersionNumber,
  // get app version code
  VersionCode,
  //get device runing android version
  androidVer,
  // get device target sdk version
  androidSdkVersion, 
  // get device os name
  androidOsName
}