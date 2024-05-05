import { Resolve, Router, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { Person } from 'src/app/models/person.model';
import { Injectable } from '@angular/core';
import { PersonService } from 'src/app/services/person.service';

@Injectable()
export class PersonDetailResolver implements Resolve<Person> {

  constructor(private personService: PersonService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Promise<Person> {
    const id = route.paramMap.get('person-id');
    console.log('Resolving for person id: ' + id);

    return this.personService.getPerson(id).then(person => {
      if (person) {
        return person;
      } else {
        this.router.navigate(['/person/list']);
        return null;
      }
    });
  }
}
