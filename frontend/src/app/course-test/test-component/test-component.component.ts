import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-test-component',
  templateUrl: './test-component.component.html',
  styleUrls: ['./test-component.component.css']
})
export class TestComponentComponent implements OnInit {
  @Output() loggedIn = new EventEmitter<User>();
  enabled = true;

  @ViewChild('submitButton', { read: ElementRef }) submitButton: ElementRef;

  constructor() { }

  ngOnInit() {

  }

  login(email, password) {
    console.log('Login ${email} ${password}');
    if (email && password) {
      console.log('Emitting');
      this.loggedIn.emit(new User(email, password));

      this.submitButton.nativeElement.style.backgroundColor = 'green';
    }
  }
}

export class User {
  constructor(public email: string, public password: string) {
  }
}
