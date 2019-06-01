// This file can be replaced during build by using the `fileReplacements` array.
// `ng build ---prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
  production: false,
  exampleServerAddr: 'https://jsonplaceholder.typicode.com',
  //  serverAddress: 'http://127.0.0.1:8080',
  // serverAddress: 'http://192.168.99.100:8080',  // for docker images
  // serverAddress: 'http://192.168.99.100:31720', // for k8s
  // serverAddress: 'http://backendhost.org:80',    // for fake dns host
  serverAddress: 'http://localhost:8080',       // if on the same host, use relative path
  // serverAddress: '',       // if on the same host, use relative path
  debug: true
};

/*
 * In development mode, to ignore zone related error stack frames such as
 * `zone.run`, `zoneDelegate.invokeTask` for easier debugging, you can
 * import the following file, but please comment it out in production mode
 * because it will have performance impact when throw error
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
