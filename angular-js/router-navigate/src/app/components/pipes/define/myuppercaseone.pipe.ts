import { Pipe, PipeTransform } from '@angular/core';
import { UpperCasePipe } from '@angular/common';

@Pipe({
  name: 'myuppercaseone'
})
export class MyuppercaseonePipe extends UpperCasePipe {

  transform(value: string): string {
    let result = super.transform(value);
    result = result.split(' ').join('-');
    return result;
  }

}
