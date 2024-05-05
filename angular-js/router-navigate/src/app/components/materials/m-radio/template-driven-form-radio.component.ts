import { Component, OnInit } from '@angular/core';
import { Language, PersonR } from '../models/personR';

@Component({
  selector: 'app-template-driven-form-radio',
  templateUrl: './template-driven-form-radio.component.html',
})
export class TemplateDrivenFormRadioComponent implements OnInit {

  constructor() {
  }

  LANGUAGES: Language[] = [
    {id: 'H', name: 'Hindi'},
    {id: 'E', name: 'English'},
    {id: 'M', name: 'Marathi'},
    {id: 'T', name: 'Tamil'}
  ];

  languages: Language[];

  ngOnInit(): void {
    this.languages = this.LANGUAGES;
  }

  onFormSubmit(form) {
    return this.savePerson(form);
  }

  savePerson(person: PersonR) {
     console.log(person);
  }
}
