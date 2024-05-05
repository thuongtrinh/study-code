import { Directive } from '@angular/core';
import { NG_ASYNC_VALIDATORS, AsyncValidator, AbstractControl, ValidationErrors, AsyncValidatorFn } from '@angular/forms';
import { Observable, timer } from 'rxjs';
import { UserService } from '../services/user.service';
import { switchMap, map } from 'rxjs/operators';

export function existingMobileValidator(userService: UserService): AsyncValidatorFn {
  return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
    const debouceTime = 500; // milliseconds
    const timerOb = timer(debouceTime);

    return timerOb.pipe(switchMap(() => {
      return userService.getUserByMobileNumber(control.value).pipe(map(users => {
        return (users && users.length > 0) ? {mobileExists : true} : null;
      }));
    }));
  };
}

@Directive({
  selector: '[mobileExists][formControlName],[mobileExists][formControl],[mobileExists][ngModel]',
  providers: [{provide: NG_ASYNC_VALIDATORS, useExisting: ExistingMobileValidatorDirective, multi: true}]
})
export class ExistingMobileValidatorDirective implements AsyncValidator {

  constructor(private userSerice: UserService) {}

  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return existingMobileValidator(this.userSerice) (control);
  }
}
