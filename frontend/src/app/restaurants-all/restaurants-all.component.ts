import { Component, OnInit } from '@angular/core';
import { RestaurantsAllService } from '../services/restaurants-all.service';

@Component({
  selector: 'app-restaurants-all',
  templateUrl: './restaurants-all.component.html',
  styleUrls: ['./restaurants-all.component.css']
})
export class RestaurantsAllComponent implements OnInit {

  stats: any;
  restaurants?: any[];
  sortedColumn?: string;
  ascending: boolean = true;
  searchTerm: string = '';

  constructor(private restaurantService: RestaurantsAllService) {}

  ngOnInit(): void {
    this.stats = this.restaurantService.getStats();
    this.restaurants = this.restaurantService.getRestaurants();
  }

  restaurantCheckOut(index: number) {
    if(this.restaurants) 
      alert(this.restaurants[index].name);
  }

  sort(column: string) {
    if(!this.restaurants) return;
    this.ascending = this.sortedColumn === column ? !this.ascending : true;
    this.sortedColumn = column;
    this.restaurants.sort((a, b) => {
      const aValue = a[column].toLowerCase();
      const bValue = b[column].toLowerCase();
      return this.ascending
        ? aValue.localeCompare(bValue)
        : bValue.localeCompare(aValue);
    });
  }

  search() {
    if(!this.restaurants) return;
    this.restaurants = this.restaurantService.getRestaurants().filter(
      restaurant =>
        restaurant.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        restaurant.address.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
        restaurant.type.toLowerCase().includes(this.searchTerm.toLowerCase())
    );
  }
}
