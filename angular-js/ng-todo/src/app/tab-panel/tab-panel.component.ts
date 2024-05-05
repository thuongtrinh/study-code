import { Component, ContentChild, Input, OnDestroy, OnInit, TemplateRef, ViewChild } from '@angular/core';
import { TabContentDirective } from '../bs-tab-group/tab-content.directive';
import { TabGroupComponent } from '../tab-group/tab-group.component';

@Component({
  selector: 'app-tab-panel',
  templateUrl: './tab-panel.component.html',
  styleUrls: ['./tab-panel.component.css']
})
export class TabPanelComponent implements OnInit, OnDestroy {

  @Input() title: string;
  @ViewChild(TemplateRef, {static: true}) implicitBody: TemplateRef<unknown>;
  @ContentChild(TabContentDirective, { static: true, read: TemplateRef}) explicitBody: TemplateRef<unknown>;

  constructor(private tabGroup: TabGroupComponent) { }

  get panelBody(): TemplateRef<unknown> {
    return this.explicitBody || this.implicitBody;
  }

  ngOnInit() {
    console.log(this.explicitBody)
    this.tabGroup.addTabPanel(this);
  }

  ngOnDestroy() {
    this.tabGroup.removeTabPanel(this);
  }
}
