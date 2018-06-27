import { Injectable } from '@angular/core';

@Injectable()
export class Configuration {
  public Server = 'http://localhost:8080/INTEXO_PE_WEB/';
  public ApiUrl = 'webapi/';
  public ServerWithApiUrl = this.Server + this.ApiUrl;
}
