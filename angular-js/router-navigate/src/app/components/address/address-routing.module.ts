import { NgModule } from '@angular/core';
import { AddressComponent } from './address.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuardService } from 'src/app/services/auth-guard.service';

const addressRoutes: Routes = [
  {
    path: '',
    component: AddressComponent,
    canActivate: [ AuthGuardService ],
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(addressRoutes)
  ],
  exports: [ RouterModule ]
})
export class AddressRoutingModule { }
