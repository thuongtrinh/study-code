import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'repeat'
})
export class RepeatPipe implements PipeTransform {

  transform(word: string, frequency: number): any {
    let cnt = 1;
    let strResult = word;
    while(cnt < frequency){
      strResult += ' ' + word;
      cnt++;
    }

    return strResult;
  }
}
