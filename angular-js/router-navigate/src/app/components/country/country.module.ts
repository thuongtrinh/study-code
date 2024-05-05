import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CountryComponent } from './country.component';
import { CountryAddComponent } from './country-add/country-add.component';
import { CountryListComponent } from './country-list/country-list.component';
import { CountryDetailComponent } from './country-detail/country-detail.component';
import { CountryRoutingModule } from './country-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { CountryService } from 'src/app/services/country.service';
import { CountryEditComponent } from './country-edit/country-edit.component';

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    CountryRoutingModule
  ],
  declarations: [
    CountryComponent,
    CountryAddComponent,
    CountryListComponent,
    CountryDetailComponent,
    CountryEditComponent
  ],
  providers: [ CountryService ]
})
export class CountryModule { }
