import { Pipe, PipeTransform } from '@angular/core';
import {UpperCasePipe} from '@angular/common';

@Pipe({
  name: 'myuppercasetwo'
})
export class MyuppercasetwoPipe implements PipeTransform {

  transform(value: any, seperator: string): string {
    const upipe = new UpperCasePipe();
    let result = upipe.transform(value);
    result = result.split(' ').join(seperator);

    return result;
  }

}
