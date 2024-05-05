import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ChangePasswordComponent } from './change-password/change-password.component';

const authRoutes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'change-password',
    component: ChangePasswordComponent
  }
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forChild(authRoutes)
  ],
  exports: [ RouterModule ]
})
export class AuthRoutingModule { }
