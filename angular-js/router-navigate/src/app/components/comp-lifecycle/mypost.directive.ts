import { ViewContainerRef, Directive } from '@angular/core';

@Directive({
  selector: '[apMyPost]'
})
export class MyPostDirective {
  constructor(public viewContainerRef: ViewContainerRef) {
  }
}
