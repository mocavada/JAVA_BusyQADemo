import { DatashareService } from '../service/datashare.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-demo-datashare-sibling-target',
  templateUrl: './demo-datashare-sibling-target.component.html',
  styleUrls: ['./demo-datashare-sibling-target.component.css']
})
export class DemoDatashareSiblingTargetComponent implements OnInit {
  message: string;
  anotherMessage: string;
  constructor(private dService: DatashareService) { }

  ngOnInit() {
    this.dService.messageSource.subscribe(data => this.message = data);
    this.anotherMessage = this.dService.messageSyncByField; // doesn't work
  }

}
