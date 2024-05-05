import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class ErrorNotifierInterceptor implements HttpInterceptor {

  constructor(private toasterService: ToastrService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(req).pipe(
      tap(
        event => {},
        error => {
          if (error instanceof HttpErrorResponse) {
            this.toasterService.error(error.message, error.name, { closeButton: true });
          }
        }
      )
    );
  }
}
