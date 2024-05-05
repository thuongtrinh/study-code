import { Person } from './person.model';

export class Company {
  constructor(public compname: string, public owner: Person) {}
}
