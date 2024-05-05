import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Technology } from 'src/app/models/technology.model';
import { UserService } from 'src/app/services/user.service';
import { Profile } from 'src/app/models/profile.model';
import { User } from 'src/app/models/user.model';
import { existingUsernameValidator } from 'src/app/custom-validators/existing-username-validator';
import { pwdCannotSameUserValidator } from 'src/app/custom-validators/pwd-cannot-same-user-validator';

@Component({
  selector: 'app-user-reactive-form',
  templateUrl: './user-reactive-form.component.html',
  styleUrls: []
})
export class UserReactiveFormComponent implements OnInit {

  minNum = 5;
  maxNum = 80;
  userForm: FormGroup;
  allTechnologies: Technology[];
  allProfiles: Profile[];
  isValidFormSubmitted = false;
  unamePattern = '^[a-zA-Z0-9_-]{4,15}$';

  constructor(private formBuiilder: FormBuilder, private userService: UserService) { }

  ngOnInit() {
    this.userForm = this.formBuiilder.group({
      username: [null,
          [Validators.required, Validators.pattern(this.unamePattern)], // sync validators
          [existingUsernameValidator(this.userService)] // async validators
      ],
      password: [null, [Validators.required]],
      profile: [null, [Validators.required]],
      technologies: [null, [Validators.required]],
      gender: [null, [Validators.required]],
      isMarried: null,
      num1: [null, [Validators.required, Validators.min(this.minNum), Validators.max(this.maxNum)]]
    });

    this.allProfiles = this.userService.getProfiles();
    // this.profile.setValue(this.allProfiles[2]);
    // this.profile.setValue(this.userService.getProfile2);

    this.allTechnologies = this.userService.getTechnologies();

    // handle form value changes
    this.handleFormChanges();
  }

  handleFormChanges() {
    this.username.valueChanges.subscribe(
      uname => {
        this.password.setValidators([Validators.required, pwdCannotSameUserValidator(uname)]);
        this.password.updateValueAndValidity();
      }
    );

    this.password.valueChanges.subscribe(pwd => {
        const uname = this.username.value;
        this.password.setValidators([Validators.required, pwdCannotSameUserValidator(uname)]);
      }
    );
  }

  get profile() {
    return this.userForm.get('profile');
  }

  get username() {
    return this.userForm.get('username');
  }

  get password() {
    return this.userForm.get('password');
  }

  get gender() {
    return this.userForm.get('gender');
  }

  get isMarried() {
    return this.userForm.get('isMarried');
  }

  get technologies() {
    return this.userForm.get('technologies');
  }

  get num1() {
    return this.userForm.get('num1');
  }

  onSubmitForm() {
    this.isValidFormSubmitted = false;
    if (this.userForm.valid) {
      this.isValidFormSubmitted = true;
    } else {
      return;
    }

    const userNew = this.userForm.value;
    console.log(userNew);
    this.userForm.reset();
  }

  onProfileChange() {
    const profile: Profile = this.profile.value;
    console.log('Profile Changed: ' + profile.profileName);
  }

  compareTech(t1: Technology, t2: Technology): boolean {
    return t1 && t2 ? t1.techId === t2.techId : t1 === t2;
  }

  setDefaultValues() {
    this.userForm.patchValue({
      // username: 'ThuongTX',  // => Check after
      profile: this.allProfiles[0],
      technologies: [ this.allTechnologies[0], this.allTechnologies[2] ],
      gender: 'male',
      isMarried: null
    });

    // let user = new User();
    // user.username = 'XW';
    // user.profile = this.allProfiles[2];
    // user.technologies = [
    //   this.allTechnologies[1],
    //   this.allTechnologies[2],
    // ];
    // user.gender = 'male';
    // user.isMarried = null;
    // this.userForm.setValue(user);
  }

  resetForm() {
    this.userForm.reset();
  }
}
