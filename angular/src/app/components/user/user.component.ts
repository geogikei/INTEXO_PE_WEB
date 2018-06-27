import { Component, OnInit } from  '@angular/core';
import { APIService } from  '../../api/api.service';

@Component({
  selector:  'app-user',
  templateUrl:  './user.component.html',
  styleUrls: ['./user.component.css']
})

export  class  UserComponent  implements  OnInit {

  private  users:  Array<User> = [];

  constructor(private  apiService:  APIService) { }

  ngOnInit() {
    this.getUsers();
  }
  public  getUsers(){
    this.apiService.getUsers().subscribe((data:  Array<User>) => {
      this.users  =  data;
      console.log(data);
    });
  }
}

class User {
  id:number;
  userName:string;
  email:string;
  password:string;
  firstName:string;
  lastName:string;
  role:{
    id:number,
    role:string
  };

  constructor(id: number, userName: string, email: string, password: string, firstName: string, lastName: string, role: { id: number; role: string }) {
    this.id = id;
    this.userName = userName;
    this.email = email;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.role = role;
  }
}
