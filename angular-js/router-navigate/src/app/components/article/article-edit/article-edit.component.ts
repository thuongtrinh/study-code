import { Component, OnInit } from '@angular/core';
import { Article } from 'src/app/models/article.model';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ArticleService } from 'src/app/services/article.service';
import { ActivatedRoute, Router } from '@angular/router';
import { map, switchMap } from 'rxjs/operators';

@Component({
  selector: 'app-article-edit',
  templateUrl: './article-edit.component.html',
  styleUrls: []
})
export class ArticleEditComponent implements OnInit {

  article: Article;
  articleForm: FormGroup;
  isUpdating = false;

  constructor(
    private articleService: ArticleService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    this.activatedRoute.paramMap
      .pipe(
        map(params => params.get('article-id')),
        switchMap(id => this.articleService.getArticle(id))
      ).subscribe(article => {
        console.log(article);
        this.article = article;
        this.createForm(article);
      });
  }

  createForm(article: Article) {
    this.articleForm = this.formBuilder.group({
      id: article.id,
      title: article.title,
      category: article.category
    });
  }

  onFormSubmit() {
    if (this.articleForm.valid) {
      this.isUpdating = true;
      this.article.title = this.title.value;
      this.article.category = this.category.value;

      this.articleService
        .updateArticle(this.article)
        .subscribe(() => {
          // update dynamic list to display
          this.articleService.getArticlesBehaviorSubject();

          // navigate to list
          this.router.navigate(['/dashboard/article'], {
            relativeTo: this.activatedRoute
          });
        }
      );
    }
  }

  get title() {
    return this.articleForm.get('title');
  }

  get category() {
    return this.articleForm.get('category');
  }
}
