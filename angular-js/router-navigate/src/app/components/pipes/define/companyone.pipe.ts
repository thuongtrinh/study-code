import { Pipe, PipeTransform } from '@angular/core';
import { CompanyPipe } from 'src/app/models/companyPipe.model';

@Pipe({
  name: 'companyone'
})
export class CompanyonePipe implements PipeTransform {

  transform(object: CompanyPipe): string {
    const output = object.cname + ' : ' + object.location;
    return output;
  }

}
