import { Component, OnInit } from '@angular/core';
import { Country } from 'src/app/models/country.model';
import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CountryService } from 'src/app/services/country.service';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { DialogService } from 'src/app/services/dialog.service';

@Component({
  selector: 'app-country-edit',
  templateUrl: './country-edit.component.html',
  styleUrls: []
})
export class CountryEditComponent implements OnInit {

  country: Country;
  countryForm: FormGroup;
  isUpdating = false;

  constructor(
    private countryService: CountryService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder,
    private dialogService: DialogService) { }

  ngOnInit() {
    this.activatedRoute.paramMap.pipe(
      map(params => params.get('country-id')),
      switchMap(id => this.countryService.getCountry(id))
    ).subscribe(country => {
      this.country = country;
      this.createForm(country);
    });
  }

  createForm(country: Country) {
    this.countryForm = this.formBuilder.group({
      countryId: country.countryId,
      name: [country.name, Validators.required],
      capital: country.capital,
      currency: country.currency
    });
  }

  onFormSubmit() {
    this.isUpdating = true;
    this.country.name = this.countryForm.get('name').value;
    this.country.capital = this.countryForm.get('capital').value;
    this.country.currency = this.countryForm.get('currency').value;
    this.countryService.updateCountry(this.country)
    .subscribe(() => this.router.navigate(['/country/list'], { relativeTo: this.activatedRoute}));
  }

  // canDeactivate(): Observable<boolean> | boolean {
  //   if (this.isUpdating && this.countryForm.dirty) {
  //     this.isUpdating = false;
  //     return this.dialogService.confirm('Discard changes for Person?');
  //   }
  //   return true;
  // }
}
