import {Component, OnInit} from '@angular/core';
import {resolve} from 'path';
import {promise} from 'protractor';

@Component({
  selector: 'app-demo-promise',
  templateUrl: './demo-promise.component.html',
  styleUrls: ['./demo-promise.component.css']
})
export class DemoPromiseComponent implements OnInit {

  constructor() {
  }

  ngOnInit() {
    console.log(
      // Promise.resolve(true).then(function (value) {
      //   console.log(value);
      //   // expected output: true
      // })
    );


    // this.doWork0();
    // this.doWork1();
    // this.doWork2();
    // this.doWork3();    

    // ========
    // this.doWork4();
    this.doWork5();
    // this.doWork6();

  }

  // make a call to bank => 
  // do laundry =>
  // pick up the phone


  doWork0() {
    (function () {
      console.log('(1) make a call to bank');
      console.log('(2) pick up the phone');
    })();
    console.log('(3) do laundry');
  }

  doWork1() {
    (function () {
      console.log('(1) make a call to bank');

      setTimeout(function () {
        //......
        console.log('(3) pick up the phone');
      }, 10);

    })();

    console.log('(2) do laundry');
  }

  doWork2() {
    (function () {

      console.log('(1)make a call to bank');

      //javascript engine always put async task to the event queue
      setTimeout(function () {
        console.log('(?->3) pick up the phone');
      }, 0);

    })();
    console.log('(?->2) do laundry');
  }

  // make a call to bank => 
  // do laundry =>
  // input your account number =>
  // input your online password

  doWork3() {
    (function () {
      console.log('(1) make a call to bank');

      //callback hell
      setTimeout(function () {
        console.log('(2) pick up the phone');

        setTimeout(function () {
          console.log('(3) input your account number');

          setTimeout(function () {
            console.log('(4) input your online password');
          }, 3000);
        }, 150);
      }, 1000);
    })();

    console.log('(*) do laundry');
  }

  //================================================================
  // Promise: 
  // a function with resolve & reject callback
  // resolve(V) => then((V)=>{...});
  // reject(V) => catch((V)=>{...});

  balance = 500;
  newFunctionWithdraw = (accountPWD) => new Promise(
    (resolve, reject) => {
      var amount = parseInt(prompt("Your balance is " + this.balance + ". Please input the aomount you want to withdraw:"));

      if (isNaN(amount)) {
        return;
      }else {
        if (amount <= this.balance) {
          this.balance -= amount;
          resolve('You withdraw:' + amount + '. Your balance is ' + this.balance);
        } else {
          reject('The amount of your withdraw is more than your balance' + '. Your balance is ' + this.balance);
        }
      }

    }
  );

  // Promise: 
  // a function which you can chane it (if you return another Promise)
  // then().then().then().then()...

  doWork4() {
    //var main = this;
    var accountPassword = prompt("Please enter your password:");

    this.newFunctionWithdraw(accountPassword)
      .then(
        (theReturn) => {
          console.log(theReturn);
          return this.newFunctionWithdraw(accountPassword);
        }
      )    
      .then(
        (theReturn) => {
          console.log(theReturn);
          return this.newFunctionWithdraw(accountPassword);
        }
      )
      .then(
        (theReturn) => {
          console.log(theReturn);
          return this.newFunctionWithdraw(accountPassword);
        }
      )
      .catch(
        (theError) => {
          console.log(theError);
          return this.newFunctionWithdraw(accountPassword);
        }
      )
    ;

  }

  // example of reject
  doWork5() {
    const promise = new Promise((resolve, reject) => {
      console.log("First be done");
      resolve("something back");
      reject(new Error("Something awful happened"));

    });

    promise.then((res) => {
      console.log(res)
      // This is never called 
    });
    
    promise.catch((err) => {
      console.log('I get called:', err.message); // I get called: 'Something awful happened'
    });
  }

  // example of resolve ---> observer
  doWork6() {
    var promise1 = Promise.resolve(123);

    promise1.then(function (value) {
      console.log(value);
      // expected output: 123
    });


  }

}
