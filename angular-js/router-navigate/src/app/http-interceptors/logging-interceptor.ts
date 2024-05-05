import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap, finalize } from 'rxjs/operators';

@Injectable({providedIn: 'root'})
export class LoggingInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const startTime = Date.now();
    let status: string;

    return next.handle(req).pipe(
      tap(
        events => {
          status = '';
          if (events instanceof HttpResponse) {
            status = 'successed';
          }
        },
        error => status = 'failed'
      ),
      finalize(() => {
        const elapsedTime = Date.now() - startTime;
        const message = 'Logging: ' + req.method + ' ' + req.urlWithParams + ' ' + status + ' in ' + elapsedTime + ' ms';
        this.logDetails(message);
      })
    );
  }

  private logDetails(msg: string) {
    console.log(msg);
  }
}
