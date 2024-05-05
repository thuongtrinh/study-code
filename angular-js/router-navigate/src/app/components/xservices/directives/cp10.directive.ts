import { Directive, ElementRef, Renderer2, HostListener } from '@angular/core';

@Directive({
  selector: '[appCp10]'
})
export class Cp10Directive {

  constructor(private elRef: ElementRef, private renderer: Renderer2) { }

  @HostListener('click')
  performTask() {
    const comment = this.renderer.createComment('Testing createComment');
    this.renderer.appendChild(this.elRef.nativeElement, comment);
  }
}
