import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';
import { AuthService } from 'src/app/services/auth.service';

import { passMatchUserValidator } from 'src/app/custom-validators/pass-match-user-vaildator';
import { ruleNewPassword, confirmMatchingPassword } from 'src/app/custom-validators/confirm-password-validator';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {

  changePassForm: FormGroup;

  constructor(public formBuilder: FormBuilder, public userService: UserService, authService: AuthService) { }

  ngOnInit() {
    this.createForm();
    this.handleFormChanges();
  }

  createForm() {
    this.changePassForm = this.formBuilder.group({
      notificationMode: ['', [Validators.required]],
      email: '',
      mobile: '',
      oldPassword: ['', [Validators.required]],
      newPassword: ['', [Validators.required]],
      confirmNewPassword: ['', [Validators.required]]
    });
  }

  submitChangePassword() {
    if (this.changePassForm.invalid) {
      return;
    }

    console.log(this.changePassForm.value);
    this.changePassForm.reset();
  }

  handleFormChanges() {
    this.changePassForm.statusChanges.subscribe(status => {
      console.log('Form validation status: ' + status);
    });

    this.notificationMode.valueChanges.subscribe(mode => {
      if (mode === 'email') {
        this.email.setValidators([Validators.required, Validators.email]);
        this.mobile.clearValidators();
      } else if (mode === 'mobile') {
        this.mobile.setValidators([Validators.required]);
        this.email.clearValidators();
      } else if (mode === 'both') {
        this.email.setValidators([Validators.required, Validators.email]);
        this.mobile.setValidators([Validators.required]);
      }

      this.email.updateValueAndValidity();
      this.mobile.updateValueAndValidity();
    });

    this.oldPassword.valueChanges.subscribe(pwd => {
      const username = sessionStorage.getItem('SessionUsername');
      const password = sessionStorage.getItem('SessionPassword');

      this.oldPassword.setValidators([
        Validators.required, passMatchUserValidator(password)
      ]);
    });

    this.newPassword.valueChanges.subscribe(pwd => {
      this.newPassword.setValidators([
        Validators.required, ruleNewPassword()
      ]);
    });

    this.confirmNewPassword.valueChanges.subscribe(pwd => {
      const passwordNew = this.newPassword.value;
      this.confirmNewPassword.setValidators([
        Validators.required, confirmMatchingPassword(passwordNew)
      ]);
    });
  }

  get notificationMode() {
    return this.changePassForm.get('notificationMode');
  }

  get email() {
    return this.changePassForm.get('email');
  }

  get mobile() {
    return this.changePassForm.get('mobile');
  }

  get oldPassword() {
    return this.changePassForm.get('oldPassword');
  }

  get newPassword() {
    return this.changePassForm.get('newPassword');
  }

  get confirmNewPassword() {
    return this.changePassForm.get('confirmNewPassword');
  }
}
