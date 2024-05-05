import { Injectable } from '@angular/core';
import { Article } from '../models/article.model';
import { Observable, of, BehaviorSubject, throwError } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';

// const ARTICLES = [
//   new Article(1, 'Core Java Tutorial', 'Java'),
//   new Article(2, 'Angular Tutorial', 'Angular'),
//   new Article(3, 'Hibernate Tutorial', 'Hibernate')
// ];
// let articlesObservable = of(ARTICLES);

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  url = '/api/articles';
  articleBej: BehaviorSubject<Observable<Article[]>>;
  articles$: Observable<Article[]>;

  constructor(private http: HttpClient) {
    this.articleBej = new BehaviorSubject(this.articles$);
  }

  getArticlesBehaviorSubject(): Observable<Article[]> {
    this.articles$ = this.http.get<Article[]>(this.url);
    this.articleBej.next(this.articles$);
    return this.articles$;
  }

  getArticles(): Observable<Article[]> {
    return this.http.get<Article[]>(this.url);
  }

  getArticle(id: string): Observable<Article> {
    return this.http.get<Article>(this.url + '/' + id);
  }

  updateArticle(article: Article): Observable<number> {
    const httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.put<Article>(this.url + '/' + article.id, article,
            { headers: httpHeader, observe: 'response' }).pipe(map(res => res.status));
  }

  postArticle(article: Article): Observable<HttpResponse<Article>> {
    const httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<Article>(this.url, article, {
      headers: httpHeader,
      observe: 'response'
    });
  }

  createArticle(article: Article): Observable<Article> {
    const httpHeaders = new HttpHeaders().set('Content-Type', 'application/json');
    const options = { headers: httpHeaders };
    return this.http.post<Article>(this.url, article, options);
  }

  deleteArticle(article: Article) {
    return this.http.delete(this.url + '/' + article.id, { responseType: 'text' });
  }
}
