import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { ArticleMService } from './articleM.service';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-mtb-article',
  templateUrl: './mtb-article.component.html',
})
export class MtbArticleComponent implements OnInit {

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  @ViewChild(MatPaginator, {static: true}) paginator: MatPaginator;

  displayedColumns: string[] = ['id', 'title', 'category', 'writer'];
  dataSource = new MatTableDataSource(this.articleMService.getAllArticles());

  constructor(private articleMService: ArticleMService) { }

  ngOnInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
  }
}
