import { Directive, OnChanges, SimpleChanges, Input } from '@angular/core';
import { Validator, NG_VALIDATORS, AbstractControl, ValidatorFn } from '@angular/forms';

export function pwdCannotSameUserValidator(username: string): ValidatorFn {
  return (control: AbstractControl): {[key: string]: any} | null => {
    const password: string = control.value;
    const isInValid = (password != null && password !== '' && password === username) ?  true : false;
    return isInValid ? {matchForUsername: {value: 'Invalid'}} : null;
  };
}

@Directive({
  selector: '[matchForUsername][formControlName],[matchForUsername][formControl],[matchForUsername][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: PwdCannotSameUserValidatorDirective, multi: true}]
})
export class PwdCannotSameUserValidatorDirective implements Validator, OnChanges {
  @Input('matchForUsername')
  changedUsername: string;
  private _onChange: () => void;

  validate(control: AbstractControl): {[key: string]: any} | null {
    return this.changedUsername ? pwdCannotSameUserValidator(this.changedUsername)(control) : null;
  }

  registerOnValidatorChange?(fn: () => void): void {
    this._onChange = fn;
  }

  ngOnChanges(changes: SimpleChanges): void {
    if ('changedUsername' in changes) {
      if (this._onChange) {  this._onChange(); }
    }
  }
}
