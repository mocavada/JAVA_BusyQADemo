import { HttpClient } from '@angular/common/http';
import { JobbankService } from './jobbank.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { throwError } from 'rxjs';
import { catchError, map, take } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { LoginStatus } from '../pojo/login-status';

@Injectable({
  providedIn: 'root'
})
export class LoggedInGuard implements CanActivate {

  constructor(private auth: JobbankService, private router: Router, private http: HttpClient) {
  }

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    console.log(this.auth.fackLoginFlag);

    // ======== offline version:
    // if (this.auth.fackLoginFlag) {
    //   return this.auth.fackLoginFlag;
    // } else {
    //   this.router.navigate(['/JobUserLoginComponent'], { queryParams: { returnUrl: state.url } });
    //   return this.auth.fackLoginFlag;
    // }



    // ======== server version:
    return this.auth.checkLogin()
      .pipe(map(loginStatus => {
          // console.log(loginStatus);

          if (!loginStatus.login) {
            this.router.navigate(['/JobUserLoginComponent'], {queryParams: {returnUrl: state.url}});
          }
          return loginStatus.login;
        }, catchError(error => {
          this.router.navigate(['/JobUserLoginComponent'], {queryParams: {returnUrl: state.url}});
          return of(false);
        }))
      );
  }
}
