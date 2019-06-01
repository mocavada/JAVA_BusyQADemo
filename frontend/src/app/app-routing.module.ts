import {ExpCookieSessionComponent} from './exp-cookie-session/exp-cookie-session.component';
import {LoggedInGuard} from './project-jobbank/service/logged-in.guard';

import {CwTodolistComponent} from './coursework/cw-todolist/cw-todolist.component';
import {DemoHtmlcssComponent} from './course/htmlcss/demo-htmlcss/demo-htmlcss.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {DemoHttpclientComponent} from './course/http/demo-httpclient/demo-httpclient.component';
import {DemoSubjectComponent} from './course/rxjs/demo-subject/demo-subject.component';
import {DemoFormModelComponent} from './course/form/demo-form-model/demo-form-model.component';
import {DemoFormTemplateComponent} from './course/form/demo-form-template/demo-form-template.component';
import {DemoDatabindComponent} from './course/databind/demo-databind/demo-databind.component';
import {DemoTypescriptComponent} from './course/typescript/demo-typescript/demo-typescript.component';


import {DemoDatashareComponent} from './course/datashare/demo-datashare/demo-datashare.component';
import {DemoPipeComponent} from './course/pipe/demo-pipe/demo-pipe.component';
import {DemoDirectiveBuildinComponent} from './course/directive/demo-directive-buildin/demo-directive-buildin.component';
import {DemoDirectiveAttributeComponent} from './course/directive/demo-directive-attribute/demo-directive-attribute.component';
import {DemoDirectiveStructuralComponent} from './course/directive/demo-directive-structural/demo-directive-structural.component';
import {DemoRoutingParametersComponent} from './course/route/demo-routing-parameters/demo-routing-parameters.component';
import {CwFinancialToolComponent} from './coursework/cw-financial-tool/cw-financial-tool.component';
import {UploadDemoComponent} from './upload-demo/upload-demo.component';

import {JoblistComponent} from './project-jobbank/joblist/joblist.component';
import {JobUserLoginComponent} from './project-jobbank/job-user-login/job-user-login.component';
import {JobpostComponent} from './project-jobbank/jobpost/jobpost.component';
import {DemoObserverComponent} from './course/rxjs/demo-observer/demo-observer.component';
import {DemoOperatorsComponent} from './course/rxjs/demo-operators/demo-operators.component';
import {DemoFromeventComponent} from './course/rxjs/demo-fromevent/demo-fromevent.component';
import {DemoHttpserviceComponent} from './course/http/demo-httpservice/demo-httpservice.component';
import {GuestbookUiComponent} from './project-guestbook/guestbook-ui/guestbook-ui.component';
import {DemoFormNgmodelComponent} from './course/form/demo-form-ngmodel/demo-form-ngmodel.component';
import {CwFinancialMultipleComponent} from './coursework/cw-financial-multiple/cw-financial-multiple.component';
import {DemoPromiseComponent} from './course/rxjs/demo-promise/demo-promise.component';

const routes: Routes = [
  {path: '', redirectTo: '', pathMatch: 'full'},
  {path: 'HtmlCss', component: DemoHtmlcssComponent},
  {path: 'Promise', component: DemoPromiseComponent},
  {path: 'Typescript', component: DemoTypescriptComponent},
  {
    path: 'RxJS', children: [
      {path: 'Observer', component: DemoObserverComponent},
      {path: 'Subject', component: DemoSubjectComponent},
      {path: 'Operators', component: DemoOperatorsComponent},
      {path: 'FromEvent', component: DemoFromeventComponent}
    ]
  },
  {path: 'DataBind', component: DemoDatabindComponent},
  {path: 'DataShare', component: DemoDatashareComponent},
  {path: 'Pipe', component: DemoPipeComponent},
  {path: 'RoutingParameter/:productType/:productId', component: DemoRoutingParametersComponent},
  {path: 'RoutingParameter/:productType/:productId/:option1', component: DemoRoutingParametersComponent},
  {path: 'RoutingParameter/:productType/:productId/:option1/:option2', component: DemoRoutingParametersComponent},
  {
    path: 'Directive', children: [
      {path: 'DirectiveBuildin', component: DemoDirectiveBuildinComponent},
      {path: 'DirectiveStructural', component: DemoDirectiveStructuralComponent},
      {path: 'DirectiveAttribute', component: DemoDirectiveAttributeComponent}
    ]
  },
  {
    path: 'Form', children: [
      {path: 'FormNGModel', component: DemoFormNgmodelComponent},
      {path: 'FormTemplate', component: DemoFormTemplateComponent},
      {path: 'FormModel', component: DemoFormModelComponent}
    ]
  },
  {
    path: 'HTTP', children: [
      {path: 'HttpClient', component: DemoHttpclientComponent},
      {path: 'HttpService', component: DemoHttpserviceComponent},
      {path: 'UploadPic', component: UploadDemoComponent},
    ]
  },
  {
    path: 'CourseWork', children: [
      {path: 'FinancialTool', component: CwFinancialToolComponent},
      {path: 'FinancialToolRefactor', component: CwFinancialMultipleComponent},
      {path: 'TodoList', component: CwTodolistComponent}
    ]
  },
  {path: 'PostJob', component: JobpostComponent , canActivate: [LoggedInGuard]}, // , canActivate: [LoggedInGuard]
  {path: 'JobUserLoginComponent', component: JobUserLoginComponent},
  {path: 'ListJob', component: JoblistComponent},
  {path: 'CheckLogin', component: ExpCookieSessionComponent},
  {path: 'GuestBook', component: GuestbookUiComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
