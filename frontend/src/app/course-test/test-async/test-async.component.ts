import { TestAuthService } from '../service/test-auth.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-test-async',
  templateUrl: './test-async.component.html',
  styleUrls: ['./test-async.component.css']
})
export class TestAsyncComponent implements OnInit {
  needsLogin = true;

  constructor(private auth: TestAuthService) {
  }
  ngOnInit() {
    this.checkLoginStatusAsync();
  }

  checkLoginStatusAsync() {
    this.auth.isAuthenticatedAsync().then((authenticated) => {
      this.needsLogin = !authenticated;
    });
  }

  checkLoginStatusSync(){
    this.needsLogin = !this.auth.isAuthenticated();
  }
}
