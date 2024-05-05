import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'strformat'
})
export class StrformatPipe implements PipeTransform {

  transform(value: string, seperator: string): any {
    const result = value.split(' ').join(seperator);
    return result;
  }

}
