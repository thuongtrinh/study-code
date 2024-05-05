import { Directive } from '@angular/core';
import { NG_ASYNC_VALIDATORS, AsyncValidator, AbstractControl, ValidationErrors, AsyncValidatorFn } from '@angular/forms';
import { Observable, timer } from 'rxjs';
import { UserService } from '../services/user.service';
import { switchMap, map } from 'rxjs/operators';

export function existingUsernameValidator(userService: UserService): AsyncValidatorFn {
  return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
    const debouceTime = 500; // milliseconds
    const timerOb = timer(debouceTime);

    return timerOb.pipe(switchMap(() => {
      return userService.getUserByUsername(control.value).pipe(map(users => {
        return (users && users.length > 0) ? {usernameExists : true} : null;
      }));
    }));
  };
}

@Directive({
  selector: '[usernameExists][formControlName],[usernameExists][formControl],[usernameExists][ngModel]',
  providers: [{provide: NG_ASYNC_VALIDATORS, useExisting: ExistingUsernameValidatorDirective, multi: true}]
})
export class ExistingUsernameValidatorDirective implements AsyncValidator {

  constructor(private userService: UserService) {}

  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return existingUsernameValidator(this.userService) (control);
  }
}
