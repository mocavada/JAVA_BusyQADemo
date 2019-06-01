import {JobbankService} from './../service/jobbank.service';
import {Component, OnInit} from '@angular/core';
import {Job} from '../pojo/job';

@Component({
  selector: 'app-joblist',
  templateUrl: './joblist.component.html',
  styleUrls: ['./joblist.component.css']
})
export class JoblistComponent implements OnInit {

  jobList: Job[];

  constructor(private dService: JobbankService) {
  }

  ngOnInit() {
    this.dService.results.subscribe(data => {
      if (data != null) {
        this.jobList = data;
        console.log('load');
      }
    });

    this.dService.getData();
    console.log('load');
  }

  editMode(item: Job) {
    item.editMode = true;
  }

  submitEditedJob(item: Job) {
    this.dService.editJob(item).subscribe(data => {
      console.log('update successfully');
      item.editMode = false;
    }, err => {
      console.log('Something went wrong!');
    });
  }


  deleteJob(job: Job) {
    console.log(this.jobList.indexOf(job));

    this.dService.delJob(job)
      .subscribe(data => {
        this.jobList.splice(this.jobList.indexOf(job), 1);
      }, err => {
        console.log('Something went wrong!');
      });

  }

}
