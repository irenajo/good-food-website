import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantsAllComponent } from './restaurants-all.component';

describe('RestaurantsAllComponent', () => {
  let component: RestaurantsAllComponent;
  let fixture: ComponentFixture<RestaurantsAllComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RestaurantsAllComponent]
    });
    fixture = TestBed.createComponent(RestaurantsAllComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
