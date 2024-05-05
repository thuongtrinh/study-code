import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-country-add',
  templateUrl: './country-add.component.html',
  styleUrls: ['./country-add.component.scss']
})
export class CountryAddComponent implements OnInit {
  constructor(private countryService: CountryService) {}

  countryForm = new FormGroup({
    name: new FormControl(null, Validators.required),
    capital: new FormControl(),
    currency: new FormControl()
  });

  ngOnInit() {}

  onFormSubmit() {
    const country = this.countryForm.value;
    this.countryService.addCountry(country).subscribe(
      data => {
        console.log(data);
      },
      err => {
        throw err;
      }
    );
  }
}
