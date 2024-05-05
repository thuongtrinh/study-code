import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Article2 } from '../models/article2';

@Injectable()
export class Article2Service {
  constructor(private http: HttpClient) {}

  url = '/api/articles2';

  getAllArticles(): Observable<Article2[]> {
    return this.http.get<Article2[]>(this.url);
    // const asss = this.http.get<Article2[]>(this.url);
    // console.log(asss);
    // console.log(222);
    // return asss;
  }

  createArticle(article: Article2): Observable<Article2> {
    return this.http.post<Article2>(this.url, article);
  }

  getArticleById(id: string): Observable<Article2[]> {
    console.log(id);
    return this.http.get<Article2[]>(this.url + '?id=' + id);
  }
}
