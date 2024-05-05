import { Action } from '@ngrx/store';
import { ArticleRX } from '../modules/articleRX';

export const JAVA = 'Java';
export const  ANGULAR = 'Angular';
export const  MY_ARTICLES_RX = 'Favorite_Articles';

export class JavaArticlesRXAction implements Action {
  readonly type = JAVA;
}

export class AngularArticlesRXAction implements Action {
  readonly type = ANGULAR;
}

export class FavoriteArticlesRXAction implements Action {
  readonly type = MY_ARTICLES_RX;
  constructor(public payload: ArticleRX[]) {}
}

export type All = JavaArticlesRXAction | AngularArticlesRXAction | FavoriteArticlesRXAction;
