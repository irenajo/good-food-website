import { Injectable } from '@angular/core';
import { RESTAURANTS, STATS } from '../models/mock-data';

@Injectable({
  providedIn: 'root'
})
export class RestaurantsAllService {
  constructor(){}
  
  getRestaurants() {
    return RESTAURANTS;
  }

  getStats() {
    return STATS;
  }
}
