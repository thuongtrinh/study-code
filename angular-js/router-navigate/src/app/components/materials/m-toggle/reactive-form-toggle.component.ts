import { Component, ViewChild } from '@angular/core';
import { PersonS } from '../models/personS';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { MatSlideToggleChange, MatSlideToggle } from '@angular/material/slide-toggle';

@Component({
  selector: 'app-reactive-form-toggle',
  templateUrl: './reactive-form-toggle.component.html',
})
export class ReactiveFormToggleComponent {

  constructor(private formBuilder: FormBuilder) { }

  @ViewChild('slide', {static: true})
  matSlideToggle: MatSlideToggle;

  autoRenew = new FormControl();
  enable = new FormControl();
  activate = new FormControl();

  // create a form
  personForm = this.formBuilder.group({
    username: ['', Validators.required],
    activateAcc: ['', Validators.required],
    premiumUser: false,
    autoRenewSub: true
  });

  onDragChange() {
    console.log('onDragChange: ' + this.enable.value);
  }

  onToggleChange() {
    console.log('onToggleChange: ' + this.activate.value);
  }

  onChange(ob: MatSlideToggleChange) {
    console.log('checked: ' + ob.checked);
    const matSlideToggle: MatSlideToggle = ob.source;
    console.log('color: ' + matSlideToggle.color);
    console.log('required: ' + matSlideToggle.required);
    console.log('value: ' + this.autoRenew.value);
  }

  focusTest() {
    this.matSlideToggle.focus();
  }

  toggleTest() {
    this.matSlideToggle.toggle();
  }

  onFormSubmit() {
    this.savePerson(this.personForm.value);
  }

  savePerson(person: PersonS) {
    console.log(person);
  }

  get username() {
    return this.personForm.get('username');
  }

  get activateAcc() {
    return this.personForm.get('activateAcc');
  }
}
