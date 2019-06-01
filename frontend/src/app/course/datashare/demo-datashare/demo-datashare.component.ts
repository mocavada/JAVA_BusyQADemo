import {DatashareService} from '../../datashare-service/service/datashare.service';
import {Component, OnInit, ViewChild} from '@angular/core';
import {DemoDataShareViewchildComponent} from '../demo-datashare-viewchild/demo-datashare-viewchild.component';

@Component({
  selector: 'app-demo-datashare',
  templateUrl: './demo-datashare.component.html',
  styleUrls: ['./demo-datashare.component.css']
})
export class DemoDatashareComponent implements OnInit {
  // ======== for Output Data Sharing
  theOutput;

  // ======== output
  // child->parent via output
  outputReceiver(receivedContent: String) {
    this.theOutput = receivedContent;
    console.log(receivedContent);
  }

  // ================================================================
  // ======== child->parent via viewChild
  // ======== for ViewChild Data Sharing
  @ViewChild(DemoDataShareViewchildComponent) child;
  parentV = ' PPP[parent]-[ts]';
  parentVCounter = 0;

  getFromChild() {
    // this.parentV = '<' + this.child.childV + '> : ' + ++this.parentVCounter;
    this.parentV = this.child.childV ;
  }

  // ======== parent->child via viewChild
  sendToChild() {
    this.child.childV = '<' + this.parentV + '> : ' + ++this.parentVCounter;
  }

  // ================================================================
  // ======== for Service Data Sharing
  messageSyncBySubscribe: string;
  messageSyncByField: string;

  constructor(private dService: DatashareService) {
  }

  ngOnInit() {
    this.dService.messageSource.subscribe(data => this.messageSyncBySubscribe = data);
    this.messageSyncByField = this.dService.messageSyncByField;
  }
}
