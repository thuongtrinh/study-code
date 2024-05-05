import { Pipe, PipeTransform } from '@angular/core';
import { CompanyPipe } from 'src/app/models/companyPipe.model';

@Pipe({
  name: 'companytwo',
  pure: false
})
export class CompanytwoPipe implements PipeTransform {

  transform(object: CompanyPipe): string {
    const output = object.cname + ' : ' + object.location;
    return output;
  }

}
