import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-demo-routing-parameters',
  templateUrl: './demo-routing-parameters.component.html',
  styleUrls: ['./demo-routing-parameters.component.css']
})
export class DemoRoutingParametersComponent implements OnInit, OnDestroy {
  id: number;
  type: String;
  o1 = '';
  o2 = '';
  private sub: any;

  constructor(private route: ActivatedRoute) {
 

  }

  ngOnInit() {
  
    // param
    this.sub = this.route.params.subscribe(params => {
      console.log(params);

      this.id = params['productId']; // (+) converts string 'id' to a number
      this.type = params['productType'];
      
      if(params['option1']){
        this.o1 = params['option1'];
      }
      if(params['option2']){
        this.o2 = params['option2'];
      }
      

      // In a real app: dispatch action to load the details here.
    });

    // query param
    this.sub = this.route.queryParams.subscribe(queryParams => {
      console.log(queryParams);

      if(queryParams['option1']){
        this.o1 = queryParams['option1'];
      }
      if(queryParams['option2']){
        this.o2 = queryParams['option2'];
      }
    });
  }
  ngOnDestroy() {
    this.sub.unsubscribe();



  }
}
