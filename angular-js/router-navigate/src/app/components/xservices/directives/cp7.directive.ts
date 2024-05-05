import { Directive, HostListener, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[appCp7]'
})
export class Cp7Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('mouseover')
  onMouseOver() {
    this.renderer.addClass(this.elRef.nativeElement, 'abc');
  }

  @HostListener('mouseleave')
  onMouseLeave() {
    this.renderer.removeClass(this.elRef.nativeElement, 'abc');
  }
}
