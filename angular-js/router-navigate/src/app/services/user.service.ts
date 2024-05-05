import { Injectable } from '@angular/core';

import { Technology } from '../models/technology.model';
import { Profile } from '../models/profile.model';
import { User } from '../models/user.model';
import { of, Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

let USERS: User[] = [];
let userObservable = of(USERS);

@Injectable({
  providedIn: 'root'
})
export class UserService {

  url = '/api/users';
  urlBackListedMnums = '/api/backListedMNums';

  constructor(private http: HttpClient) { }

  getProfiles(): Profile[] {
    const p1 = new Profile();
    const p2 = new Profile();
    const p3 = new Profile();
    p1.setProperties('dev', 'Developer');
    p2.setProperties('man', 'Manager');
    p3.setProperties('dir', 'Director');
    const profiles = [p1, p2, p3];
    return profiles;
  }

  getProfile2(): Profile {
    const p = new Profile();
    p.setProperties('man', 'Manager');
    return p;
  }

  getTechnologies(): Technology[] {
    const technologies = [
      new Technology(100, 'Java'),
      new Technology(200, 'Hibernate'),
      new Technology(300, 'Angular'),
      new Technology(400, 'Spring')
    ];
    return technologies;
  }

  createUser(user: User) {
    return this.getUsers().subscribe(users => {
      const idMax = users.length + 1;
      user.userId = idMax;
      users.push(user);
      return user;
    });
  }

  getUsers(): Observable<User[]> {
    return userObservable;
  }

  viewLogUser() {
    userObservable.pipe().subscribe(users => {
      users.forEach(user => {
        console.log('User Name: ' + user.username);
        console.log('Profile Id: ' + user.profile.profileId);
        console.log('Profile Name: ' + user.profile.profileName);
        console.log('Gender: ' + user.gender);
        console.log('Is married: ' + user.isMarried);

        for (const tech of user.technologies) {
          console.log('Technology Id: ' + tech.techId);
          console.log('Technology Name: ' + tech.techName);
        }
      });
    });
  }

  getUserByUsername(username: string): Observable<User[]> {
    username = '^' + username.trim() + '$'; // For exact match testing in Angular In-Memory Web API
    return this.http.get<User[]>(this.url + '?username=' + username);
  }

  getUserByEmail(email: string): Promise<User[]> {
    email = email.trim().replace('@', '%40'); // Convert @ into Percent-encoding
    email = '^' + email + '$'; // For exact match testing in Angular In-Memory Web API
    return this.http.get<User[]>(this.url + '?email=' + email).toPromise();
  }

  getUserByMobileNumber(mobileNumber: string): Observable<User[]> {
    mobileNumber = '^' + mobileNumber.trim() + '$'; // For exact match testing in Angular In-Memory Web API
    return this.http.get<User[]>(this.url + '?mobileNumber=' + mobileNumber);
  }

  getBackListedMobNumMobileNumberDetail(mobileNumber: string): Observable<any> {
    mobileNumber = '^' + mobileNumber.trim() + '$'; // For exact match testing in Angular In-Memory Web API
    return this.http.get(this.urlBackListedMnums + '?mobileNumber=' + mobileNumber);
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.url);
  }

  getAllBackListedMobileNumbers(): Observable<any> {
    return this.http.get(this.urlBackListedMnums);
  }
}
