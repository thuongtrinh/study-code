import { Component, OnInit } from '@angular/core';
import { UserM } from '../models/userM';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-template-driven-form',
  templateUrl: './template-driven-form.component.html',
})
export class TemplateDrivenFormComponent {

  isValidFormSubmitted = false;
  user = new UserM();
  content;

  constructor() {
  }

  onFormSubmit(form: NgForm) {
     this.isValidFormSubmitted = false;
     if (form.invalid) {
      return;
     }

     this.isValidFormSubmitted = true;
     this.user.userName = form.controls.uname.value;
     this.user.isMarried = form.controls.married.value;
     this.user.isTCAccepted = form.controls.tc.value;
     this.createUser(this.user);
     this.resetForm(form);
  }

  resetForm(form: NgForm) {
     form.resetForm({
       married: false
     });
  }

  setDefaultValues() {
     this.user.userName = 'TXT';
     this.user.isMarried = true;
     this.user.isTCAccepted = false;
     this.content = '';
  }

  createUser(user: UserM) {
    // Log user data in console
    console.log('User Name: ' + user.userName);
    console.log('Married?: ' + user.isMarried);
    console.log('T & C accepted?: ' + user.isTCAccepted);
    this.setContentUser();
  }

  setContentUser() {
    this.content = this.user;
  }
}
