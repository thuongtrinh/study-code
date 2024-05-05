import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

import { Person } from '../models/person.model';
import { map, find } from 'rxjs/operators';

const p1 = new Person('Smith1', 20, 'Varanasi', 'VN', '0978776555', false);
const p2 = new Person('Smith2', 22, 'Ayodhya', 'VN', '0967855447', false);
const p3 = new Person('Smith3', 23, 'Mathura', 'VN', '0122345643', true);
p1.setPersonId(1);
p1.gender = 'male';
p2.setPersonId(2);
p3.setPersonId(3);
let PERSONS = [ p1, p2, p3 ];

let personList$ = of(PERSONS);
let personListPromise = Promise.resolve(PERSONS);

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  url = '/api/person';

  constructor(private http: HttpClient) {}

  getPersonArr() {
    return PERSONS;
  }

  addPerson(person: Person): Observable<Person>{
    // return this.http.post<Person>(this.url, person);
    return this.getPersons().pipe(map(persons => {
      const idMax = persons.length + 1;
      person.setPersonId(idMax);
      persons.push(person);
      return person;
    }));
  }

  getPersons(): Observable<Person[]> {
    return personList$;
  }

  getPerson(id: string): Promise<Person>{
    const idCover = parseInt(id);
    return personListPromise.then(persons => persons.find(person => person.personId === idCover));
  }

  updatePerson(person: Person): Observable<Person> {
    console.log('Person updating...');
    return this.getPersons().pipe(map(persons => {
      let personObj = persons.find(obj => obj.personId === person.personId);
      personObj = person;
      return personObj;
    }));
  }

  remove(personId: number) {
    let obj = this.getPersonArr().find(ob => ob.personId === personId);
    this.getPersonArr().splice(this.getPersonArr().indexOf(obj), 1);
  }
}
