import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { AuthicService } from './authic.service';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptor implements HttpInterceptor {

  constructor(private auth: AuthicService) { }

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (this.auth.isAuthenticated) {
      alert(777);
      req = req.clone({
        headers: req.headers.set('Authorization', 'Bearer ' + this.auth.authToken)
      });
    }

    return next.handle(req);
  }
}
