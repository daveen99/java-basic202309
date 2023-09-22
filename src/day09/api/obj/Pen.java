package day09.api.obj;

import java.util.Objects;

public class Pen {

    private Company company;
    private Integer serial; // 일련번호
    private String color; // 색상
    private long price; //가격

    public Pen() {
    }

    public Pen(Company company, int serial, String color, long price) {
        this.company = company;
        this.serial = serial;
        this.color = color;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "company=" + company +
                ", serial=" + serial +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }

    // equals를 오버라이딩 할때에는 반!드!시!
    // hashCode도 같이 오버라이딩 해야합니다!!
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Pen) {
            Pen target = (Pen) obj;
            return this.serial == target.serial
                    && this.company.equals(target.company)
                    && this.color.equals(target.color);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(serial, color ,company);
    }


}
