import { Component, OnInit, ViewChild, ElementRef, Renderer2 } from '@angular/core';

@Component({
  selector: 'app-append',
  templateUrl: './append-demo.component.html',
})
export class AppendDemoComponent implements OnInit {

  @ViewChild('abcd', {static: false})
  private abcd: ElementRef;

  constructor(private renderer: Renderer2) { }

  ngOnInit() {
  }

  onClick() {
    const li = this.renderer.createElement('li');
    const text = this.renderer.createText('Click here to add li');
    this.renderer.appendChild(li, text);
    this.renderer.appendChild(this.abcd.nativeElement, li);
  }
}
