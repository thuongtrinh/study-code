import { Component, OnInit } from '@angular/core';
import { Person } from 'src/app/models/person.model';
import { Company } from 'src/app/models/company.model';

@Component({
  selector: 'app-pipes',
  templateUrl: './pipes.component.html',
  styleUrls: ['./pipes.component.scss']
})
export class PipesComponent implements OnInit {

  // Pipe Operator
  message = 'Hello World!';
  person = new Person('ThuongTX', 20, 'HCM', 'VN', '0977875489', false);
  company = new Company('PQR', this.person);

  // Safe Navigation Operator
  personone: Person;
  persontwo = new Person('TungTX', 28, 'DN', 'VN', '0977875779', true);

  companyone: Company;
  companytwo = new Company('ABC', this.personone);
  companythree = new Company('XYZ', this.persontwo);

  // Pipe Date
  objDate = Date.now();
  numDate = 1478496544151;
  strDate = 'Mon Nov 07 2016 09:44:12 GMT+0530';

  // Uppercase
  inputData: string;
  address = {
    village: 'NB',
    district: 'Seven'
  };

  companyArray = [this.companytwo, this.companythree];

  // Decimal Pipe
  num1 = 12.638467846;
  num2 = 0.5;

  // Percent Pipe
  num3 = 2.5;
  num4 = 0.5;

  // Currency Pipe
  cur1 = 0.25;
  cur2 = 10.263782;

  // Slice pipe
  spliceMsg = '1234567890';
  spliceArray: number[] = [11, 22, 33, 44, 55, 66, 77, 88];

  constructor() { }

  ngOnInit() {
    this.personone = null;
    this.person.setDob(new Date(2002, 8, 9));

    this.persontwo.setDob(new Date(2021, 10, 19));
    this.companyone = null;
  }

  setData(data: string) {
    this.inputData = data;
  }
}
