import { Component, OnInit } from '@angular/core';
import { Profile } from 'src/app/models/profile.model';
import { Technology } from 'src/app/models/technology.model';
import { User } from 'src/app/models/user.model';
import { UserService } from 'src/app/services/user.service';
import { NgForm } from '@angular/forms';
import { Meta } from '@angular/platform-browser';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  isValidFormSubmitted = false;
  minNum = 15;
  maxNum = 50;
  allProfiles: Profile[];
  allTechnologies: Technology[];
  user = new User();
  dataSaved = false;

  allUsers$: Observable<User[]>;

  unamePattern = '^[a-zA-Z0-9_-]{3,15}$';
  // pwdPattern = '^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\s).{6,12}$';
  // mobnumPattern = '^((\\+91-?)|0)?[0-9]{10}$';
  // emailPattern = '^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$';

  constructor(private userService: UserService, meta: Meta) {
    // meta.addTag({ name: 'author', content: 'Ninja Squad' });
    // console.log(meta);
  }

  ngOnInit() {
    this.allProfiles = this.userService.getProfiles();
    this.allTechnologies = this.userService.getTechnologies();
    this.loadAllUsers();
  }

  loadAllUsers() {
    this.allUsers$ = this.userService.getUsers();
  }

  onSubmitForm(userForm: NgForm) {
    this.isValidFormSubmitted = false;
    if (userForm.valid) {
      this.isValidFormSubmitted = true;
    } else {
      return;
    }

    const username = userForm.controls.username.value;
    const userProfile: Profile = userForm.controls.profile.value;
    const userTechnologies: Technology[] = userForm.controls.selectedTechs.value;
    const gender = userForm.controls.gender.value;
    const isMarried = userForm.controls.isMarried.value;

    let newUser = new User();
    newUser.username = username;
    newUser.profile = userProfile;
    newUser.technologies = userTechnologies;
    newUser.gender = gender;
    newUser.isMarried = isMarried;

    this.userService.createUser(newUser);
    this.userService.viewLogUser();
    this.resetForm(userForm);
  }

  setDefaultValues() {
    // this.user.username = 'ThuongTX';  // <= Check after
    this.user.setProfile(this.allProfiles[0]);
    this.user.setTechnologies([this.allTechnologies[0], this.allTechnologies[2]]);
    this.user.isMarried = true;
    this.user.gender = 'male';
    this.user.num1 = 27;
    this.user.num2 = 45;
    this.user.num3 = 0;
  }

  resetForm(userForm: NgForm) {
    userForm.resetForm();
    this.user.profile = null;
    this.user.username = '';
  }

  compareProfile(p1: Profile, p2: Profile): boolean {
    return p1 && p2 ? p1.profileId === p2.profileId : p1 === p2;
  }

  compareTech(t1: Technology, t2: Technology): boolean {
    return t1 && t2 ? t1.techId === t2.techId : t1 === t2;
  }

  onProfileChange() {
    console.log('Profile Changed to: ' + this.user.profile.profileName);
 }
}
