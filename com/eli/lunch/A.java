package cn.boccfc.transport.help;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class A {
    private String name;
    private BigDecimal needToPay;
    private BigDecimal paid;
    private BigDecimal restNeedToPay;
    public A(){

    }
    public A(String name){
        this.name = name;
        this.needToPay = new BigDecimal("0");
        this.paid = new BigDecimal("0");
    }

    public BigDecimal getRestNeedToPay() {
        return this.needToPay.subtract(this.paid).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getNeedToPay() {
        return this.needToPay.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setNeedToPay(BigDecimal needToPay) {
        this.needToPay = needToPay;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPaid() {
        return this.paid.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void setPaid(BigDecimal paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("A{");
        sb.append("name='").append(name).append('\'');
        sb.append(", needToPay=").append(getNeedToPay());
        sb.append(", paid=").append(getPaid());
        sb.append(", restNeedToPay=").append(getRestNeedToPay());
        sb.append('}');
        return sb.toString();
    }
}
