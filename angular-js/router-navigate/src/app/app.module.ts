import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { MatCommonModule, MatNativeDateModule } from '@angular/material/core';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table';
import { MatRadioModule } from '@angular/material/radio';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { GlobalErrorComponent } from './components/global-error/global-error.component';
import { GlobalErrorHandlerService } from './services/global-error-handler.service';
import { DashboardLayoutComponent } from './components/dashboard-layout/dashboard-layout.component';
import { AuthModule } from './authentication/auth.module';
import { LogoutComponent } from './authentication/logout/logout.component';
import { SharedModule } from './shared/shared.module';
import { CityComponent } from './components/city/city.component';
import { CityListComponent } from './components/city/city-list/city-list.component';
import { TeamComponent } from './components/team/team.component';
import { RequestsComponent } from './http-interceptors/requests/requests.component';
import { RouterModule } from '@angular/router';
import { httpInterceptorProviders } from './http-interceptors';
import { AjaxBusyIndicatorDirective } from './http-interceptors/ajaxBusyInterceptor/ajax-busy-indicator.directive';
import { MsgComponent } from './components/city/msg/msg.component';
import { MsgCountryComponent } from './components/city/msg-country/msg-country.component';
import { AliasComponent } from './components/city/alias/alias.component';
import { CaseComponent } from './components/city/case/case.component';
import { TextsizeComponent } from './components/city/textsize/textsize.component';
import { UppercaseComponent } from './components/city/uppercase/uppercase.component';
import { SelectboxComponent } from './components/city/selectbox/selectbox.component';
import { EmpTagComponent } from './components/city/emp-tag/emp-tag.component';
import { CustomDirectivesComponent } from './components/custom-directives/custom-directives.component';
import { RedDirective } from './components/custom-directives/directives/red.directive';
import { ThemeDirective } from './components/custom-directives/directives/theme.directive';
import { TextSizeDirective } from './components/custom-directives/directives/text-size.directive';
import { ColorInputDirective } from './components/custom-directives/directives/color-input.directive';
import { CustomThemeDirective } from './components/custom-directives/directives/custom-theme.directive';
import { DynamicColorDirective } from './components/custom-directives/directives/dynamic-color.directive';
import { MouseDirective } from './components/custom-directives/directives/mouse.directive';
import { CpDelayDirective } from './components/custom-directives/directives/cp-delay.directive';
import { CpIfDirective } from './components/custom-directives/directives/cp-if.directive';
import { CpLoopDirective } from './components/custom-directives/directives/cp-loop.directive';
import { NgifThenElseComponent } from './components/custom-directives/ngif-then-else/ngif-then-else.component';
import { PersonService } from './services/person.service';
import { ViewchildComponent } from './components/viewchild/viewchild.component';
import { NumberComponent } from './components/viewchild/number/number.component';
import { NumberParentComponent } from './components/viewchild/number-parent/number-parent.component';
import { CpcolorParentComponent } from './components/viewchild/cpcolor-parent/cpcolor-parent.component';
import { CpcolorDirective } from './components/viewchild/cpcolor-parent/cpcolor.directive';
import { CpthemeComponent } from './components/viewchild/cptheme/cptheme.component';
import { BookDirective } from './components/viewchild/directives/book.directive';
import { WriterComponent } from './components/viewchild/writer/writer.component';
import { FavouriteBooksComponent } from './components/viewchild/favourite-books/favourite-books.component';
import { FavouriteCitiesComponent } from './components/viewchild/favourite-cities/favourite-cities.component';
import { FavouriteFriendsComponent } from './components/viewchild/favourite-friends/favourite-friends.component';
import { City2Component } from './components/viewchild/city2/city2.component';
import { FriendComponent } from './components/viewchild/friend/friend.component';
import { Address2Component } from './components/viewchild/address2/address2.component';
import { VcDemo1Component } from './components/viewchild/vc-demo1/vc-demo1.component';
import { VcDemo2Component } from './components/viewchild/vc-demo2/vc-demo2.component';
import { VcDemo3Component } from './components/viewchild/vc-demo3/vc-demo3.component';
import { MessageDirective } from './components/viewchild/directives/message.directive';
import { Writer2Component } from './components/viewchild/writer2/writer2.component';
import { PipesComponent } from './components/pipes/pipes.component';
import { CustomPipeComponent } from './components/pipes/custom-pipe/custom-pipe.component';
import { WelcomePipe } from './components/pipes/define/welcome.pipe';
import { StrformatPipe } from './components/pipes/define/strformat.pipe';
import { DivisionPipe } from './components/pipes/define/division.pipe';
import { MyjsonPipe } from './components/pipes/define/myjson.pipe';
import { MyuppercaseonePipe } from './components/pipes/define/myuppercaseone.pipe';
import { MyuppercasetwoPipe } from './components/pipes/define/myuppercasetwo.pipe';
import { CompanytwoPipe } from './components/pipes/define/companytwo.pipe';
import { CompanyonePipe } from './components/pipes/define/companyone.pipe';
import { RepeatPipe } from './components/pipes/define/repeat.pipe';
import { CompLifecycleComponent } from './components/comp-lifecycle/comp-lifecycle.component';
import { PersonCompComponent } from './components/comp-lifecycle/person-comp/person-comp.component';
import { CompanyCompComponent } from './components/comp-lifecycle/company-comp/company-comp.component';
import { AddressCompComponent } from './components/comp-lifecycle/address-comp/address-comp.component';
import { PostBannerComponent } from './components/comp-lifecycle/post-banner/post-banner.component';
import { MyPostComponent } from './components/comp-lifecycle/my-post/my-post.component';
import { ArticlePostComponent } from './components/comp-lifecycle/article-post/article-post.component';
import { TechnologyComponent } from './components/comp-lifecycle/technology/technology.component';
import { MypostService } from './services/mypost.service';
import { MyPostDirective } from './components/comp-lifecycle/mypost.directive';
import { ChangeSimplechangeComponent } from './components/comp-lifecycle/change-simplechange/change-simplechange.component';
import { AppEmpComponent } from './components/comp-lifecycle/change-simplechange/app-emp.component';
import { LifeCompComponent } from './components/comp-lifecycle/life-comp/life-comp.component';
import { CompDirective } from './components/comp-lifecycle/life-comp/comp.directive';
import { Comp1Component } from './components/comp-lifecycle/life-comp/comp1.component';
import { Comp2Component } from './components/comp-lifecycle/life-comp/comp2.component';
import { CounterComponent } from './components/comp-lifecycle/life-comp/counter.component';
import { AfterViewInitComponent } from './components/comp-lifecycle/after-view-init/after-view-init.component';
import { MessageAfterDirective } from './components/comp-lifecycle/after-view-init/message-after.directive';
import { MessageAfterComponent } from './components/comp-lifecycle/after-view-init/message-after.component';
import { LifecycleHookComponent } from './components/comp-lifecycle/after-view-init/lifecycle-hook.component';
import { AfterViewInitDemoComponent } from './components/comp-lifecycle/after-view-init/after-view-init-demo.component';
import { KeyvalueDiffersComponent } from './components/comp-lifecycle/keyvalue-differs/keyvalue-differs.component';
import { EmployeeDiffersComponent } from './components/comp-lifecycle/keyvalue-differs/employee-differs.component';
import { NbClassDirective } from './components/comp-lifecycle/keyvalue-differs/nb-class.directive';
import { DoCheckComponent } from './components/comp-lifecycle/do-check/do-check.component';
import { EmployeeITRDiffComponent } from './components/comp-lifecycle/do-check/employee-itrdiff.component';
import { EmployeeKVDiffComponent } from './components/comp-lifecycle/do-check/employee-kvdiff.component';
import { AppProvidersComponent } from './components/comp-lifecycle/app-providers/app-providers.component';
import { AnyAnimalComponent } from './components/comp-lifecycle/app-providers/any-animal.component';
import { AnimalDetailsComponent } from './components/comp-lifecycle/app-providers/animal-details.component';
import { ComputerComponent } from './components/comp-lifecycle/app-providers/computer.component';
import { LionComponent } from './components/comp-lifecycle/app-providers/lion.component';
import { BookaComponent } from './components/comp-lifecycle/app-providers/booka.component';
import { PreBookComponent } from './components/comp-lifecycle/app-providers/pre-book.component';
import { OptionalComponent } from './components/comp-lifecycle/app-providers/optional.component';
import { XservicesComponent } from './components/xservices/xservices.component';
import { AppRenderer2Component } from './components/xservices/app-renderer2/app-renderer2.component';
import { AppendDemoComponent } from './components/xservices/app-renderer2/append-demo.component';
import { ListenDemoComponent } from './components/xservices/app-renderer2/listen-demo.component';
import { ZappCpComponent } from './components/xservices/app-renderer2/zapp-cp.component';
import { Cp1Directive } from './components/xservices/directives/cp1.directive';
import { Cp2Directive } from './components/xservices/directives/cp2.directive';
import { Cp3Directive } from './components/xservices/directives/cp3.directive';
import { Cp4Directive } from './components/xservices/directives/cp4.directive';
import { Cp5Directive } from './components/xservices/directives/cp5.directive';
import { Cp6Directive } from './components/xservices/directives/cp6.directive';
import { Cp7Directive } from './components/xservices/directives/cp7.directive';
import { Cp8Directive } from './components/xservices/directives/cp8.directive';
import { Cp9Directive } from './components/xservices/directives/cp9.directive';
import { Cp10Directive } from './components/xservices/directives/cp10.directive';
import { Cp11Directive } from './components/xservices/directives/cp11.directive';
import { MetaTagsComponent } from './components/xservices/meta-tags/meta-tags.component';
import { TitleCanonicalComponent } from './components/xservices/title-canonical/title-canonical.component';
import { AppNgRxComponent } from './components/app-ng-rx/app-ng-rx.component';
import { NgrxStoreComponent } from './components/app-ng-rx/ngrx-store/ngrx-store.component';
import { StoreModule } from '@ngrx/store';
// import { reducers2, metaReducers2 } from './components/app-ng-rx/ngrx-effects/reducers/reducers2';
import { reducers, metaReducers } from './components/app-ng-rx/ngrx-store/reducers/reducer';
import { NgrxEffectsComponent } from './components/app-ng-rx/ngrx-effects/ngrx-effects.component';
import { EffectsModule } from '@ngrx/effects';
import { InMemoryWebApiModule } from 'angular-in-memory-web-api';
import { TestData2 } from './components/app-ng-rx/ngrx-effects/test-data2';
import { Article2Effects } from './components/app-ng-rx/ngrx-effects/effects/article2.effects';
import { Article2Service } from './components/app-ng-rx/ngrx-effects/services/article2.service';
import { MaterialsComponent } from './components/materials/materials.component';
import { McheckboxComponent } from './components/materials/mcheckbox/mcheckbox.component';
import { MdCheckboxDemoComponent } from './components/materials/mcheckbox/md-checkbox-demo';
import { ReactiveFormComponent } from './components/materials/mcheckbox/reactive-form.component';
import { TemplateDrivenFormComponent } from './components/materials/mcheckbox/template-driven-form.component';
import { MtableComponent } from './components/materials/mtable/mtable.component';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MtbArticleComponent } from './components/materials/mtable/mtb-article.component';
import { MTextareaComponent } from './components/materials/m-textarea/m-textarea.component';
import { TemplateDrivenFormTxareaComponent } from './components/materials/m-textarea/template-driven-form-txarea.component';
import { ReactiveFormTxareaComponent } from './components/materials/m-textarea/reactive-form-txarea.component';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MRadioComponent } from './components/materials/m-radio/m-radio.component';
import { ReactiveFormRadioComponent } from './components/materials/m-radio/reactive-form-radio.component';
import { TemplateDrivenFormRadioComponent } from './components/materials/m-radio/template-driven-form-radio.component';
import { MToggleComponent } from './components/materials/m-toggle/m-toggle.component';
import { ReactiveFormToggleComponent } from './components/materials/m-toggle/reactive-form-toggle.component';
import { TemplateDrivenFormToggleComponent } from './components/materials/m-toggle/template-driven-form-toggle.component';
import { ArticleSpringComponent } from './components/article-spring/article-spring.component';
import { ArticleSpringService } from './services/article-spring.service';

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AuthModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    RouterModule,
    SharedModule.forRoot(),
    // InMemoryWebApiModule.forRoot(UserData),
    ToastrModule.forRoot(),
    StoreModule.forRoot(reducers, {metaReducers}),
    // StoreModule.forRoot(reducers2, {metaReducers2}), // open comment after checking
    EffectsModule.forRoot([Article2Effects]),
    // InMemoryWebApiModule.forRoot(TestData2), // comment this line to test angular-springboot

    // Material module
    MatCommonModule,
    MatCheckboxModule,
    MatButtonModule,
    MatInputModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatNativeDateModule,

    MatFormFieldModule,
    MatSelectModule,
    MatRadioModule,
    MatSlideToggleModule
  ],
  declarations: [
    AppComponent,
    PageNotFoundComponent,
    GlobalErrorComponent,

    DashboardLayoutComponent,
    LogoutComponent,
    CityComponent,
    CityListComponent,
    TeamComponent,
    RequestsComponent,
    AjaxBusyIndicatorDirective,
    MsgComponent,
    MsgCountryComponent,
    AliasComponent,
    CaseComponent,
    TextsizeComponent,
    UppercaseComponent,
    SelectboxComponent,
    EmpTagComponent,
    CustomDirectivesComponent,
    RedDirective,
    ThemeDirective,
    TextSizeDirective,
    ColorInputDirective,
    CustomThemeDirective,
    DynamicColorDirective,
    MouseDirective,
    CpDelayDirective,
    CpIfDirective,
    CpLoopDirective,
    NgifThenElseComponent,
    ViewchildComponent,
    NumberComponent,
    NumberParentComponent,
    CpcolorDirective,
    CpcolorParentComponent,
    CpthemeComponent,
    BookDirective,
    WriterComponent,
    FavouriteBooksComponent,
    FavouriteCitiesComponent,
    FavouriteFriendsComponent,
    City2Component,
    FriendComponent,
    Address2Component,
    VcDemo1Component,
    VcDemo2Component,
    VcDemo3Component,
    MessageDirective,
    Writer2Component,
    PipesComponent,
    CustomPipeComponent,
    WelcomePipe,
    StrformatPipe,
    DivisionPipe,
    MyjsonPipe,
    MyuppercaseonePipe,
    MyuppercasetwoPipe,
    CompanytwoPipe,
    CompanyonePipe,
    RepeatPipe,
    CompLifecycleComponent,
    PersonCompComponent,
    CompanyCompComponent,
    AddressCompComponent,
    PostBannerComponent,
    MyPostComponent,
    ArticlePostComponent,
    TechnologyComponent,
    MyPostDirective,
    ChangeSimplechangeComponent,
    AppEmpComponent,
    LifeCompComponent,
    CompDirective,
    Comp1Component,
    Comp2Component,
    CounterComponent,
    AfterViewInitComponent,
    MessageAfterDirective,
    MessageAfterComponent,
    LifecycleHookComponent,
    AfterViewInitDemoComponent,
    KeyvalueDiffersComponent,
    EmployeeDiffersComponent,
    NbClassDirective,
    DoCheckComponent,
    EmployeeITRDiffComponent,
    EmployeeKVDiffComponent,
    AppProvidersComponent,
    AnyAnimalComponent,
    AnimalDetailsComponent,
    LionComponent,
    ComputerComponent,
    BookaComponent,
    PreBookComponent,
    OptionalComponent,
    XservicesComponent,
    AppRenderer2Component,
    AppendDemoComponent,
    ListenDemoComponent,
    ZappCpComponent,
    Cp1Directive,
    Cp2Directive,
    Cp3Directive,
    Cp4Directive,
    Cp5Directive,
    Cp6Directive,
    Cp7Directive,
    Cp8Directive,
    Cp9Directive,
    Cp10Directive,
    Cp11Directive,
    MetaTagsComponent,
    TitleCanonicalComponent,

    // NgRx
    AppNgRxComponent,
    NgrxStoreComponent,
    NgrxEffectsComponent,

    // Material
    MaterialsComponent,
    McheckboxComponent,
    MdCheckboxDemoComponent,
    ReactiveFormComponent,
    TemplateDrivenFormComponent,
    MtableComponent,
    MtbArticleComponent,
    MTextareaComponent,
    ReactiveFormTxareaComponent,
    TemplateDrivenFormTxareaComponent,
    MRadioComponent,
    ReactiveFormRadioComponent,
    TemplateDrivenFormRadioComponent,
    MToggleComponent,
    ReactiveFormToggleComponent,
    TemplateDrivenFormToggleComponent,
    ArticleSpringComponent
  ],
  entryComponents: [
    ArticlePostComponent,
    TechnologyComponent
  ],
  providers: [
    GlobalErrorHandlerService,
    { provide: ErrorHandler, useClass: GlobalErrorHandlerService },
    httpInterceptorProviders,
    PersonService,
    MypostService,
    Article2Service,
    ArticleSpringService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
