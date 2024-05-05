import { ValidatorFn, AbstractControl } from '@angular/forms';

export function passMatchUserValidator(passwordLogin: string): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    const password: string = control.value;
    const isInValid = (passwordLogin === null || passwordLogin === ''
       || password === null || password === '' || password === passwordLogin) ?  false : true;
    return isInValid ? { matchForUsername : {value: 'Invalid'} } : null;
  };
}
