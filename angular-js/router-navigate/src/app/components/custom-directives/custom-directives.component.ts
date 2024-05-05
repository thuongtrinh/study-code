import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person.model';
import { Observable } from 'rxjs';
import { PersonService } from 'src/app/services/person.service';

@Component({
  selector: 'app-custom-directives',
  templateUrl: './custom-directives.component.html',
})
export class CustomDirectivesComponent implements OnInit {

  txtsize = '25px';
  colors = ['CYAN', 'GREEN', 'YELLOW'];
  myColor = '';

  showCpIf = false;
  showCpDelay = false;
  delayInSec = 0;

  allPersons: Person[];
  obsPersons$: Observable<Person[]>;

  constructor(private personService: PersonService) { }

  ngOnInit() {
    this.personService.getPersons().pipe().subscribe(persons => this.allPersons = persons);
    this.obsPersons$ = this.personService.getPersons();
  }

  add() {
    this.personService.addPerson(new Person('Minh', 18, 'HCM', 'VN', '0987873271', false));
  }

  remove(personId: number) {
    this.personService.remove(personId);
  }

  personTrackByFn(index: number, person: Person) {
    return person.personId;
  }
}
