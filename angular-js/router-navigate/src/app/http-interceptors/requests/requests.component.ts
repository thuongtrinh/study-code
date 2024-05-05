import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-requests',
  templateUrl: './requests.component.html',
  styleUrls: ['./requests.component.scss' ]
})
export class RequestsComponent implements OnInit {

  title = 'interceptors';
  data1: string;
  data2: string;
  URL_DATA = 'https://jsonplaceholder.typicode.com/todos/1';
  URL_DATA_INVALID = 'https://jsonplaceholder.typicode.com/todos/7878';
  URL_WEATHER = 'https://api.openweathermap.org/data/2.5/weather?q=London&mode=xml&appid=25a0801691214cdec4c44e5b125b6396';

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  requestData() {
    this.http.get(this.URL_DATA).subscribe(body => {
      console.log(body);
      this.data1 = JSON.stringify(body);
    });
  }

  requestXMLData() {
    this.http.get(this.URL_WEATHER).subscribe(body => {
      console.log(body);
      this.data2 = JSON.stringify(body);
    });
  }

  request404Data() {
    this.http.get(this.URL_DATA_INVALID).subscribe(res => {
        console.log(res);
      },
      err => console.error(err),
      () => console.log('Processing Complete.')
    );
  }
}
