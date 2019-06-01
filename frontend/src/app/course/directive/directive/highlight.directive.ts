import { ElementRef } from '@angular/core';
/* tslint:disable:member-ordering */
import { Directive, HostListener, Input } from '@angular/core';

@Directive({ selector: '[appHightlightColor]' })
export class HighlightDirective {
  @Input('appHightlightColor') appHightlightColor: string;
  defaultColor = 'red';

  constructor(private el: ElementRef) {
  }

  @HostListener('click') onMouseEnter() {
    if (this.appHightlightColor == null) {
      this.el.nativeElement.style.backgroundColor = this.defaultColor;
      // this.el.nativeElement.style.font-size = 5;
    } else {
      this.highlight(this.appHightlightColor);
    }
  }

  @HostListener('mouseleave') onMouseLeave() {
    this.highlight(null);
  }

  private highlight(color: string) {
    this.el.nativeElement.style.backgroundColor = color;
  }
}
