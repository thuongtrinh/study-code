import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ToggleComponent } from './toggle/toggle.component';
import { HelloComponent } from './hello/hello.component';
import { ProgressBarComponent } from './progress-bar/progress-bar.component';
import { FormsModule } from '@angular/forms';
import { TabsComponent } from './tabs/tabs.component';
import { TabGroupComponent } from './tab-group/tab-group.component';
import { TabPanelComponent } from './tab-panel/tab-panel.component';
import { BsTabGroupComponent } from './bs-tab-group/bs-tab-group.component';
import { CounterComponent } from './bs-tab-group/counter.component';
import { TabContentDirective } from './bs-tab-group/tab-content.directive';

@NgModule({
  declarations: [
    AppComponent,
    ToggleComponent,
    HelloComponent,
    ProgressBarComponent,
    TabsComponent,
    TabGroupComponent,
    TabPanelComponent,
    BsTabGroupComponent,
    CounterComponent,
    TabContentDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
