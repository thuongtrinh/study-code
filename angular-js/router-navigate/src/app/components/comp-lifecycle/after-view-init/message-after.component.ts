import { Component, OnInit, ViewChildren, QueryList, ViewChild, TemplateRef, AfterViewInit } from '@angular/core';
import { MessageAfterDirective } from './message-after.directive';

@Component({
  selector: 'app-message-after',
  template: `
    <h4>@ViewChildren() and @ViewChild()</h4>
    <div appMessageAfter></div>
    <div appMessageAfter></div>
    <div appMessageAfter></div>

    <ng-template #msgTemp>Namaste!</ng-template>
  `,
})
export class MessageAfterComponent implements AfterViewInit {

  @ViewChildren(MessageAfterDirective)
  private msgList: QueryList<MessageAfterDirective>;

  @ViewChild('msgTemp', {static: false})
  private msgTempRef: TemplateRef<any>;

  constructor() { }

  ngAfterViewInit() {
    console.log('this.msgList.length: ' + this.msgList.length);

    this.msgList.forEach(msgDirective => {
      msgDirective.viewContainerRef.createEmbeddedView(this.msgTempRef);
    });
  }

}
