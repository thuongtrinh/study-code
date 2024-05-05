import { Directive, TemplateRef, ViewContainerRef, Input } from '@angular/core';

@Directive({
  selector: '[appCpIf]'
})
export class CpIfDirective {

  constructor(private templateRef: TemplateRef<any>, private viewContainer: ViewContainerRef) { }

  @Input() set appCpIf(condition: boolean) {
    if (condition) {
      this.viewContainer.createEmbeddedView(this.templateRef);
    } else {
      this.viewContainer.clear();
    }
  }
}
