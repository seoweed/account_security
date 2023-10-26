package com.weed.account_security.crypt;

import com.weed.account_security.repository.AccountInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Base64;

import static org.junit.jupiter.api.Assertions.*;

class SeedCBCTest {
    @Autowired AccountInfoRepository accountInfoRepository;
    SeedCBC seedCBC = new SeedCBC();


    @Test
    void encoding() {
        seedCBC.encoding("hello");
    }

    @Test
    void decoding() {
        String encoding = seedCBC.encoding("876412sie!@");
        System.out.println("rawText = 876412sie!@");
        System.out.println("encoding = " + encoding);

//        String s = Base64.getEncoder().encodeToString(hellos);
//        System.out.println("Base64 Encoding = " + s);
//
//        byte[] decode = Base64.getDecoder().decode(s);
//        System.out.println("Base64 Encoding = " + decode);

//        String s = new String(hellos);
//        System.out.println("s = " + s);
//
//        byte[] bytes = s.getBytes();
//        System.out.println("bytes = " + bytes);

        String decoding = seedCBC.decoding(encoding);
        System.out.println("CBC decoding = " + decoding);


    }
}