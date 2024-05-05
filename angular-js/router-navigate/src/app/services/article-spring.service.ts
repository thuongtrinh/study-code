import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpResponse,
  HttpHeaders,
  HttpParams,
} from '@angular/common/http';
import { ArticleSpringModel } from '../models/article-spring.model';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class ArticleSpringService {
  // URLs for CRUD operations
  allArticlesUrl = 'http://localhost:8080/user/all-articles';
  articleUrl = 'http://localhost:8080/user/article';

  // Create constructor to get Http instance
  constructor(private http: HttpClient) {}

  // Fetch all articles
  getAllArticles(): Observable<ArticleSpringModel[]> {
    console.log('get all article spring');
    return this.http.get<ArticleSpringModel[]>(this.allArticlesUrl);
  }

  // Create article
  createArticle(article: ArticleSpringModel): Observable<HttpResponse<ArticleSpringModel>> {
    const httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<ArticleSpringModel>(this.articleUrl, article, {
      headers: httpHeaders,
      observe: 'response',
    });
  }

  // Fetch article by id
  getArticleById(articleId: string): Observable<ArticleSpringModel> {
    return this.http.get<ArticleSpringModel>(this.articleUrl + '/' + articleId);
  }

  // Update article
  updateArticle(article: ArticleSpringModel): Observable<number> {
    const httpHeader = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http
      .put<ArticleSpringModel>(this.articleUrl, article, { headers: httpHeader, observe: 'response' }
        ).pipe(map((res) => res.status));
  }

  // Delete article
  deleteArticleById(articleId: string) {
    console.log('deleteArticleById: ' + articleId);
    return this.http.delete(this.articleUrl + '/' + articleId, { responseType: 'text' });

    // const headers = new HttpHeaders({
    //   'Content-Type': 'text',
    // });

    // const httpParams = new HttpParams().set('id', articleId);
    // const options = { headers, params: httpParams };

    // this.http.delete(this.articleUrl, options).pipe(catchError(this.handleError));
  }

  private handleError(error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }
}
