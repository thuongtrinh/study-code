import { ValidatorFn, AbstractControl } from '@angular/forms';

export function ruleNewPassword(): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    const passwordNew = control.value;
    const invalid = (passwordNew === null || passwordNew === '' || passwordNew.length >= 3) ? false : true;
    return invalid ? { ruleNewPassword : {value : 'Invalid'} } : null;
  };
}

export function confirmMatchingPassword(passwordNew: string): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    const password = control.value;
    const invalid = (password === null || password === '' || passwordNew === password) ? false : true;
    return invalid ? { validMatchPassword : {value : 'Invalid'}} : null;
  };
}
