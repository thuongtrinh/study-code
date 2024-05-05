import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserM } from '../models/userM';

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
})
export class ReactiveFormComponent implements OnInit {

  isValidFormSubmitted: boolean = null;
  userForm = new FormGroup({
    uname: new FormControl('', Validators.required),
    married: new FormControl(false),
    tc: new FormControl('', Validators.required)
  });

  user = new UserM();
  content;

  constructor() { }

  ngOnInit() {
  }

  onFormSubmit() {
    this.isValidFormSubmitted = false;
    if (this.userForm.invalid) {
      return;
    }

    this.isValidFormSubmitted = true;
    console.log(this.userForm.valid);
    this.user.userName = this.userForm.get('uname').value;
    this.user.isMarried = this.userForm.get('married').value;
    this.user.isTCAccepted = this.userForm.get('tc').value;
    this.createUser(this.user);
    this.reset();
  }

  reset() {
    this.userForm.reset({
       married: false
    });
  }

  setDefaultValues() {
      this.userForm.patchValue({uname: 'ThuongTX', married: true});
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
    this.content = this.userForm.value;
  }
}
