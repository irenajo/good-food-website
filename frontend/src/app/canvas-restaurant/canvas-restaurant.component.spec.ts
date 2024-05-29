import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CanvasRestaurantComponent } from './canvas-restaurant.component';

describe('CanvasRestaurantComponent', () => {
  let component: CanvasRestaurantComponent;
  let fixture: ComponentFixture<CanvasRestaurantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CanvasRestaurantComponent]
    });
    fixture = TestBed.createComponent(CanvasRestaurantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
