import { Component, OnInit, ViewChild, ElementRef, Renderer2, AfterViewInit } from '@angular/core';

@Component({
  selector: 'app-listen',
  templateUrl: './listen-demo.component.html',
})
export class ListenDemoComponent implements AfterViewInit {

  @ViewChild('xyz', {static: false})
  private xyz: ElementRef;

  toggleFlag = false;

  constructor(private renderer: Renderer2) { }

  ngAfterViewInit() {
    this.renderer.listen(this.xyz.nativeElement, 'click', () => {
        this.toggleFlag = (this.toggleFlag) ? false : true;
        if (this.toggleFlag) {
          this.renderer.setStyle(this.xyz.nativeElement, 'color', 'red');
        } else {
          this.renderer.removeStyle(this.xyz.nativeElement, 'color');
        }
    });
  }

}
