import { Injectable, ViewContainerRef, ComponentFactoryResolver } from '@angular/core';
import { PostItem } from '../models/post-item.model';
import { TechnologyComponent } from '../components/comp-lifecycle/technology/technology.component';
import { ArticlePostComponent } from '../components/comp-lifecycle/article-post/article-post.component';
import { MyPost } from '../models/mypost';

@Injectable({
  providedIn: 'root'
})
export class MypostService {
  constructor(private componentFactoryResolver: ComponentFactoryResolver) {}

  loadComponent(viewContainerRef: ViewContainerRef, postItem: PostItem) {
    const componentFactory = this.componentFactoryResolver.resolveComponentFactory(postItem.component);
    viewContainerRef.clear();
    const componentRef = viewContainerRef.createComponent(componentFactory);
    const myPost: MyPost = componentRef.instance as MyPost;
    myPost.post = postItem.data;
  }

  getAllPosts(): PostItem[] {
    return [
      new PostItem(TechnologyComponent, {
        name: 'Angular',
        description:
          'Angular is a platform that makes it easy to build applications with the web.'
      }),

      new PostItem(TechnologyComponent, {
        name: 'Spring Boot',
        description:
          'Spring Boot makes it easy to create stand-alone, production-grade applications.'
      }),

      new PostItem(ArticlePostComponent, {
        sn: '1',
        title: 'Angular Routing and Navigation',
        category: 'Angular'
      }),

      new PostItem(ArticlePostComponent, {
        sn: '2',
        title: 'Angular Template Reference Variable',
        category: 'Angular'
      }),

      new PostItem(ArticlePostComponent, {
        sn: '3',
        title: 'Spring Boot Custom Banner',
        category: 'Spring Boot'
      }),

      new PostItem(ArticlePostComponent, {
        sn: '4',
        title: 'Spring Boot Change Default Server Port',
        category: 'Spring Boot'
      })
    ];
  }
}
