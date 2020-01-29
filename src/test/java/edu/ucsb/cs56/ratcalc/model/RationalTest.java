package edu.ucsb.cs56.ratcalc.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1;
    private Rational r_05_15;
    private Rational r_5_015;
    private Rational r_05_015;
    
    @Before 
    public void setUp(){
        r_5_15 = new Rational(5,15);
        r_24_6 = new Rational(24,6);
        r_3_7  = new Rational(3,7);
        r_13_4 = new Rational(13,4);
        r_20_25 = new Rational(20,25);
        r_0_1 = new Rational(0,1);
        r_05_15 = new Rational(-5,15);
        r_5_015 = new Rational(5,-15);
        r_05_015 = new Rational(-5,-15);
    }

    //test getNumerator
    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
        Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
        assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
        assertEquals(13, r_13_4.getNumerator());
    }

    @Test
    public void test_getNumerator_05_15() {
        assertEquals(-1,r_05_15.getNumerator());
    }

    @Test
    public void test_getNumerator_5_015() {
        assertEquals(-1,r_5_015.getNumerator());
    }

    @Test
    public void test_getNumerator_05_015() {
        assertEquals(1,r_05_015.getNumerator());
    }
    
    //test getDenominator
    @Test
    public void test_getDenominator_20_25() {
        assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
        assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_getDenominator_05_15() {
        assertEquals(3,r_05_15.getDenominator());
    }

    @Test
    public void test_getDenominator_5_015() {
       assertEquals(3,r_5_015.getDenominator());
    }

    @Test
    public void test_getDenominator_05_015() {
      assertEquals(3,r_05_015.getDenominator());
    }

    //test toString
    @Test
    public void test_toString_5_15() {
        assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
        assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
        assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
        assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
        assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_toString_05_15() {
        assertEquals("-1/3",r_05_15.toString());
    }

    @Test
    public void test_toString_5_015() {
        assertEquals("-1/3",r_5_015.toString());
    }

    @Test
    public void test_toString_05_015() {
        assertEquals("1/3",r_05_015.toString());
    }

    //test gcd
    @Test
    public void test_gcd_5_15() {
        assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
        assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
        assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
        assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
        assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_03_9() {
        assertEquals(3, Rational.gcd(-3,9));
    }

    @Test
    public void test_gcd_3_09() {
        assertEquals(3, Rational.gcd(3,-9));
    }

    @Test
    public void test_gcd_03_09() {
        assertEquals(3, Rational.gcd(-3,-9));
    }

    @Test
    public void test_gcd_20_25() {
        assertEquals(5, Rational.gcd(20,25));
    }

    //test rational
    @Test
    public void test_rational_m10_m5() {
        Rational r = new Rational(-10,-5);
        assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
        Rational r = new Rational(-5,6);
        assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
        Rational r = new Rational(7,-8);
        assertEquals("-7/8",r.toString());
    }

    //test times
    @Test
    public void test_r_5_15_times_r_3_7() {
        Rational r = r_5_15.times(r_3_7);
        assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
        Rational r = r_3_7.times(r_13_4);
        assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = r_m3_1.times(r_1_m3);
        assertEquals("1",r.toString());
    }

    //test product
    @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
        Rational r = Rational.product(r_3_7,r_13_4);
        assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = Rational.product(r_m3_1,r_1_m3);
        assertEquals("1",r.toString());
    }

    //test lcm
    @Test
    public void test_lcm_of_1_and_3() {
        assertEquals(3,Rational.lcm(1,3));
    }

    @Test   
    public void test_lcm_of_1_and_m3() {
        assertEquals(3,Rational.lcm(1,-3));
    }
    
    @Test
    public void test_lcm_of_5_and_3() {
        assertEquals(15,Rational.lcm(5,3));
    }
    
    @Test
    public void test_lcm_of_4_and_10() {
        assertEquals(20,Rational.lcm(4,10));
    }
    
    @Test
    public void test_lcm_of_15_and_6() {
        assertEquals(30,Rational.lcm(15,6));
    }
    
    @Test
    public void test_lcm_of_12_and_16() {
        assertEquals(48,Rational.lcm(12,16));
    }

    @Test
    public void test_lcm_2_3(){
        assertEquals(6, Rational.lcm(2,3));
    }

    @Test
    public void test_lcm_16_2(){
        assertEquals(16, Rational.lcm(16,2));
    }

    @Test
    public void test_lcm_m1_3(){
        assertEquals(3, Rational.lcm(-1,3));
    }

    @Test
    public void test_lcm_m2_m6(){
        assertEquals(6, Rational.lcm(-2,-6));
    }

    @Test(expected = java.lang.ArithmeticException.class)
    public void test_lcm_0_5(){
        Rational.lcm(0,5); //lcm of 0 does not exist
    }

    //test plus
    @Test
    public void test_r_5_15_plus_r_3_7() {
        Rational r = r_5_15.plus(r_3_7);
        assertEquals("16/21",r.toString());
    }

    @Test
    public void test_r_3_7_plus_r_13_4() {
        Rational r = r_3_7.plus(r_13_4);
        assertEquals("103/28",r.toString());
    }

    @Test
    public void test_r_m3_1_plus_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = r_m3_1.plus(r_1_m3);
        assertEquals("-10/3",r.toString());
    }

    @Test
    public void test_r_5_15_plus_r_24_6() {
        Rational r = r_5_15.plus(r_24_6);
        assertEquals("13/3",r.toString());
    }

    @Test
    public void test_r_0_1_plus_negative() {
        Rational neg = new Rational(-4, 9);
        Rational r = r_0_1.plus(neg);
        assertEquals("-4/9",r.toString());
    }

    @Test
    public void test_neg_plus_neg() {
        Rational neg1 = new Rational(-4, 9);
        Rational neg2 = new Rational(8, -2);
        Rational r = neg1.plus(neg2);
        assertEquals("-40/9",r.toString());
    }

    //test sum
    @Test
    public void test_sum_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = Rational.sum(r_m3_1,r_1_m3);
        assertEquals("-10/3",r.toString());
    }

    @Test
    public void test_sum_of_r_5_15_and_r_3_7() {
       Rational r = Rational.sum(r_5_15,r_3_7);
       assertEquals("16/21",r.toString());
    }

    @Test
    public void test_sum_of_r_3_7_and_r_13_4() {
        Rational r = Rational.sum(r_3_7,r_13_4);
        assertEquals("103/28",r.toString());
    }

   @Test
    public void test_sum_of_neg_and_neg() {
        Rational neg1 = new Rational(-4, 9);
        Rational neg2 = new Rational(8, -2);
        Rational r = Rational.sum(neg1, neg2);
        assertEquals("-40/9",r.toString());
    }

    @Test
    public void test_sum_of_r_0_1_and_negative() {
        Rational neg = new Rational(-4, 9);
        Rational r = Rational.sum(r_0_1, neg);
        assertEquals("-4/9",r.toString());
    }


    //test minus
    @Test
    public void test_r_5_15_minus_r_3_7() {
        Rational r = r_5_15.minus(r_3_7);
        assertEquals("-2/21",r.toString());
    }

    @Test
    public void test_r_3_7_minus_r_13_4() {
        Rational r = r_3_7.minus(r_13_4);
        assertEquals("-79/28",r.toString());
    }

    @Test
    public void test_r_m3_1_minus_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = r_m3_1.minus(r_1_m3);
        assertEquals("-8/3",r.toString());
    }

     @Test
    public void test_r_0_1_minus_negative() {
        Rational neg = new Rational(-4, 9);
        Rational r = r_0_1.minus(neg);
        assertEquals("4/9",r.toString());
    }

    @Test
    public void test_neg_minus_neg() {
        Rational neg1 = new Rational(-4, 9);
        Rational neg2 = new Rational(8, -2);
        Rational r = neg1.minus(neg2);
        assertEquals("32/9",r.toString());
    }


    //test difference
    @Test
    public void test_difference_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = Rational.difference(r_m3_1,r_1_m3);
        assertEquals("-8/3",r.toString());
    }

    @Test
    public void test_difference_of_r_5_15_and_r_3_7() {
       Rational r = Rational.difference(r_5_15,r_3_7);
       assertEquals("-2/21",r.toString());
    }

    @Test
    public void test_difference_of_r_3_7_and_r_13_4() {
        Rational r = Rational.difference(r_3_7,r_13_4);
        assertEquals("-79/28",r.toString());
    }

    @Test
    public void test_diff_of_r_5_15_and_r_3_7() {
        Rational r = Rational.difference(r_5_15,r_3_7);
        assertEquals("-2/21",r.toString());
    }

    @Test
    public void test_diff_of_r_0_1_and_negative() {
        Rational neg = new Rational(-4, 9);
        Rational r = Rational.difference(r_0_1,neg);
        assertEquals("4/9",r.toString());
    }

    @Test
    public void test_diff_of_neg_and_neg() {
        Rational neg1 = new Rational(-4, 9);
        Rational neg2 = new Rational(8, -2);
        Rational r = Rational.difference(neg1,neg2);
        assertEquals("32/9",r.toString());
    }

    //test reciprocalOf
    @Test
    public void test_reciprocalOf_r_5_15(){
        assertEquals("3", r_5_15.reciprocalOf().toString());

    }

    @Test
    public void test_reciprocalOf_r_24_6(){
        assertEquals("1/4", r_24_6.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocalOf_r_3_7(){
        assertEquals("7/3", r_3_7.reciprocalOf().toString());

    }

    @Test
    public void test_reciprocalOf_r_13_4(){
        assertEquals("4/13", r_13_4.reciprocalOf().toString());

    }

    @Test
    public void test_reciprocal_of_r_neg(){
        Rational neg = new Rational(-4, 9);
        Rational r = neg.reciprocalOf();
        assertEquals("-9/4", r.toString());
    }

    @Test
    public void test_reciprocalOf_r_20_25(){
        assertEquals("5/4", r_20_25.reciprocalOf().toString());

    }
    
    @Test(expected = java.lang.ArithmeticException.class)
    public void test_reciprocalOf_r_0_1(){
        r_0_1.reciprocalOf();
    }

    @Test
    public void test_reciprocalOf_r_05_15(){
        assertEquals("-3", r_05_15.reciprocalOf().toString());

    }

    @Test
    public void test_reciprocalOf_r_5_015(){
        assertEquals("-3", r_5_015.reciprocalOf().toString());
    }

    @Test
    public void test_reciprocalOf_r_05_015(){
        assertEquals("3", r_05_015.reciprocalOf().toString());
    }


    //test dividedBy
    @Test
    public void test_r_5_15_dividedBy_r_3_7() {
        Rational r = r_5_15.dividedBy(r_3_7);
        assertEquals("7/9",r.toString());
    }

    @Test
    public void test_r_3_7_dividedBy_r_13_4() {
        Rational r = r_3_7.dividedBy(r_13_4);
        assertEquals("12/91",r.toString());
    }

    @Test
    public void test_r_m3_1_dividedBy_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = r_m3_1.dividedBy(r_1_m3);
        assertEquals("9",r.toString());
    }

    @Test
    public void test_r_0_1_dividedBy_negative() {
        Rational neg = new Rational(-4, 9);
        Rational r = r_0_1.dividedBy(neg);
        assertEquals("0",r.toString());
    }

    @Test
    public void test_neg_dividedBy_neg() {
        Rational neg1 = new Rational(-4, 9);
        Rational neg2 = new Rational(8, -2);
        Rational r = neg1.dividedBy(neg2);
        assertEquals("1/9",r.toString());
    }

    //test quotient
    @Test
    public void test_quotient_of_r_5_15_and_r_3_7() {
       Rational r = Rational.quotient(r_5_15,r_3_7);
       assertEquals("7/9",r.toString());
    }

    @Test
    public void test_quotient_of_r_3_7_and_r_13_4() {
        Rational r = Rational.quotient(r_3_7,r_13_4);
        assertEquals("12/91",r.toString());
    }

    @Test
    public void test_quotient_of_r_m3_1_and_1_m3() {
        Rational r_m3_1 = new Rational(-3,1);
        Rational r_1_m3 = new Rational(1,-3);
        Rational r = Rational.quotient(r_m3_1,r_1_m3);
        assertEquals("9",r.toString());
    }

    @Test
    public void test_quotient_of_r_0_1_and_negative() {
        Rational neg = new Rational(-4, 9);
        Rational r = Rational.quotient(r_0_1,neg);
        assertEquals("0",r.toString());
    }

    @Test
    public void test_quotient_of_neg_and_neg() {
        Rational neg1 = new Rational(-4, 9);
        Rational neg2 = new Rational(8, -2);
        Rational r = Rational.quotient(neg1,neg2);
        assertEquals("1/9",r.toString());
    }

}

