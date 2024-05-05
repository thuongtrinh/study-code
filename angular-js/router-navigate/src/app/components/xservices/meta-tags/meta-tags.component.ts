import { Component, OnInit } from '@angular/core';
import { SeoService } from 'src/app/services/seo.service';

@Component({
  selector: 'app-meta-tags',
  templateUrl: './meta-tags.component.html',
})
export class MetaTagsComponent implements OnInit {

  constructor(private seoService: SeoService) { }

  ngOnInit() {
    this.addMetaTags();
  }

  addMetaTags() {
    this.seoService.addMetaTags();
  }

  getMetaTags() {
    this.seoService.getMetaTag();
  }

  updateMetaTags() {
    this.seoService.updateMetaTags();
  }

  removeMetaTags() {
    this.seoService.removeMetaTags();
  }
}
