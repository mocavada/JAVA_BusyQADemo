import {Component, OnInit} from '@angular/core';
import {GuestbookService} from '../service/guestbook.service';
import {Message} from '../pojo/message';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {HttpClient} from '@angular/common/http';
import {JobbankService} from '../../project-jobbank/service/jobbank.service';

@Component({
  selector: 'app-guestbook-ui',
  templateUrl: './guestbook-ui.component.html',
  styleUrls: ['./guestbook-ui.component.css']
})
export class GuestbookUiComponent implements OnInit {
  messageList: [Message];

  constructor(private dService: GuestbookService,
              private fb: FormBuilder,
              private http: HttpClient,
  ) {
  }

  ngOnInit() {
    this.dService.currentMessage.subscribe(data => {
      if (data != null) {
        this.messageList = data;
        console.log('load Data');
      }
    });
    this.dService.getData();
    console.log('load Page');
    //
    this.createForm();

  }

  // ======== submit

  msgCreateForm: FormGroup;

  devjson;

  onSubmit(f) {
    if (f.valid) {
      console.log('This form is good to go.');
    }
    // f.value.jobType = parseInt(f.value.jobType, 0);
    console.log(f.value);
    this.devjson = f.value;
    this.dService.postData(f.value);

  }

  // ========
  createForm() {
    this.msgCreateForm = this.fb.group({
      userName: '',
      email: '',
      messageContent: ''
    });
  }


}
