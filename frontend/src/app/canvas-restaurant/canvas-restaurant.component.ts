import { AfterViewInit, Component, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-canvas-restaurant',
  templateUrl: './canvas-restaurant.component.html',
  styleUrls: ['./canvas-restaurant.component.css']
})
export class CanvasRestaurantComponent implements AfterViewInit {

  @ViewChild('myCanvas', { static: false }) canvas!: ElementRef<HTMLCanvasElement>;
  private context: CanvasRenderingContext2D | null = null;

  ngAfterViewInit(): void {
    this.context = this.canvas.nativeElement.getContext('2d');
  }

  drawRectangle(): void {
    if (this.context) {
      this.context.clearRect(0, 0, this.canvas.nativeElement.width, this.canvas.nativeElement.height);
      this.context.fillStyle = 'blue';
      this.context.fillRect(50, 50, 150, 100);
    }
  }

  // ============================
  // its important myCanvas matches the variable name in the template

  // @ViewChild('myCanvas')
  // private myCanvas: ElementRef = {} as ElementRef;

  // context: CanvasRenderingContext2D;

  // constructor() {
  //   this.context = this.myCanvas.nativeElement.getContext('2d');
  // }

  // ngAfterViewInit(): void {
  // }

  // drawRectable() {
  //   var canvas = document.getElementById('stage');
  //   var ctx = this.myCanvas.nativeElement.getContext('2d');

  //   ctx.fillStyle = "#D74022";
  //   ctx.fillRect(25, 25, 150, 150);

  //   ctx.fillStyle = "rgba(0,0,0,0.5)";
  //   ctx.clearRect(60, 60, 120, 120);
  //   ctx.strokeRect(90, 90, 80, 80);
  // }

}

