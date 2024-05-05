import { Component, OnInit, Input } from '@angular/core';
import { MyPost } from 'src/app/models/mypost';

@Component({
  selector: 'app-article-post',
  templateUrl: './article-post.component.html',
  styleUrls: ['../comp-lifecycle.component.scss'],
})
export class ArticlePostComponent implements MyPost {

  @Input() post: any;

  constructor() { }

}
