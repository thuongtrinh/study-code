import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import {
  Router,
  CanLoad,
  Route,
  CanActivate,
  ActivatedRouteSnapshot,
  RouterStateSnapshot,
  CanActivateChild
} from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService
  implements CanLoad, CanActivate, CanActivateChild {
  constructor(private authService: AuthService, private router: Router) {}

  canLoad(route: Route): boolean | Observable<boolean> | Promise<boolean> {
    const url: string = route.path;
    console.log('Url canLoad:' + url);

    if (this.authService.isUserLoggedIn()) {
      return true;
    }

    this.authService.setRedirectUrl(url);

    console.log('LoginUrl: ' + this.authService.getLoginUrl());
    this.router.navigate([this.authService.getLoginUrl()]);
    return true;
  }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): boolean {
    const url = state.url;
    console.log('Url canActivate: ' + url);

    if (this.authService.isUserLoggedIn()) {
      return true;
    }

    this.authService.setRedirectUrl(url);
    this.router.navigate([this.authService.getLoginUrl()]);
    return false;
  }

  canActivateChild(childRoute: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const loggedInUser = this.authService.getLoggedInUser();

    console.log('canActivateChild');
    if (loggedInUser.role === 'ADMIN') {
      return true;
    } else {
      console.log('Unauthorized to open link: ' + state.url);
      return false;
    }
  }
}
