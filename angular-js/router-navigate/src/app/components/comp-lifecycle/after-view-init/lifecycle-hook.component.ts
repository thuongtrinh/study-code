import { Component, OnInit, DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit,
  AfterViewChecked, OnDestroy } from '@angular/core';

@Component({
  selector: 'app-lifecycle-hook',
  template: `
    <h4>Lifecycle Hook Demo => view lifecycle in console.log</h4>
  `,
})
export class LifecycleHookComponent implements OnInit, DoCheck, AfterContentInit,
    AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy {

  constructor() {
    console.log('---constructor---');
  }

  ngOnInit() {
    console.log('---Inside ngOnInit---');
  }

  ngDoCheck(): void {
    console.log('---Inside ngDoCheck---');
  }

  ngAfterContentInit() {
    console.log('---Inside ngAfterContentInit---');
  }

  ngAfterContentChecked() {
    console.log('---Inside ngAfterContentChecked---');
  }

  ngAfterViewInit() {
    console.log('---Inside ngAfterViewInit---');
  }

  ngAfterViewChecked() {
    console.log('---Inside ngAfterViewChecked---');
  }

  ngOnDestroy() {
    console.log('---Inside ngOnDestroy---');
  }
}
