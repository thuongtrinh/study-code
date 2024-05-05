import { Injectable } from '@angular/core';
import { Action } from '@ngrx/store';
import * as fromActions from '../actions/article2.actions';
import { Article2Service } from '../services/article2.service';
import { Observable, of, pipe } from 'rxjs';
import { Effect, Actions, ofType } from '@ngrx/effects';
import { switchMap, map, mergeMap, catchError, debounceTime } from 'rxjs/operators';

@Injectable()
export class Article2Effects {
  constructor(
    private actions$: Actions,
    private articleService: Article2Service
  ) {}

  @Effect()
  loadAllArticles$: Observable<Action> = this.actions$.pipe(ofType(fromActions.SHOW_ALL),
    switchMap(() =>
      this.articleService.getAllArticles().pipe(
        map(data => new fromActions.ShowAllSuccessAction(data))
      )
    ));

  @Effect()
  createArticle$: Observable<Action> = this.actions$.pipe(
      ofType<fromActions.CreateAction>(fromActions.CREATE),
      map(action => action.payload),
      mergeMap(article =>
        this.articleService.createArticle(article).pipe(
          map(res => new fromActions.CreateSuccessAction(res)),
          catchError(error => of(new fromActions.CreateFailureAction(error)))
        )
      )
  );

  @Effect()
  searchArticleById$: Observable<Action> = this.actions$.pipe(
    ofType<fromActions.GetByIdAction>(fromActions.GET_BY_ID),
    pipe(
      debounceTime(500),
      map(action => action.payload),
      switchMap(id => this.articleService.getArticleById(id).pipe(
        map(res => new fromActions.GetByIdSuccessAction(res)))
      )
    )
  );
}
