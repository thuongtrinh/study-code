import { Component, OnInit } from '@angular/core';
import { from, of, fromEvent, throwError } from 'rxjs';
import {
  map, mergeMap, concatMap,
  switchAll, switchMap,
  delay, mergeAll, filter, scan,
  mergeScan, mapTo, tap,
  catchError, debounceTime, retry, exhaustMap
} from 'rxjs/operators';

@Component({
  selector: 'app-country',
  templateUrl: './country.component.html',
  styleUrls: ['./country.component.scss']
})
export class CountryComponent implements OnInit {
  constructor() {}

  ngOnInit() {
    fromEvent(document.getElementById('myelement'), 'mouseover')
      .pipe(
        debounceTime(1000),
        map(data => data.srcElement)
      )
      .subscribe(val => console.log(val));
  }

  studyMapInRXJS() {
    // Example usage map,  mergeAll, mergeMap, switchAll, switchMap
    const getData = param => {
      return of(`retrieved new data with param ${param}`).pipe(delay(400));
    };

    // using a regular map
    from([1, 2, 3, 4])
      .pipe(map(param => getData(param)))
      .subscribe(val => val.subscribe(data => console.log('map: ' + data)));

    // using map and mergeAll
    from([1, 2, 3, 4])
      .pipe(
        map(param => getData(param)),
        mergeAll()
      )
      .subscribe(val => console.log('mergeAll: ' + val));

    // using mergeMap
    from([1, 2, 3, 4])
      .pipe(mergeMap(param => getData(param)))
      .subscribe(val => console.log('mergeMap: ' + val));

    // mergeMap ex2
    of('mergeMap-x', 'mergeMap-y', 'mergeMap-z').pipe(
        mergeMap(el => of(1, 2).pipe(
          delay(2000),
          map(num => el + num)
        )
      )
     ).subscribe(res => console.log(res));

    // ExhaustMap returns the response of oldest inner Observable. It is opposite to switchMap operator.
    of('ExhaustMap-x', 'ExhaustMap-y', 'ExhaustMap-z').pipe(
      exhaustMap(el => of(1, 2).pipe(
        delay(2000),
        map(num => el + num)
      )
    )
   ).subscribe(res => console.log(res));

    // using map and switchAll
    from([1, 2, 3, 4])
      .pipe(
        map(param => getData(param)),
        switchAll()
      )
      .subscribe(val => console.log('switchAll: ' + val));

    // using switchMap
    from([1, 2, 3, 4])
      .pipe(switchMap(param => getData(param)))
      .subscribe(val => console.log('switchMap: ' + val));

    // ===================ConcatMap===================
    const getDataConcatMap = param => {
      const delayTime = Math.floor(Math.random() * 10000) + 1;
      return of(
        `retrieved new data with params: ${param} and delay: ${delayTime}`
      ).pipe(delay(delayTime));
    };

    // using a regular map
    from([1, 2, 3, 4])
      .pipe(map(param => getDataConcatMap(param)))
      .subscribe(val =>
        val.subscribe(data => console.log('map ConcatMap:', data))
      );

    // using mergeMap
    from([1, 2, 3, 4])
      .pipe(mergeMap(param => getDataConcatMap(param)))
      .subscribe(val => console.log('mergeMap ConcatMap:', val));

    // using concatMap
    from([1, 2, 3, 4])
      .pipe(concatMap(param => getDataConcatMap(param)))
      .subscribe(val => console.log('concatMap :', val));

    // -----------------------------------------------------------------------
    // ===================scan===================
    from([1, 2, 5, 14])
      .pipe(
        filter(n => n % 2 === 1),
        map(n => n + 10),
        scan((sum, n) => sum + n)
      )
      .subscribe(result => console.log('scan:' + result));

    // ===================mergeScan ===================
    const click$ = fromEvent(document, 'click');
    const one$ = click$.pipe(mapTo(1));
    const seed = 0;
    const count$ = one$.pipe(mergeScan((acc, one) => of(acc + one), seed));
    count$.subscribe(x => console.log(x));
  }

  studyObservable() {
    // Example study
    this.studyMapInRXJS();
  }

  tapAndCatchErrorObservable() {
    // ===================tap==================
    of(1, 2, 3, 4)
      .pipe(
        tap(
          el => console.log('Process' + el),
          err => console.error(err),
          () => console.log('Complete')
        ),
        filter(n => n % 2 === 0)
      )
      .subscribe(el => console.log('Even number: ' + el));

    const cities = ['Varanasi', 'Mathura', 'Ayodhya'];
    of(cities)
      .pipe(
        tap(c => console.log(c.length)),
        map(dataArray => dataArray.join(', '))
      )
      .subscribe(res => console.log(res));

    of(cities)
      .pipe(
        tap(cname => console.log('Accessing country name...')),
        map(country => country),
        tap(cname => console.log(cname)),
        catchError(err => {
          console.error('err');
          console.error(err);
          return of([]);
        })
      )
      .subscribe();

    // ===================Not use catchError==================
    of('A', 'B', 'C', 'D', 'E')
      .pipe(
        map(el => {
          if (el === 'C') {
            throw new Error('Error occurred.');
          }
          return el;
        })
      )
      .subscribe(
        el => console.log(el),
        err => console.error(err),
        () => console.log('Processing Complete.')
      );

    // ===================Use catchError==================
    of('A', 'B', 'C', 'D', 'E')
      .pipe(
        map(el => {
          if (el === 'C') {
            throw new Error('Error occurred.');
          }
          return el;
        }),
        catchError(err => {
          console.error(err.message);
          console.log('Error is handled');
          return of('Z');
        })
      )
      .subscribe(
        el => console.log(el),
        err => console.error(err),
        () => console.log('Processing Complete.')
      );
  }

  retryObservable() {
    console.log('------Total max 3 retry, but no success and throw error.------');
    // Total max 3 retry, but no success and throw error.
    of(1, 2, 3, 4).pipe(
      mergeMap(data => {
        if (data === 3) {
          return throwError('Error Occurred.');
        }
        return of(data);
      }),
      retry(3)
    ).subscribe(res => console.log(res),
      err => {
        console.log('Retried for 3 times.');
        console.error(err);
      }
    );

    // Total max 5 retry, but success in 3rd retry
    console.log('-------Total max 5 retry, but success in 3rd retry------');
    let retryCount = 0;
    of('a', 'b', 'c', 'd').pipe(
      mergeMap(data => {
        if (data === 'c' && retryCount !== 3) {
          retryCount = retryCount + 1;
          return throwError('Error Occurred.');
        }
        return of(data);
      }),
      retry(5)
    ).subscribe(res => console.log(res),
      err => {
        console.log('Number of retry: ' + retryCount);
        console.error(err);
      },
      () => console.log('Processing Complete. Number of retry: ' + retryCount)
    );

    // Retry and catchError
    console.log('------Retry and catchError------');
    of('A', 'B').pipe(
      switchMap(el => {
        // console.log(el);
        if (el === 'B') {
          throw new Error('Error occurred.');
        }
        return el;
      }),
      retry(2),
      catchError(err => {
        console.error(err.message);
        console.log('Error is handled');
        return of('X'); // return defualt value as X
      })
    ).subscribe(el => console.log(el),
      err => console.error(err),
      () => console.log('Processing Complete.')
    );
  }
}
