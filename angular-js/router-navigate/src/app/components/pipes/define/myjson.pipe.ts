import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'myjson'
})
export class MyjsonPipe implements PipeTransform {

  transform(value: any, prettyprint: number, fields: string): string {
    const array = (fields == null ? null : fields.split(','));
    const pp = (prettyprint == null ? 0 : prettyprint);
    const result = JSON.stringify(value, array, pp);
    return result;
  }

}
