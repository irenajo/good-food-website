import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserNavbarComponent } from './user-navbar/user-navbar.component';
import { UserProfilePageComponent } from './user-profile-page/user-profile-page.component';
import { RestaurantsAllComponent } from './restaurants-all/restaurants-all.component';
import { CanvasRestaurantComponent } from './canvas-restaurant/canvas-restaurant.component';
import { ReservationsComponent } from './reservations/reservations.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    UserNavbarComponent,
    UserProfilePageComponent,
    RestaurantsAllComponent,
    CanvasRestaurantComponent,
    ReservationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
