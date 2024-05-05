import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthRoutingModule } from './auth-routing.module';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './login/login.component';
import { AuthService } from '../services/auth.service';
import { SharedModule } from '../shared/shared.module';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { UserService } from '../services/user.service';

@NgModule({
  declarations: [ LoginComponent, ChangePasswordComponent ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    AuthRoutingModule,
    SharedModule
  ],
  providers: [ AuthService, UserService ]
})
export class AuthModule {
}
