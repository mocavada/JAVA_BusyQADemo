import {Component, OnInit} from '@angular/core';
import {JsonExample} from '../pojo/pojo-jsonexample';
import {HttpserviceService} from '../service/httpservice.service';
@Component({
  selector: 'app-demo-httpservice',
  templateUrl: './demo-httpservice.component.html',
  styleUrls: ['./demo-httpservice.component.css']
})
export class DemoHttpserviceComponent implements OnInit {

  getResult: JsonExample;
  postResult: JsonExample;

  constructor(private dService: HttpserviceService) {
  }

  ngOnInit() {

    this.dService.getSubject.subscribe((data: JsonExample) => {
      if (data != null) {
        this.getResult = data;
        console.log('load' + this.getResult.body);
      }
    });

    this.dService.postObservable.subscribe((data: any) => {
      if (data != null) {
        this.postResult = data;
        console.log('load' + this.postResult.body);
      }
    });
  }

  getData() {
    this.dService.getData('https://jsonplaceholder.typicode.com/posts/2');
  }

  postData() {
    const postExample = new JsonExample(10, 1000, 'testTitle', 'testBody');
    this.dService.postData('https://jsonplaceholder.typicode.com/posts', postExample);
  }

}
