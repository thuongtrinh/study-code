import { Injectable } from '@angular/core';
import { Cache } from './abstracts/cache';
import { HttpRequest, HttpResponse } from '@angular/common/http';
import { MAX_CACHE_AGE, CacheEntry } from '../interfaces/cache-entry';

@Injectable()
export class CacheMapService implements Cache {

  cacheMap = new Map<string, CacheEntry>();

  constructor() {}

  get(req: HttpRequest<any>): HttpResponse<any> | null {
    const entry = this.cacheMap.get(req.urlWithParams);
    if (!entry) {
      return null;
    }

    const isExpired = (Date.now() - entry.entryTime) > MAX_CACHE_AGE;
    return isExpired ? null : entry.response;
  }

  put(req: HttpRequest<any>, res: HttpResponse<any>) {
    const entry: CacheEntry = {
      url: req.urlWithParams,
      response: res,
      entryTime: Date.now()
    };

    this.cacheMap.set(req.urlWithParams, entry);
    this.deleteExpiredCache();
    console.log('put:');
    console.log(entry);
  }

  private deleteExpiredCache() {
    this.cacheMap.forEach(entry => {
      if (Date.now() - entry.entryTime > MAX_CACHE_AGE) {
        this.cacheMap.delete(entry.url);
      }
    });
  }
}
