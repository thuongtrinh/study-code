import { Injectable, Injector } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest, HttpResponse } from '@angular/common/http';
import { of } from 'rxjs';
import { CacheMapService } from '../services/cache-map.service';
import { tap } from 'rxjs/operators';

const CACHABLE_URL = '/api';

@Injectable({providedIn: 'root'})
export class CachingInterceptor implements HttpInterceptor {

  constructor(private cacheMapService: CacheMapService, private inj: Injector) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    if (!this.isRequestCachable(req)) {
      return next.handle(req);
    }

    const cacheResponse = this.cacheMapService.get(req);
    let isAddCache = false;
    if (cacheResponse !== null) {
      console.log('cacheResponse existed: ');
      console.log(cacheResponse);
      // return of(cacheResponse);
    } else {
      console.log('cacheResponse is null: ');
      console.log(cacheResponse);
      isAddCache = true;
    }

    return next.handle(req).pipe(
      tap(event => {
        console.log(event);
        if (isAddCache && event instanceof HttpResponse) {
          this.cacheMapService.put(req, event);
        }
      })
    );
  }

  private isRequestCachable(req: HttpRequest<any>) {
    return (req.method === 'GET') && (req.url.indexOf(CACHABLE_URL) > -1);
  }
}
