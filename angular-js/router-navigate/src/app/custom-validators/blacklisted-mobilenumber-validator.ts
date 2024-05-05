import { UserService } from '../services/user.service';
import { AsyncValidator, AbstractControl, ValidationErrors, NG_ASYNC_VALIDATORS, AsyncValidatorFn } from '@angular/forms';
import { Observable, timer } from 'rxjs';
import { map, switchMap } from 'rxjs/operators';
import { Directive } from '@angular/core';

export function blackListedMobileNumberValidator(userService: UserService): AsyncValidatorFn {
  return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
    const debouceTime = 500; // milliseconds
    const timerOb = timer(debouceTime);

    return timerOb.pipe(switchMap(() => {
      return userService.getBackListedMobNumMobileNumberDetail(control.value).pipe(map(
          users => {
            return (users && users.length > 0) ? {blackListedMobNum : true} : null;
          }
        ));
    }));
  };
}

@Directive({
  selector: '[blackListedMobNum][formControlName],[blackListedMobNum][formControl],[blackListedMobNum][ngModel]',
  providers: [{provide: NG_ASYNC_VALIDATORS, useExisting : BlackListedMobileNumberValidatorDirective, multi: true }]
})
export class BlackListedMobileNumberValidatorDirective implements AsyncValidator {

  constructor(private userService: UserService){ }

  validate(control: AbstractControl): Promise<ValidationErrors> | Observable<ValidationErrors> {
    return blackListedMobileNumberValidator(this.userService)(control);
  }
}
