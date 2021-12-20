package Utils.Math;

public class Vector2 {
    public float x;
    public float y;

    public Vector2 (){
        x = 0.0f;
        y = 0.0f;
    }

    public Vector2(float x, float y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vector2 other) {
        return (this.x == other.x && this.y == other.y);
    }

    public static double distance(Vector2 a, Vector2 b) {
        float v0 = b.x - a.x;
        float v1 = b.y - a.y;
        return Math.sqrt(v0*v0 + v1*v1);
    }

    public void normalize() {
        // sets length to 1
        //
        double length = Math.sqrt(x*x + y*y);

        if (length != 0.0) {
            float s = 1.0f / (float)length;
            x = x*s;
            y = y*s;
        }
    }

    public void add(Vector2 a, Vector2 b){
        a.x += b.x;
        a.y += b.y;
    }
    public void add(Vector2 other){
        x += other.x;
        y += other.y;
    }
    public void add(float x, float y){
        this.x += x;
        this.y += y;
    }

    public void subtract(Vector2 a, Vector2 b){
        a.x -= b.x;
        a.y -= b.y;
    }
    public void subtract(Vector2 other){
        x -= other.x;
        y -= other.y;
    }
    public void subtract(float x, float y){
        this.x -= x;
        this.y -= y;
    }

    public void multiply(Vector2 a, Vector2 b){
        a.x *= b.x;
        a.y *= b.y;
    }
    public void multiply(Vector2 other){
        x *= other.x;
        y *= other.y;
    }
    public void multiply(float x, float y){
        this.x *= x;
        this.y *= y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
