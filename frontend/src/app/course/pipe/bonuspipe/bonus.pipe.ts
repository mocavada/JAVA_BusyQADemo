import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'bonus'
})
export class BonusPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    return value + 500;
  }

}
