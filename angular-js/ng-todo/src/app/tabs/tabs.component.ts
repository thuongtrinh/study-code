import { Component, Input, OnInit, TemplateRef } from '@angular/core';

@Component({
  selector: 'tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.css']
})
export class TabsComponent implements OnInit {

  @Input() navs: string[];
  @Input() linkTmpl: TemplateRef<any>;

  constructor() { }

  ngOnInit(): void {
  }

}
