import { Directive, Input } from '@angular/core';
import { Validator, NG_VALIDATORS, FormControl } from '@angular/forms';

@Directive({
  selector: '[customMax][formControlName],[customMax][formControl],[customMax][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: CustomMaxDirective, multi: true}]
})
export class CustomMaxDirective implements Validator {
  @Input()
  customMax: number;

  validate(c: FormControl): {[key: string]: any} {
    const v = c.value;
    const isInvalid = (v !== null && v !== '' && v > this.customMax);
    return isInvalid ? {customMax : true} : null;
  }
}
