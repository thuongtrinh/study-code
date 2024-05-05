import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class RequestTimestampInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const startTime = (new Date()).getTime();

    return next.handle(req).pipe(
      map(
        (event) => {
          if (event instanceof HttpResponse) {
            const endTime = (new Date()).getTime();
            event = event.clone({headers: event.headers.set('endTime', endTime.toString())});
            event = event.clone({headers: event.headers.set('startTime', startTime.toString())});
            const diff = endTime - startTime;
            console.log('GET ' + event.url + ' succeded in ' + diff + ' milliseconds');
          }
          return event;
        }
      ), tap(event => {},
          error => {
            const endTime = (new Date()).getTime();
            const diff = endTime - startTime;
            if (error instanceof HttpErrorResponse) {
              console.log(error.url + ' failed in ' + diff + ' milliseconds');
            } else {
              console.log(error.url + ' connection time is ' + diff
                              + ' milliseconds, code error: ' + error.status);
            }
          }
        )
    );
  }
}
