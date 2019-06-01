import {Component, OnInit} from '@angular/core';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-demo-form-template',
  templateUrl: './demo-form-template.component.html',
  styleUrls: ['./demo-form-template.component.css']
})
export class DemoFormTemplateComponent {

  modelForShowCss = {};
  modelForPattern = {};
  unamePattern = '^[a-z0-9_-]{8,15}$';
  emailPattern = '^(([^<>()\\[\\]\\\\.,;:\\s@"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@"]+)*)|(".+"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$';

  onSubmit(aFormYouInput: NgForm) {
    console.log(aFormYouInput.value);
    if (aFormYouInput.valid) {
      console.log('This form is good to go.');
      console.log(aFormYouInput.value);
    } else {
      console.log('This form is not filled properly.');
    }

  }
}
