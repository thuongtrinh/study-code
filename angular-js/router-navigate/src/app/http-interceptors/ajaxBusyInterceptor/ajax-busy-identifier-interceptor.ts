import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';
import { AjaxBusyNotifierService } from './ajax-busy-notifier.service';

@Injectable({
  providedIn: 'root'
})
export class AjaxBusyIdentifierInterceptor implements HttpInterceptor {

  constructor(private abnService: AjaxBusyNotifierService) { }

  requestCounter = 0;

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    this.beginRequest();

    return next.handle(req).pipe(
      finalize(() => {
        this.endRequest();
      })
    );
  }

  beginRequest() {
    this.requestCounter = Math.max(this.requestCounter, 0) + 1;

    if (this.requestCounter === 1) {
      this.abnService.busy.next(true);
    }
  }

  endRequest() {
    this.requestCounter = Math.max(this.requestCounter, 1) - 1;

    if (this.requestCounter === 0) {
        this.abnService.busy.next(false);
    }
  }
}
