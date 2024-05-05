import { Component, OnInit, AfterViewInit } from '@angular/core';
import { Article } from 'src/app/models/article.model';
import { Observable } from 'rxjs';
import { ArticleService } from 'src/app/services/article.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article-list',
  templateUrl: './article-list.component.html'
})
export class ArticleListComponent implements OnInit, AfterViewInit {

  articles$: Observable<Article[]>;
  articlesA: Article[];

  constructor(
    private articleService: ArticleService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
  ) {}

  ngOnInit() {
    this.articleService.getArticlesBehaviorSubject();
    this.articleService.articleBej.subscribe(arts$ => this.articles$ = arts$);
  }

  ngAfterViewInit(): void {
  }

  gotoEdit(article: Article) {
    this.router.navigate([article.id], {relativeTo: this.activatedRoute});
  }

  gotoDelete(article: Article) {
    this.articleService
    .deleteArticle(article)
    .subscribe(() => {
        // update dynamic list to display
        this.articleService.getArticlesBehaviorSubject();

        // navigate to article
        this.router.navigate(['/dashboard/article'], {
          relativeTo: this.activatedRoute
        });
      },
      err => console.error(err)
    );
  }
}
