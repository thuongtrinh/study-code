import { Directive, ElementRef, Renderer2, AfterViewInit } from '@angular/core';

@Directive({
  selector: '[appCp11]'
})
export class Cp11Directive implements AfterViewInit {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  toggleFlag = false;

  ngAfterViewInit(): void {
    this.renderer.listen(this.elRef.nativeElement, 'click', () => {
      this.toggleFlag = (this.toggleFlag) ? false : true;

      if (this.toggleFlag) {
        this.renderer.setStyle(this.elRef.nativeElement, 'color', 'red');
      } else {
        this.renderer.removeStyle(this.elRef.nativeElement, 'color');
      }
    });
  }
}
