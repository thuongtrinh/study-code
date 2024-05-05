import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'division'
})
export class DivisionPipe implements PipeTransform {

  transform(dividend: any, divisor: any): any {
    const num = dividend / divisor;
    return num;
  }
}
