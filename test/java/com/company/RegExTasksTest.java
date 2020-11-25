package com.company;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegExTasksTest {
    @Test
    public void var1Test1() {
        String in = "Tab\tand  spaces. Sentence  spaces.  Valid sentence";
        String expected = "Tab and spaces.  Sentence spaces.  Valid sentence";
        Assertions.assertEquals(RegExTasks.var1(in), expected);
    }

    @Test
    void var3Test1() {
        String in = "http://www.example.com/";
        boolean expected = true;
        Assertions.assertEquals(RegExTasks.var3(in), expected);
    }

    @Test
    void var3Test2() {
        String in = "http://a.b";
        boolean expected = true;
        Assertions.assertEquals(RegExTasks.var3(in), expected);
    }

    @Test
    void var3Test3() {
        String in = "http://test.this-test.com/";
        boolean expected = true;
        Assertions.assertEquals(RegExTasks.var3(in), expected);
    }

    @Test
    void var3Test4() {
        String in = "http://test_ing.com";
        boolean expected = false;
        Assertions.assertEquals(RegExTasks.var3(in), expected);
    }

    @Test
    void var3Test5() {
        String in = "http://-example.com";
        boolean expected = false;
        Assertions.assertEquals(RegExTasks.var3(in), expected);
    }


    @Test
    void var12Test1() {
        String in = "Suzie Smith-Hopper is--test";
        String expected = "Suzie,Smith-Hopper,is,test";
        Assertions.assertEquals(expected, RegExTasks.var12(in));
    }

    @Test
    void var12Test2() {
        String in = "This \"big test\" is a 'big test'";
        String expected = "This,big test,is,a,big test";
        Assertions.assertEquals(expected, RegExTasks.var12(in));
    }

    @Test
    void var12Test3() {
        String in = "Almost \"this entire\" thing \"is just a\" quote";
        String expected = "Almost,this entire,thing,is just a,quote";
        Assertions.assertEquals(expected, RegExTasks.var12(in));
    }

    @Test
    void var12Test4() {
        String in = "I can't see Suzie Smith-Hopper anywhere; can you";
        String expected = "I,can't,see,Suzie,Smith-Hopper,anywhere,can,you";
        Assertions.assertEquals(expected, RegExTasks.var12(in));
    }
}