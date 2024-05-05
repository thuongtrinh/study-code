import { Injectable, Inject } from '@angular/core';
import { Meta, Title } from '@angular/platform-browser';
import { DOCUMENT } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class SeoService {

  constructor(private meta: Meta, private title: Title, @Inject(DOCUMENT) private doc) {
      meta.addTag({name: 'description', content: 'Title and Meta tags examples'});
      meta.addTag({name: 'viewport', content: 'width=device-width,initial-scale=1'});
  }

  // ------1. Angular Meta Service for Meta Tags------
  addMetaTags() {
      this.meta.addTags([
        {name: 'robots', content: 'INDEX, FOLLOW'},
        {name: 'author', content: 'ABCD'},
        {name: 'keywords', content: 'TypeScript, Angular'},
        {name: 'date', content: '2018-06-02', scheme: 'YYYY-MM-DD'},
        {httpEquiv: 'Content-Type', content: 'text/html'},
        {property: 'og:title', content: 'My Text'},
        {property: 'og:type', content: 'website'},
        {charset: 'UTF-8'}
      ]);
  }

  getMetaTag() {
      const metaEL: HTMLMetaElement = this.meta.getTag('name="keywords"');
      console.log(metaEL);
      console.log(metaEL.name);
      console.log(metaEL.content);

      const els: HTMLMetaElement[] = this.meta.getTags('name');
      els.forEach(el => {
        console.log(el);
        console.log(el.name);
        console.log(el.content);
      });
    }

    updateMetaTags() {
        this.meta.updateTag({name: 'description', content: 'Updated: Title and Meta tags examples'});
        this.meta.updateTag({httpEquiv: 'Content-Type', content: 'application/json'}, 'httpEquiv= "Content-Type"');
        this.meta.updateTag({name: 'robots', content: 'NOINDEX, NOFOLLOW'});
        this.meta.updateTag({name: 'keywords', content: 'JavaScript, Angular'});
        this.meta.updateTag({name: 'date', content: '2018-06-03', scheme: 'YYYY-MM-DD'});
        this.meta.updateTag({name: 'author', content: 'VXYZ'});
        this.meta.updateTag({charset: 'UTF-16'}, 'charset= "UTF-8"');
        this.meta.updateTag({property: 'og:title', content: 'My Text2'});
        this.meta.updateTag({property: 'og:type', content: 'website'});
    }

    removeMetaTags() {
      // Using removeTag
      this.meta.removeTag('name = "description"');
      this.meta.removeTag('name= "keywords"');
      this.meta.removeTag('name = "viewport"');
      this.meta.removeTag('name = "robots"');

      // Using removeTagElement
      const author: HTMLMetaElement = this.meta.getTag('name = "author"');
      this.meta.removeTagElement(author);
      const date: HTMLMetaElement = this.meta.getTag('name = "date"');
      this.meta.removeTagElement(date);
      const contentType: HTMLMetaElement = this.meta.getTag('httpEquiv = "Content-Type"');
      this.meta.removeTagElement(contentType);
      const charset: HTMLMetaElement = this.meta.getTag('charset');
      this.meta.removeTagElement(charset);
      const ogTitle: HTMLMetaElement = this.meta.getTag('property = "og:title"');
      this.meta.removeTagElement(ogTitle);
      const ogType: HTMLMetaElement = this.meta.getTag('property = "og:type"');
      this.meta.removeTagElement(ogType);
  }

  // ------2. Angular Title Service and Canonical URL------
  setPageTitle(title: string) {
    this.title.setTitle(title);
  }

  getPageTitle() {
      return this.title.getTitle();
  }

  createLinkForCanonicalURL() {
      const link: HTMLLinkElement = this.doc.createElement('link');
      link.setAttribute('rel', 'canonical');
      this.doc.head.appendChild(link);
      link.setAttribute('href', this.doc.URL);
  }
}
