import { Component, OnInit, ViewChild} from '@angular/core';
import { MatRadioChange, MatRadioButton } from '@angular/material/radio';
import { FormBuilder, Validators } from '@angular/forms';
import { Language, PersonR } from '../models/personR';

@Component({
  selector: 'app-reactive-form-radio',
  templateUrl: './reactive-form-radio.component.html',
})
export class ReactiveFormRadioComponent implements OnInit {

  constructor(private formBuilder: FormBuilder) { }

  LANGUAGES: Language[] = [
    {id: 'H', name: 'Hindi'},
    {id: 'E', name: 'English'},
    {id: 'M', name: 'Marathi'},
    {id: 'T', name: 'Tamil'}
  ];

  languages: Language[];

  @ViewChild('email', {static: true})
  emailRB: MatRadioButton;

  // Create a form
  personForm = this.formBuilder.group({
    name: ['', Validators.required],
    notificationType: ['', Validators.required],
    language: ''
  });

  ngOnInit(): void {
    this.languages = this.LANGUAGES;
  }

  onChange(mrChane: MatRadioChange) {
    console.log(mrChane.value);

    const mrButton: MatRadioButton = mrChane.source;
    console.log(mrButton.name);
    console.log(mrButton.checked);
    console.log(mrButton.inputId);
  }

  focusOnEmailRB() {
    this.emailRB.focus();
  }

  get name() {
    return this.personForm.get('name');
  }

  get notificationType() {
    return this.personForm.get('notificationType');
  }

  onFormSubmit() {
    return this.savePerson(this.personForm.value);
  }

  savePerson(person: PersonR) {
     console.log(person);
  }

}
