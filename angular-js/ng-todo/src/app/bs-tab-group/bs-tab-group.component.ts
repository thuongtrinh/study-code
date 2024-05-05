import { Component, OnInit } from '@angular/core';
import { TabGroupComponent } from '../tab-group/tab-group.component';

@Component({
  selector: 'app-bs-tab-group',
  templateUrl: './bs-tab-group.component.html',
  styleUrls: ['./bs-tab-group.component.css'],
  providers: [
    {
      provide: TabGroupComponent,
      useExisting: BsTabGroupComponent
    }
  ]
})
export class BsTabGroupComponent extends TabGroupComponent {

}
