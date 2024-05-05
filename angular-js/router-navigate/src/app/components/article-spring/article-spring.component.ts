import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ArticleSpringModel } from 'src/app/models/article-spring.model';
import { ArticleSpringService } from 'src/app/services/article-spring.service';

@Component({
  selector: 'app-article-spring',
  templateUrl: './article-spring.component.html',
  styleUrls: ['./article-spring.component.scss'],
})
export class ArticleSpringComponent implements OnInit {

  // Component properties
  allArticles: ArticleSpringModel[];
  statusCode: number;
  requestProcessing = false;
  articleIdToUpdate = null;
  processValidation = false;

  // Create form
  articleForm = new FormGroup({
    title: new FormControl('', Validators.required),
    category: new FormControl('', Validators.required),
  });

  // Create constructor to get service instance
  constructor(private articleSpringService: ArticleSpringService) {}

  // Create ngOnInit() and and load articles
  ngOnInit(): void {
    this.getAllArticles();
  }

  // Fetch all articles
  getAllArticles() {
    this.articleSpringService.getAllArticles().subscribe(
      (data) => (this.allArticles = data),
      (errorCode) => (this.statusCode = errorCode)
    );
  }

  // Handle create and update article
  onArticleFormSubmit() {
    this.processValidation = true;
    if (this.articleForm.invalid) {
      return; // Validation failed, exit from method.
    }

    // Form is valid, now perform create or update
    this.preProcessConfigurations();
    let title = this.articleForm.get('title').value.trim();
    let category = this.articleForm.get('category').value.trim();

    if (this.articleIdToUpdate === null) {
      // Handle create article
      let article = new ArticleSpringModel(null, title, category);
      this.articleSpringService.createArticle(article).subscribe(
        (successCode) => {
          // this.statusCode = successCode;
          this.getAllArticles();
          this.backToCreateArticle();
        },
        (errorCode) => (this.statusCode = errorCode)
      );
    } else {
      // Handle update article
      let article = new ArticleSpringModel(this.articleIdToUpdate, title, category);
      this.articleSpringService.updateArticle(article).subscribe(
        (successCode) => {
          this.statusCode = successCode;
          this.getAllArticles();
          this.backToCreateArticle();
        },
        (errorCode) => (this.statusCode = errorCode)
      );
    }
  }

  // Load article by id to edit
  loadArticleToEdit(articleId: string) {
    this.preProcessConfigurations();
    this.articleSpringService.getArticleById(articleId).subscribe(
      (article) => {
        this.articleIdToUpdate = article.articleId;
        this.articleForm.setValue({
          title: article.title,
          category: article.category,
        });
        this.processValidation = true;
        this.requestProcessing = false;
      },
      (errorCode) => (this.statusCode = errorCode)
    );
  }

  // Delete article
  deleteArticle(articleId: string) {
    this.preProcessConfigurations();
    this.articleSpringService.deleteArticleById(articleId).subscribe(
      (successCode) => {
        // this.statusCode = successCode;
        this.getAllArticles();
        this.backToCreateArticle();
      },
      (errorCode) => (this.statusCode = errorCode)
    );
  }

  // Perform preliminary processing configurations
  preProcessConfigurations() {
    this.statusCode = null;
    this.requestProcessing = true;
  }

  // Go back from update to create
  backToCreateArticle() {
    this.articleIdToUpdate = null;
    this.articleForm.reset();
    this.processValidation = false;
  }
}
