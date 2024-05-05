import { Component, OnInit, ViewChild, AfterViewInit, OnDestroy } from '@angular/core';
import { MyPostDirective } from '../mypost.directive';
import { MyPostComponent } from '../my-post/my-post.component';
import { MypostService } from 'src/app/services/mypost.service';
import { PostItem } from 'src/app/models/post-item.model';

@Component({
  selector: 'app-post-banner',
  templateUrl: './post-banner.component.html',
})
export class PostBannerComponent implements OnInit, AfterViewInit, OnDestroy {

  @ViewChild(MyPostDirective, {static: false})
  private myPostDirective: MyPostDirective;

  @ViewChild(MyPostComponent, {static: false})
  private myPostComponent: MyPostComponent;

  postItems: PostItem[];
  intervalId: any;
  postIndex = -1;

  constructor(private myPostService: MypostService) { }

  ngOnInit() {
  }

  ngAfterViewInit(): void {
    this.postItems = this.myPostService.getAllPosts();
    this.startPostHighlights();
  }

  startPostHighlights() {
    this.intervalId = setInterval(() => {
      this.postIndex = (this.postIndex === this.postItems.length - 1) ? 0 : this.postIndex + 1;

      // Use viewContainerRef from Directive
      this.myPostService.loadComponent(this.myPostDirective.viewContainerRef,
        this.postItems[this.postIndex]);

      // Use viewContainerRef from Component
      this.myPostService.loadComponent(this.myPostComponent.viewContainerRef,
        this.postItems[this.postIndex]);
    }, 2000);

  }

  ngOnDestroy(): void {
    clearInterval(this.intervalId);
  }
}
