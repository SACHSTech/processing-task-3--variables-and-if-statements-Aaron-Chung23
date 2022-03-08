import processing.core.PApplet;

public class Sketch extends PApplet {
	
	
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  float cx, cy;
  float secondsRadius;
  float minutesRadius;
  float hoursRadius;
  float clockDiameter;

  float smileyX = random(0, 500);
  float smileyY = random(0, 500);
  float smileySize = random(25, 250);
  float smileyDistance = smileySize / 5;
  
  public void settings() {
	// put your size call here
    size(500, 500);
    size(640, 360);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    stroke(255);
    
    int radius = min(width, height) / 5;
    secondsRadius = radius * (float) 0.72;
    minutesRadius = radius * (float) 0.60;
    hoursRadius = radius * (float) 0.50;
    clockDiameter = radius * (float) 1.8;
    
    cx = random(0, width);
    cy = random(0, height);
  
    if (0 < smileyX && smileyX < 100){
      background(0, 0, 255);
      }
    if (100 < smileyX && smileyX < 200){
      background(255,255,255);
    }
    if(200 < smileyX && smileyX < 300){
      background(0, 255, 0);
    }
    if(300 < smileyX && smileyX < 400){
      background(255, 0, 0);
    }
    if(400 < smileyX && smileyX < 500){
      background(255,0,255);
    }

  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    
  // Draw the clock background
  fill(80);
  noStroke();
  ellipse(cx, cy, clockDiameter, clockDiameter);
  
  // Angles for sin() and cos() start at 3 o'clock;
  // subtract HALF_PI to make them start at the top
  float s = map(second(), 0, 60, 0, TWO_PI) - HALF_PI;
  float m = map(minute() + norm(second(), 0, 60), 0, 60, 0, TWO_PI) - HALF_PI; 
  float h = map(hour() + norm(minute(), 0, 60), 0, 24, 0,  TWO_PI * 2) - HALF_PI;
  
  // Draw the hands of the clock
  stroke(255);
  strokeWeight(1);
  line(cx, cy, cx + cos(s) * secondsRadius, cy + sin(s) * secondsRadius);
  strokeWeight(2);
  line(cx, cy, cx + cos(m) * minutesRadius, cy + sin(m) * minutesRadius);
  strokeWeight(4);
  line(cx, cy, cx + cos(h) * hoursRadius, cy + sin(h) * hoursRadius);
  
  // Draw the minute ticks
  strokeWeight(2);
  beginShape(POINTS);
  for (int a = 0; a < 360; a+=6) {
  float angle = radians(a);
  float x = cx + cos(angle) * secondsRadius;
  float y = cy + sin(angle) * secondsRadius;
  vertex(x, y);


// Face
  fill(232, 190, 172);
  ellipse(smileyX, smileyY,
        smileySize, smileySize);

  fill(0, 0, 0);
  ellipse(smileyX-smileyDistance, smileyY-smileyDistance, smileySize/10, smileySize/10);

  fill(0, 0, 0);
  ellipse(smileyX+smileyDistance, smileyY-smileyDistance, smileySize/10, smileySize/10);

  line(smileyX/ (float) 1.333333, smileyY/ (float) 0.833333, smileyX/ (float) 0.8, smileyY/ (float)0.83333333);
  
  }
  
  // define other methods down here.
}
}