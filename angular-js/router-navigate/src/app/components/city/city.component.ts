import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Emp } from './emp';
import { DirectionEnum } from './directionEnum';

@Component({
  selector: 'app-city',
  templateUrl: './city.component.html',
  styleUrls: ['./city.component.scss']
})
export class CityComponent implements OnInit {

  constructor() { }

  msg: string;
  flag = true;
  website = {
    name : 'MyGithub',
    url : 'https://github.com/thuongtrinh',
    logo : './assets/images/logo.png',
    description: 'Learn angular property binding.'
  };

  msg1 = 'Hello World';
  msg2 = '';
  msg3 = '';

  countryDefault = 'VietNam';
  countryNew = this.countryDefault;

  // ----------------style binding----------------------
  result = 50;
  colorFlag = false;
  isSmall = true;
  isBackgroundRed = false;
  small = 10;
  big = 15;

  // ----------------attribute binding----------------------
  h = 300;
  w = 200;
  bdr = 5;
  clspn = 2;

  // ------------Two way binding---------
  // Property for AliasComponent
  city = 'Smith';

  // Property for TextSizeComponent
  textSize = 20;

  // Property for SelectBoxComponent
  colors = ['RED', 'GREEN', 'BLUE'];

  // Property for CaseComponent
  myNameInit = 'ThuongTX';


  // ----------CHARTER 2: DIRECTIVES----------------
  emps = [
    new Emp('Marry', 12),
    new Emp('Jack', 34),
    new Emp('Tom', 57),
  ];

  // ----------ngswitchCase----------------
  person = 'Sohan';
  ids = [1, 2, 3, 4];
  dirEnum = DirectionEnum;
  myDir = DirectionEnum.North;


  ngOnInit() {
  }

  onFormSubmit(userForm: NgForm) {
    console.log(userForm.value);
    console.log('Name:' + userForm.controls.name.value);
    console.log('City:' + userForm.controls.city.value);
    console.log('Form Valid:' + userForm.valid);
    console.log('Form Submitted:' + userForm.submitted);
  }

  resetUserForm(userForm: NgForm) {
    userForm.resetForm();
  }

  setMsg(data: string) {
    this.msg1 = data;
  }

  changeText(mytext: string) {
    this.msg3 = mytext;
  }

  saveData(name) {
    this.countryNew = name;
  }

  isRed(num: number) {
    if (num > 5) { return true; } else { return false; }
  }

  allRequiredStyles(styleSet) {
    let myStyles;
    if (styleSet === 'one') {
      myStyles = {
        color :  this.colorFlag ? 'black' : 'pink',
        'font-size.em': this.isSmall ? this.small / 5 : this.big / 5,
        'background-image': !this.isBackgroundRed ? 'url(\'images/red.gif\')' : 'url(\'images/green.gif\')'
      };
    } else if (styleSet === 'two') {
      myStyles = {
        color:  !this.colorFlag ? 'black' : 'pink',
        'font-size.em': !this.isSmall ? this.small / 5 : this.big / 5,
        'background-image': this.isBackgroundRed ? 'url(\'images/red.gif\')' : 'url(\'images/green.gif\')'
      };
    } else {
      myStyles = {
        'background-color':  this.colorFlag ? 'cyan' : 'grey',
        'font-size.%': !this.isSmall ? this.small * 10 : this.big * 10
      };
    }

    return myStyles;
  }

}
