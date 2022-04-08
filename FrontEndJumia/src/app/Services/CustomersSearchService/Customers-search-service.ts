import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { API_URL } from '../../Constants';
@Injectable({
  providedIn: 'root'
})
export class CustomersSearchService {
  constructor(private httpClient: HttpClient) { }

  getCustomers(pageNumber: number, state: any, country: any) {


    let baseUrl = API_URL;
    if (pageNumber !== undefined && pageNumber !== null) {
      baseUrl += 'pageNumber=' + pageNumber
    }
    if (state !== undefined && state !== null) {
      baseUrl += "&" + 'state=' + state
    }
    if (country !== undefined && country !== null) {
      baseUrl += "&" + 'country=' + country
    }
    return this.httpClient.get(baseUrl, {
      headers: new HttpHeaders({
        'Access-Control-Allow-Origin': '*',
        'content-Type': 'application/json'
      })
    });

  }
}