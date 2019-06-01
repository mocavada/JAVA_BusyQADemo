import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'capitalize'
})
export class CapitalizePipe implements PipeTransform {
  transform(value: any, args?: any): any {
    // Transfor Logic
    // return value;

    // let result = 'CA$';
    // result = result + value;
    // return result;

    if (!value) {
      return value;
    } else {
      return value.replace(/\w*/g, function (txt) {
        return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();
      });
    }


    // ======== Regular expression
    /*

    /pattern/flag

    pattern:
    \W: represent [A-Za-z0-9]
    \S: represent [^\f\n\r\t\v]: any none blank char
    *: represent many words

    flag:
    /i: case insensitive
    /g: Global match: match only one or more

     */
  }
}
