import { TestAuthService } from '../service/test-auth.service';
/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { TestJasmineMockSpyComponent } from './test-jasmine-mock-spy.component';
import { log } from 'util';

describe('TestJasmineMockSpyComponent', () => {

  describe('Component: Login', () => {
    // (3) ======== spy
    let component: TestJasmineMockSpyComponent;
    let service: TestAuthService;
    let spy: any;

    beforeEach(() => {
      service = new TestAuthService();
      component = new TestJasmineMockSpyComponent(service);
    });

    afterEach(() => {
      service = null;
      component = null;
    });

    // test must login
    it('(1) canLogin returns false when the user is not authenticated', () => {
      spy = spyOn(service, 'isAuthenticated').and.returnValue(false);
      expect(component.needsLogin()).toBeTruthy();

      expect(service.isAuthenticated).toHaveBeenCalled();
      log('pring out:' + service.isAuthenticated());
    });

    // test not called
    it('(2) test not called method', () => {
      spy = spyOn(service, 'isNotCalled').and.returnValue(false);
      expect(service.isNotCalled).not.toHaveBeenCalled();
    });

    // test no need to login
    it('(3) canLogin returns false when the user is not authenticated', () => {
      spy = spyOn(service, 'isAuthenticated').and.returnValue(true);
      expect(component.needsLogin()).toBeFalsy();
      expect(service.isAuthenticated).toHaveBeenCalled();
    });

    // (2) ======== Mocking with fake classes
    // class MockAuthService {
    //   authenticated = false;
    //   isAuthenticated() {
    //     return this.authenticated;
    //   }
    // }

    // let component: TestJasmineMockSpyComponent;
    // let service: MockAuthService;

    // beforeEach(() => {
    //   service = new MockAuthService();
    //   component = new TestJasmineMockSpyComponent(this.service);
    // });

    // afterEach(() => {
    //   service = null;
    //   component = null;
    // });


    // it('canLogin returns false when the user is not authenticated', () => {
    //   service.authenticated = false;
    //   expect(component.needsLogin()).toBeTruthy();
    // });

    // it('canLogin returns false when the user is not authenticated', () => {
    //   service.authenticated = true;
    //   expect(component.needsLogin()).toBeFalsy();
    // });

    // (1) ======== Testing with the real `AuthService`

    // let component: TestJasmineMockSpyComponent;
    // let service: TestAuthService;

    // beforeEach(() => {
    //   service = new TestAuthService();
    //   component = new TestJasmineMockSpyComponent(service);
    // });

    // afterEach(() => {
    //   localStorage.removeItem('token');
    //   service = null;
    //   component = null;
    // });


    // it('needsLogin returns true when the user is not authenticated', () => {
    //   expect(component.needsLogin()).toBeTruthy();
    // });

    // it('needsLogin returns false when the user is authenticated', () => {
    //   localStorage.setItem('token', '12345');
    //   expect(component.needsLogin()).toBeFalsy();
    // });

  });
});
