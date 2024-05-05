import { Injectable } from '@angular/core';
import { User } from '../models/user.model';
import { Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';

let user1 = new User();
let user2 = new User();
user1.setValues(1, 'Smith', '123', 'ADMIN');
user2.setValues(2, 'Danies', '123', 'USER');

const USERS = [ user1, user2 ];
const usersObservable = of(USERS);

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private redirectUrl = '/';
  private loginUrl = '/login';
  private isloggedIn = false;
  private loggedInUser: User;

  constructor() { }

  getAllUsers(): Observable<User[]> {
    return usersObservable;
  }

  isUserAuthenticated(username: string, password: string): Observable<boolean> {
    return this.getAllUsers().pipe(map(users => {
      const user = users.find(u => (u.username === username) && (u.password === password));

      if (user) {
        this.isloggedIn = true;
        this.loggedInUser = user;
      } else {
        this.isloggedIn = false;
      }

      return this.isloggedIn;
    }));
  }

  isUserLoggedIn(): boolean {
    return this.isloggedIn;
  }

  logoutUser(): void {
    sessionStorage.removeItem('SessionUserName');
    sessionStorage.removeItem('SessionPassword');
    this.isloggedIn = false;
  }

  getRedirectUrl(): string {
    return this.redirectUrl;
  }

  setRedirectUrl(url: string): void {
    this.redirectUrl = url;
  }

  getLoginUrl(): string {
    return this.loginUrl;
  }

  getLoggedInUser(): User {
    return this.loggedInUser;
  }
}
