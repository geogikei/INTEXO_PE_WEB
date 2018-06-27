import { Injectable } from  '@angular/core';
import { HttpClient} from  '@angular/common/http';

@Injectable({providedIn:  'root'})

export  class  APIService {
  API_URL = 'http://localhost:8080/INTEXO_PE_WEB/webapi/';

  constructor(private  httpClient: HttpClient) {
  }

  getUsers() {
    return this.httpClient.get(`${this.API_URL}users`);
  }
}
