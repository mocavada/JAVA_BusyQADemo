import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TestAuthService {

  constructor() { }
  isAuthenticated(): boolean {

    //.....
    //
    return !!localStorage.getItem('token');
  }

  isNotCalled() {
  }

  isAuthenticatedAsync(): Promise<boolean> {
    return Promise.resolve(!!localStorage.getItem('token'));

    // !! ensure the resulting type is a boolean
    // !!(...) =====> localStorage.getItem('token') != null ? true : false.
  }
}
