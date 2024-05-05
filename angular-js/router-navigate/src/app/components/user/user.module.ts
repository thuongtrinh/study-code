import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from 'src/app/services/user.service';
import { UserReactiveFormComponent } from './user-reactive-form/user-reactive-form.component';
import { UserComponent } from './user.component';
import { UserData } from '../data/user-data';
import { UserRoutingModule } from './user-routing.module';
import { RouterModule } from '@angular/router';
import { CustomMinDirective } from 'src/app/custom-validators/custom-min-directive';
import { CustomMaxDirective } from 'src/app/custom-validators/custom-max-directive';
import { ExistingUsernameValidatorDirective } from 'src/app/custom-validators/existing-username-validator';
import { ExistingEmailValidatorDirective } from 'src/app/custom-validators/existing-email-validator';
import { ExistingMobileValidatorDirective } from 'src/app/custom-validators/existing-mobile-validator';
import { BlackListedMobileNumberValidatorDirective } from 'src/app/custom-validators/blacklisted-mobilenumber-validator';
import { PwdCannotSameUserValidatorDirective } from 'src/app/custom-validators/pwd-cannot-same-user-validator';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    UserRoutingModule,
    RouterModule,
    InMemoryWebApiModule.forRoot(UserData) // Remember import -> HttpClientModule
  ],
  declarations: [
    UserComponent,
    UserReactiveFormComponent,

    CustomMinDirective,
    CustomMaxDirective,
    ExistingUsernameValidatorDirective,
    ExistingEmailValidatorDirective,
    ExistingMobileValidatorDirective,
    BlackListedMobileNumberValidatorDirective,
    PwdCannotSameUserValidatorDirective,
  ],
  providers: [ UserService ]
})
export class UserModule { }
