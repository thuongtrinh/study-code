import { Directive, TemplateRef, ViewContainerRef, Input } from '@angular/core';

@Directive({
  selector: '[appCpDelay]'
})
export class CpDelayDirective {

  constructor(private templateRef: TemplateRef<any>, private viewContainer: ViewContainerRef) { }

  @Input() set appCpDelay(delay: number) {
    this.viewContainer.clear();
    setTimeout(() => {
      this.viewContainer.createEmbeddedView(this.templateRef);
    }, delay);
  }
}
