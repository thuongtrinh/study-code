import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl, FormBuilder } from '@angular/forms';
import { ArticleService } from 'src/app/services/article.service';
import { Article } from 'src/app/models/article.model';
import { Observable } from 'rxjs';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-article-add',
  templateUrl: './article-add.component.html'
})
export class ArticleAddComponent implements OnInit {

  articleForm: FormGroup;
  articles$: Observable<Article[]>;

  constructor(private formBuilder: FormBuilder, private articleService: ArticleService) { }

  ngOnInit() {
    this.articleForm = this.formBuilder.group({
      title: ['', [ Validators.required ] ],
      category: ['', [ Validators.required ] ]
    });

    this.articleService.getArticlesBehaviorSubject();
    this.articleService.articleBej.subscribe(arts$ => this.articles$ = arts$);
  }

  onFormSubmit() {
    if (this.articleForm.valid) {
      const article = this.articleForm.value;
      this.articleService.getArticles().subscribe(articles => {
        const maxIndex = articles.length - 1;
        const item = articles[maxIndex];
        article.id = item.id + 1;
        this.createArticle(article);
      });

      this.articleForm.reset();
    }
  }

  createArticle(article: Article) {
    this.articleService.createArticle(article).subscribe(art => {
        console.log(art);
        // Load list of data new
        this.articleService.getArticlesBehaviorSubject();
      },
      err => {
        console.log(err);
      }
    );
  }

  saveArticle() {
    const article = this.articleForm.value;
    this.articleService.getArticles().subscribe(articles => {
    const maxIndex = articles.length - 1;
    const item = articles[maxIndex];
    article.id = item.id + 1;

    this.articleService.postArticle(article).subscribe(res => {
      let artcl: Article = res.body;
      console.log(artcl.title);
      console.log(res.headers.get('Content-Type'));

      // Load list of data new
      this.articleService.getArticlesBehaviorSubject();

      }, (err: HttpErrorResponse) => {
        if (err.error instanceof Error) {
          // A client-side or network error occurred.
          console.log('An error occurred:', err.error.message);
        } else {
          // Backend returns unsuccessful response codes such as 404, 500 etc.
          console.log('Backend returned status code: ', err.status);
          console.log('Response body:', err.error);
        }
      });
    });
  }

  get title() {
    return this.articleForm.get('title');
  }

  get category() {
    return this.articleForm.get('category');
  }
}
