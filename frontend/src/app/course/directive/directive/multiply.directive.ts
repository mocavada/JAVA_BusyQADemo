import {Directive, Input, TemplateRef, ViewContainerRef} from '@angular/core';

@Directive({
  selector: '[appMultiply]'
})
export class MultiplyDirective {

  constructor(
    private templateRef: TemplateRef<any>,
    private viewContainer: ViewContainerRef) {
  }

  // When the property is set, trigger the method
  // set: typescript setter syntax
  @Input() set appMultiply(loopNumber: number) {

    if (loopNumber > 0) {
      for (let index = 1; index < loopNumber; index++) {
        this.viewContainer.createEmbeddedView(this.templateRef);
      }
    } else {
      this.viewContainer.clear();
    }
  }

}
