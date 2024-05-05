import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { CountryComponent } from './country.component';
import { CountryListComponent } from './country-list/country-list.component';
import { CountryDetailComponent } from './country-detail/country-detail.component';
import { CountryAddComponent } from './country-add/country-add.component';
import { CountryDetailResolver } from './country-detail/country-detail.resolver';
import { CountryEditComponent } from './country-edit/country-edit.component';
import { CountryEditCanDeactiveGuardService } from 'src/app/services/country-edit-can-deactive-guard.service';

const countryRoutes: Routes = [
  {
    path: '',
    component: CountryComponent,
    children: [
      {
        path: 'add',
        component: CountryAddComponent
      },
      {
        path: 'list',
        component: CountryListComponent
      },
      {
        path: 'detail/:country-id',
        component: CountryDetailComponent,
        resolve: {
          countryDetail: CountryDetailResolver
        }
      },
      {
        path: 'edit/:country-id',
        component: CountryEditComponent,
        canDeactivate: [ CountryEditCanDeactiveGuardService ]
      }
    ]
  }
];

@NgModule({
  declarations: [],
  imports: [ RouterModule.forChild(countryRoutes) ],
  exports: [ RouterModule ],
  providers: [ CountryDetailResolver ]
})
export class CountryRoutingModule { }
