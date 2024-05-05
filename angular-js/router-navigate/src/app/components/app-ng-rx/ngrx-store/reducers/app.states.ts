import { ArticleRX } from '../modules/articleRX';

export interface AppState {
  articleRXState: ArticleRXState;
}

export interface ArticleRXState {
  articlesRX: ArticleRX[];
}
