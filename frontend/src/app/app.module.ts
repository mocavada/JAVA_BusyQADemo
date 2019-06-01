import {BrowserModule} from '@angular/platform-browser';
import {NgModule, NO_ERRORS_SCHEMA} from '@angular/core';

import {AppComponent} from './app.component';
import {DemoTypescriptComponent} from './course/typescript/demo-typescript/demo-typescript.component';

// DataShare
import {DemoDatashareComponent} from './course/datashare/demo-datashare/demo-datashare.component';
import {DemoDataShareInputComponent} from './course/datashare/demo-datashare-input/demo-datashare-input.component';
import {DemoDataShareOutputComponent} from './course/datashare/demo-datashare-output/demo-datashare-output.component';
import {DemoDataShareViewchildComponent} from './course/datashare/demo-datashare-viewchild/demo-datashare-viewchild.component';

// Pipe
import {CapitalizePipe} from './course/pipe/capitalize/capitalize.pipe';
import {BonusPipe} from './course/pipe/bonuspipe/bonus.pipe';
import {DemoPipeComponent} from './course/pipe/demo-pipe/demo-pipe.component';

// Routing
import {AppRoutingModule} from './/app-routing.module';
import {DemoRoutingParametersComponent} from './course/route/demo-routing-parameters/demo-routing-parameters.component';

// Directive
import {DemoDirectiveBuildinComponent} from './course/directive/demo-directive-buildin/demo-directive-buildin.component';
import {UnlessDirective} from './course/directive/directive/unless.directive';
import {DemoDirectiveStructuralComponent} from './course/directive/demo-directive-structural/demo-directive-structural.component';
import {HighlightDirective} from './course/directive/directive/highlight.directive';
import {DemoDirectiveAttributeComponent} from './course/directive/demo-directive-attribute/demo-directive-attribute.component';
import {DemoDatabindComponent} from './course/databind/demo-databind/demo-databind.component';

// Form
import {ReactiveFormsModule} from '@angular/forms';
import {FormsModule} from '@angular/forms';
import {DemoFormNgmodelComponent} from './course/form/demo-form-ngmodel/demo-form-ngmodel.component';
import {DemoFormTemplateComponent} from './course/form/demo-form-template/demo-form-template.component';
import {DemoFormModelComponent} from './course/form/demo-form-model/demo-form-model.component';


// Service
import {DatashareService} from './course/datashare-service/service/datashare.service';
// tslint:disable-next-line:max-line-length
import {DemoDatashareSiblingTargetComponent} from './course/datashare-service/demo-datashare-sibling-target/demo-datashare-sibling-target.component';
import {DemoDatashareSiblingComponent} from './course/datashare-service/demo-datashare-sibling/demo-datashare-sibling.component';
import {DemoSubjectComponent} from './course/rxjs/demo-subject/demo-subject.component';

// HttpClient
import {DemoHttpclientComponent} from './course/http/demo-httpclient/demo-httpclient.component';
import {HttpClientModule} from '@angular/common/http';
import {DemoHtmlcssComponent} from './course/htmlcss/demo-htmlcss/demo-htmlcss.component';

// Test
import {TestJasmineMockSpyComponent} from './course-test/test-jasmine-mock-spy/test-jasmine-mock-spy.component';
import {TestAuthService} from './course-test/service/test-auth.service';
import {TestAngularbedComponent} from './course-test/test-angularbed/test-angularbed.component';
import {TestAsyncComponent} from './course-test/test-async/test-async.component';
import {TestComponentComponent} from './course-test/test-component/test-component.component';
import {TestFormModelComponent} from './course-test/test-form-model/test-form-model.component';
import {TestExpectComponent} from './course-test/test-expect/test-expect.component';

// CourseWork
import {CwFinancialToolComponent} from './coursework/cw-financial-tool/cw-financial-tool.component';
import {CwFinancialMultipleComponent} from './coursework/cw-financial-multiple/cw-financial-multiple.component';
import {CwTodolistComponent} from './coursework/cw-todolist/cw-todolist.component';


// project-guestbook
import {GuestbookUiComponent} from './project-guestbook/guestbook-ui/guestbook-ui.component';

// project-upload
import {DetailsUploadComponent} from './upload/details-upload/details-upload.component';
import {FormUploadComponent} from './upload/form-upload/form-upload.component';
import {ListUploadComponent} from './upload/list-upload/list-upload.component';
import {UploadFileService} from './upload/upload-file.service';
import {UploadDemoComponent} from './upload-demo/upload-demo.component';

// project-jobbank
import {JobpostComponent} from './project-jobbank/jobpost/jobpost.component';
import {JoblistComponent} from './project-jobbank/joblist/joblist.component';
import {JobUserLoginComponent} from './project-jobbank/job-user-login/job-user-login.component';

import {ExpCookieSessionComponent} from './exp-cookie-session/exp-cookie-session.component';
import {DemoObserverComponent} from './course/rxjs/demo-observer/demo-observer.component';
import {DemoOperatorsComponent} from './course/rxjs/demo-operators/demo-operators.component';
import {DemoFromeventComponent} from './course/rxjs/demo-fromevent/demo-fromevent.component';
import {DemoHttpserviceComponent} from './course/http/demo-httpservice/demo-httpservice.component';
import {CwFinancialSubComponent} from './coursework/cw-financial-sub/cw-financial-sub.component';
import {CompoundInterestDirective} from './coursework/cw-financial-util/compound-interest.directive';
import {CompoundInterestInputDirective} from './coursework/cw-financial-util/compound-interest-input.directive';
import {DemoPromiseComponent} from './course/rxjs/demo-promise/demo-promise.component';

import {MultiplyDirective} from './course/directive/directive/multiply.directive';
import {AutoSizeInputModule} from 'ngx-autosize-input';


// @ts-ignore
@NgModule({
  // a list of the component in this module
  declarations: [

    AppComponent,

    // Basic
    DemoTypescriptComponent,
    DemoDatabindComponent,

    // DataShare
    DemoDataShareInputComponent,
    DemoDataShareOutputComponent,
    DemoDataShareViewchildComponent,
    DemoDatashareComponent,

    // Pipe
    CapitalizePipe,
    BonusPipe,
    DemoPipeComponent,

    // Directive
    DemoDirectiveBuildinComponent,
    UnlessDirective,
    MultiplyDirective,
    DemoDirectiveStructuralComponent,
    HighlightDirective,
    DemoDirectiveAttributeComponent,
    DemoRoutingParametersComponent,

    // Form
    DemoFormNgmodelComponent,
    DemoFormTemplateComponent,
    DemoFormModelComponent,

    // DataShare Service
    DemoDatashareSiblingTargetComponent,
    DemoDatashareSiblingComponent,
    DemoSubjectComponent,

    // HttpClient
    DemoHttpclientComponent,
    DemoHtmlcssComponent,

    // Test
    TestJasmineMockSpyComponent,
    TestAngularbedComponent,
    TestAsyncComponent,
    TestComponentComponent,
    TestFormModelComponent,


    // Login
    ExpCookieSessionComponent,

    // Rxjs
    DemoPromiseComponent,
    DemoObserverComponent,
    DemoOperatorsComponent,
    DemoFromeventComponent,
    DemoHttpserviceComponent,

    // Coursework
    CwFinancialSubComponent,
    CompoundInterestDirective,
    CompoundInterestInputDirective,

    // Coursework
    CwFinancialToolComponent,
    CwFinancialMultipleComponent,
    CwTodolistComponent,

    // Project-jobbank
    JobpostComponent,
    JoblistComponent,
    JobUserLoginComponent,

    // Project-guestbook
    GuestbookUiComponent,

    // Project-uploadpicture
    DetailsUploadComponent,
    FormUploadComponent,
    ListUploadComponent,
    UploadDemoComponent


  ],
  schemas: [
    NO_ERRORS_SCHEMA
  ],
  // exported and use in another module
  exports: [],

  // imported from other modules
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AutoSizeInputModule

  ],

  // define service for injector
  providers: [DatashareService, TestAuthService],

  // root component to load into browser
  bootstrap: [AppComponent]
})
export class AppModule {
}
