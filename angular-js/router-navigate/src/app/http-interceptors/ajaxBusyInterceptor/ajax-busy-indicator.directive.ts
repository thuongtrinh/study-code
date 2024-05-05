import { Directive, OnInit, Input, ElementRef, Renderer2 } from '@angular/core';
import { Subscription, interval } from 'rxjs';
import { AjaxBusyNotifierService } from './ajax-busy-notifier.service';

@Directive({
  selector: '[ajax-busy-indicator]'
})
export class AjaxBusyIndicatorDirective implements OnInit {

  @Input() showDelay = 50;
  @Input() hideDelay = 1000;
  hideTimer: Subscription;
  showTimer: Subscription;

  constructor(
    private el: ElementRef,
    private renderer: Renderer2,
    private abnService: AjaxBusyNotifierService
  ) {}

  ngOnInit(): void {
    this.abnService.busy.subscribe(busy => {
      if (busy) {
        this.cancelPendingHide();

        // If a show is already pending, don't start a new one.
        if (!this.showTimer) {
          this.showTimer = interval(this.showDelay).subscribe(() => {
            this.renderer.removeClass(this.el.nativeElement, 'inactive');
            this.showTimer.unsubscribe();
            this.showTimer = null;
          });
        }
      }
    });

    this.abnService.busy.subscribe(busy => {
      if (!busy) {
        this.cancelPendingShow();

        // If a show is already pending, don't start a new one.
        if (!this.hideTimer) {
          this.hideTimer = interval(this.hideDelay).subscribe(() => {
            this.renderer.addClass(this.el.nativeElement, 'inactive');
            this.hideTimer.unsubscribe();
            this.hideTimer = null;
          });
        }
      }
    });
  }

  cancelPendingHide() {
    if (this.hideTimer) {
      this.hideTimer.unsubscribe();
      delete this.hideTimer;
    }
  }

  cancelPendingShow() {
    if (this.showTimer) {
      this.showTimer.unsubscribe();
      delete this.showTimer;
    }
  }
}
