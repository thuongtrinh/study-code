import { Component, OnInit } from '@angular/core';
import { FormGroup, FormArray, FormControl } from '@angular/forms';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: []
})
export class CityListComponent implements OnInit {

  cityForm = new FormGroup({
    cities: new FormArray([
      new FormControl('Hanoi'),
      new FormControl('HCM'),
      new FormControl()
    ])
  });

  constructor() { }

  ngOnInit() {
  }

  get cities(): FormArray {
    return this.cityForm.get('cities') as FormArray;
  }

  onSubmitForm() {
    console.log(this.cities.value);   // Gives FormArray data
    console.log(this.cityForm.value); // Gives Complete form data

    // Iterate FormArray
    for (let i = 0; i < this.cities.length; i++) {
      console.log(this.cities.at(i).value);
    }
  }

  deleteCityField(indexRemove: number) {
    this.cities.removeAt(indexRemove);
  }

  addCityField() {
    this.cities.push(new FormControl());
  }
}
