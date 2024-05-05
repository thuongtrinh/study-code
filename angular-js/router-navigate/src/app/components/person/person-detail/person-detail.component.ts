import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person.model';
import { PersonService } from 'src/app/services/person.service';
import { ActivatedRoute } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-person-detail',
  templateUrl: './person-detail.component.html',
  styleUrls: ['./person-detail.component.scss']
})
export class PersonDetailComponent implements OnInit {

  person: Person;

  constructor(private activatedRoute: ActivatedRoute, private personService: PersonService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.pipe(
      map(params => params.get('person-id')),
      switchMap(id => this.personService.getPerson(id))
    ).subscribe(person => this.person = person);
  }

}
