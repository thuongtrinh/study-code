import { Directive } from '@angular/core';
import { NG_ASYNC_VALIDATORS, AsyncValidator, AbstractControl, ValidationErrors, AsyncValidatorFn } from '@angular/forms';
import { Observable, timer } from 'rxjs';
import { UserService } from '../services/user.service';
import { switchMap } from 'rxjs/operators';

export function existingEmailValidator(userService: UserService): AsyncValidatorFn {
  return (control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> => {
    const debouceTime = 500; // milliseconds
    const timerOb = timer(debouceTime);

    return timerOb.pipe(switchMap(() => {
      return userService.getUserByEmail(control.value).then(
        users => {
            return (users && users.length > 0) ? {emailExists : true} : null;
          }
        );
    }));
  };
}

@Directive({
  selector: '[emailExists][formControlName],[emailExists][formControl],[emailExists][ngModel]',
  providers: [{provide: NG_ASYNC_VALIDATORS, useExisting: ExistingEmailValidatorDirective, multi: true}]
})
export class ExistingEmailValidatorDirective implements AsyncValidator {

  constructor(private userSerice: UserService) {}

  validate(control: AbstractControl): Promise<ValidationErrors | null> | Observable<ValidationErrors | null> {
    return existingEmailValidator(this.userSerice) (control);
  }
}
