import { Component, OnInit, Input } from '@angular/core';
import { MyPost } from 'src/app/models/mypost';

@Component({
  selector: 'app-technology',
  templateUrl: './technology.component.html',
  styleUrls: ['../comp-lifecycle.component.scss'],
})
export class TechnologyComponent implements MyPost {

  @Input() post: any;

  constructor() { }

}
