import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  number:number=1;
  username:string;
  password:string;

  constructor() {
    //console.log('construcor ran ...');
  }

  ngOnInit() {
  }

  addNumber(numParam:string){
    this.number+=Number(numParam);
    return false;
  }

  connect(usernameParam,passwordParam){
    this.username = usernameParam;
    this.password = passwordParam;
    console.log(usernameParam+" | "+passwordParam);
    return false;
  }

}
