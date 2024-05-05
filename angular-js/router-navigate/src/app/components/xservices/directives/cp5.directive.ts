import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp5]'
})
export class Cp5Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('mouseover')
  onMouseOver() {
    this.renderer.setAttribute(this.elRef.nativeElement, 'value', 'ThuongTX');
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.renderer.removeAttribute(this.elRef.nativeElement, 'value');
  }
}
