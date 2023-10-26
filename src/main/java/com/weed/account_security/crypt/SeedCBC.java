package com.weed.account_security.crypt;

import com.weed.account_security.KISA_SEED_CBC;

import java.util.Base64;

public class SeedCBC {
    byte[] pbszUserKey = "GWNU12capstion!@".getBytes();
    byte[] pbszIV = "1234567890123456".getBytes();

    public String encoding(String rawText) {
        byte[] encodingText = KISA_SEED_CBC.SEED_CBC_Encrypt(pbszUserKey, pbszIV, rawText.getBytes(), 0, rawText.getBytes().length);

        String base64AndCbcEncoding = Base64.getEncoder().encodeToString(encodingText);


        return base64AndCbcEncoding;


    }

    public String decoding(String base64AndCbcEncoding) {
        byte[] cbcEncoding = Base64.getDecoder().decode(base64AndCbcEncoding);
        byte[] decodingText = KISA_SEED_CBC.SEED_CBC_Decrypt(pbszUserKey, pbszIV, cbcEncoding, 0, cbcEncoding.length);
        String result = new String(decodingText);
        return result;
    }
}
