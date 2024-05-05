import { Injectable, ErrorHandler, Injector } from '@angular/core';
import { Router } from '@angular/router';
import { HttpErrorResponse } from '@angular/common/http';
import { LoggerService } from './logger.service';

@Injectable({
  providedIn: 'root'
})
export class GlobalErrorHandlerService implements ErrorHandler {

  constructor(private injector: Injector) { }

  handleError(error: any): void {
    let router = this.injector.get(Router);
    console.log('URL: ' + router.url);

    let loggerService = this.injector.get(LoggerService);
    loggerService.log(error);

    if (error instanceof HttpErrorResponse) {
      // Backend returns unsuccessful response codes such as 404, 500 etc.
      console.error('Backend returned status code: ', error.status);
      console.error('Response body:', error.message);
    } else {
      // A client-side or network error occurred
      console.log('An error occurred:', error.message);
    }

    // throw new Error("Method not implemented.");
    router.navigate(['/error']);
  }
}
