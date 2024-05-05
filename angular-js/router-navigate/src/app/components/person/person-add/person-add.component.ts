import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { PersonService } from 'src/app/services/person.service';
import { Person } from 'src/app/models/person.model';

@Component({
  selector: 'app-person-add',
  templateUrl: './person-add.component.html',
  styleUrls: ['./person-add.component.scss']
})
export class PersonAddComponent implements OnInit {
  name = new FormControl('', [Validators.required, Validators.maxLength(15)]);
  age = new FormControl(20, Validators.required);
  city = new FormControl('');
  country = new FormControl({ value: 'VietNam', disabled: true });
  mobile = new FormControl('');
  married = new FormControl(false);

  constructor(private personService: PersonService) {}

  ngOnInit() {}

  register() {
    const person = new Person(
      this.name.value,
      this.age.value,
      this.city.value,
      this.country.value,
      this.mobile.value,
      this.married.value
    );

    this.personService.addPerson(person).subscribe(data => console.log(data));
  }

  resetAll() {
    this.name.reset();
    this.age.setValue(20);
    this.city.reset();
    this.country.setValue('VietNam');
    this.mobile.reset();
    this.married.reset(false);
  }
}
