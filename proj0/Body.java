public class Body{
  public double xxPos;
  public double yyPos;
  public double xxVel;
  public double yyVel;
  public double mass;
  public String imgFileName;

  public static final double g = 6.67e-11;



  /** constructor 1 */
  public Body(double xP, double yP, double xV,  double yV, double m, String img){
    xxPos = xP;
    yyPos = yP;
    xxVel = xV;
    yyVel = yV;
    mass = m;
    imgFileName = img;
  }

  /** constructor 2 */
  public Body(Body b){
    xxPos = b.xxPos;
    yyPos = b.yyPos;
    xxVel = b.xxVel;
    yyVel = b.yyVel;
    mass = b.mass;
    imgFileName = b.imgFileName;
  }

  public double calcDistance(Body b){
    double dx = (this.xxPos - b.xxPos);
    double dy = (this.yyPos - b.yyPos);
    return Math.sqrt(dx * dx + dy * dy);
  }

  public double calcForceExertedBy(Body b){
    double dist = this.calcDistance(b);
    double force = g*this.mass*b.mass/(dist*dist);
    return force;
  }


  public double calcNetForceExertedByX(Body[] allBodys){
    double forceX = 0;
    for (Body b: allBodys){
      if (! b.equals(this)){
        double f = this.calcForceExertedBy(b);
        forceX = forceX + f*(b.xxPos-this.xxPos)/this.calcDistance(b);
      }
    }
    return forceX;
  }

  public double calcNetForceExertedByY(Body[] allBodys){
    double forceY = 0;
    for (Body b: allBodys){
      if (! b.equals(this)){
        double f = this.calcForceExertedBy(b);
        forceY = forceY + f*(b.yyPos-this.yyPos)/this.calcDistance(b);
      }
    }
    return forceY;
  }

  public void update(double dt, double fX, double fY){
    double aX = fX/this.mass;
    double aY = fY/this.mass;
    xxVel = this.xxVel + dt*aX;
    yyVel = this.yyVel + dt*aY;
    xxPos = this.xxPos + dt*xxVel;
    yyPos = this.yyPos + dt*yyVel;
  }

  public void draw(){
    StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);

  }





}
