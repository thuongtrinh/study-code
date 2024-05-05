import { Article2 } from '../models/article2';

export interface AppState2 {
  article2State: Article2State;
}

export interface Article2State {
  articles: Article2[];
  message: any;
}
