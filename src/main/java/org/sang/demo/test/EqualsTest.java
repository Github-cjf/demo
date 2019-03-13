package org.sang.demo.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by CJF on 2019/3/7.
 */
public class EqualsTest {
    static class Point {
        final int x;
        final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point))
                return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

        @Override
        public int hashCode() {

            return Objects.hash(x, y);
        }
    }

    static class ColorPoint extends Point {
        ColorEnum color;

        int x;

        public ColorPoint(int x, int y, ColorEnum color) {
            super(x, y);
            this.color = color;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point))
                return false;
            if (!(o instanceof ColorPoint)) {
                return o.equals(this);
            }
//            Point p = (Point)o;
//            return p.x == x && p.y == y;
            return super.equals(o) && ((ColorPoint) o).color == color;
        }

        @Override
        public int hashCode() {

            return Objects.hash(super.hashCode(), color);
        }
    }

    public static void main(String[] args) {
        ColorPoint p1 = new ColorPoint(1, 2, ColorEnum.blue);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, ColorEnum.red);
        Point p4 = new Point(1, 2);

        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p3));
        System.out.println(p1.equals(p3));

        Set<Point> set = new HashSet<>();
        set.add(p2);
        System.out.println(set.contains(p4));


    }


    static class Super{
        public Super(){
            overrideme();
            System.out.println("111");
        }

        public Super(int i){
            System.out.println("i==="+i);
        }

        public void overrideme() {

        }
    }
    static class Sub extends Super{
        private Date date;
        Sub(){
            date = new Date();
        }

        Sub(int i){
            super(7);
            System.out.println(i);
        }

        @Override
        public void overrideme() {
            System.out.println(date);
        }

        public static void main(String[] args) {
            Sub sub = new Sub(5);
            sub.overrideme();
        }
    }
}
