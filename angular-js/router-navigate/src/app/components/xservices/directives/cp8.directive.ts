import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp8]'
})
export class Cp8Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  toggleFlag = false;

  @HostListener('click')
  performTask() {
    this.toggleFlag = (this.toggleFlag) ? false : true;

    if (this.toggleFlag) {
      this.renderer.setStyle(this.elRef.nativeElement, 'color', 'blue');
      this.renderer.setStyle(this.elRef.nativeElement, 'font-size', '20px');
    } else {
      this.renderer.removeStyle(this.elRef.nativeElement, 'color');
      this.renderer.removeStyle(this.elRef.nativeElement, 'font-size');
    }
  }

}
