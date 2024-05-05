import { Component, OnInit } from '@angular/core';
import { SeoService } from 'src/app/services/seo.service';

@Component({
  selector: 'app-title-canonical',
  templateUrl: './title-canonical.component.html',
})
export class TitleCanonicalComponent implements OnInit {

  pageTitle: string;

  constructor(private seoService: SeoService) { }

  ngOnInit() {
    this.setPageTitle('This is page title');
    this.createLinkForCanonicalURL();
  }

  setPageTitle(title: string) {
    this.seoService.setPageTitle(title);
  }

  getPageTitle() {
    this.pageTitle = this.seoService.getPageTitle();
  }

  createLinkForCanonicalURL() {
    this.seoService.createLinkForCanonicalURL();
  }
}
