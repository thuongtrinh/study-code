import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { LoggingInterceptor } from './logging-interceptor';
import { CachingInterceptor } from './caching-interceptor';
import { RequestTimestampInterceptor } from './requestTimestamp/request-timestamp-interceptor';
import { AjaxBusyIdentifierInterceptor } from './ajaxBusyInterceptor/ajax-busy-identifier-interceptor';
import { XML2JsonInterceptor } from './request-format/xml2-json-interceptor';
import { ErrorNotifierInterceptor } from './errorNotifier/error-notifier-interceptor';
import { AuthInterceptor } from './authentication/auth-interceptor';
import { RetryInterceptor } from './retryInterceptor/retry-interceptor';

export const httpInterceptorArtProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: CachingInterceptor, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: LoggingInterceptor, multi: true },
];

export const httpInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: RequestTimestampInterceptor, multi: true },
  { provide: HTTP_INTERCEPTORS, useClass: AjaxBusyIdentifierInterceptor, multi: true},
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true},
  { provide: HTTP_INTERCEPTORS, useClass: XML2JsonInterceptor, multi: true},
  { provide: HTTP_INTERCEPTORS, useClass: ErrorNotifierInterceptor, multi: true},
  { provide: HTTP_INTERCEPTORS, useClass: RetryInterceptor, multi: true}
];
