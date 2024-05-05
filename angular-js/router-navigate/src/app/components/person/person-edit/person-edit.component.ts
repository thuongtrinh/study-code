import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Person } from 'src/app/models/person.model';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { PersonService } from 'src/app/services/person.service';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { DialogService } from 'src/app/services/dialog.service';

@Component({
  selector: 'app-person-edit',
  templateUrl: './person-edit.component.html',
  styleUrls: ['./person-edit.component.scss']
})
export class PersonEditComponent implements OnInit {

  usrNameChanges: string;
  usrNameStatus: string;

  person: Person;
  personForm: FormGroup;
  isUpdating = false;
  positions = [
    { name: 'Developer', shortName: 'dev' },
    { name: 'Manager', shortName: 'man' },
    { name: 'Director', shortName: 'dir' }
  ];

  constructor(
    private personService: PersonService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private dialogService: DialogService
  ) {}

  ngOnInit() {
    this.activatedRoute.paramMap
      .pipe(
        map(params => params.get('person-id')),
        switchMap(id => this.personService.getPerson(id))
      )
      .subscribe(person => {
        this.person = person;
        this.createForm(person);
      });
  }

  createForm(person: Person) {
    this.personForm = this.formBuilder.group({
      personId: person.personId,
      name: this.formBuilder.control([person.name], Validators.required),
      // [person.name, Validators.required],
      age: person.age,
      address: this.formBuilder.group({
        houseNumber: person.houseNumber,
        city: person.city,
        country: [{value: person.country, disabled: true}, Validators.required]
      }),
      mobile: person.mobile,
      gender: person.gender,
      position: person.position,
      married: person.married
    });

    this.handleFormChanges();
  }

  get name() {
    return this.personForm.get('name');
  }

  handleFormChanges() {
    this.name.valueChanges.subscribe(data => this.usrNameChanges = data);
    this.name.statusChanges.subscribe(data => (this.usrNameStatus = data));
  }

  onFormSubmit() {
    this.isUpdating = true;
    this.person.name = this.personForm.get('name').value;
    this.person.age = this.personForm.get('age').value;
    this.person.mobile = this.personForm.get('mobile').value;
    this.person.gender = this.personForm.get('gender').value;
    this.person.position = this.personForm.get('position').value;
    this.person.married = this.personForm.get('married').value;

    const addressFG = this.personForm.get('address');
    this.person.city = addressFG.get('city').value;
    this.person.country = addressFG.get('country').value;
    this.person.houseNumber = addressFG.get('houseNumber').value;

    this.personService
      .updatePerson(this.person)
      .subscribe(() =>
        this.router.navigate(['/person/list'], {
          relativeTo: this.activatedRoute
        })
      );
  }

  canDeactivate(): Observable<boolean> | boolean {
    if (this.isUpdating && this.personForm.dirty) {
      this.isUpdating = false;
      return this.dialogService.confirm('Discard changes for Person?');
    }
    return true;
  }
}
