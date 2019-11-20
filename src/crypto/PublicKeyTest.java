/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.*;
import java.security.interfaces.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import javax.crypto.interfaces.*;
import com.sun.crypto.provider.SunJCE;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author zachary.boburka
 */
public class PublicKeyTest {
    //member variables
    
    
    private PublicKeyTest() {}
    
    public static KeyPair generateKeypair1(){
         KeyPair phoebeKeyPair = null;
        
        try {
            /*
            * Phoebe creates her own DH key pair with 2048-it key size
            */
            
            System.out.println("PHOEBE: Generate DH keypair ...");
            KeyPairGenerator phoebeKeyPairGen = KeyPairGenerator.getInstance("DH");
            phoebeKeyPairGen.initialize(2048);
            phoebeKeyPair = phoebeKeyPairGen.genKeyPair();
            
            //Phoebe creates and initializes her DH KeyAgreement object
            System.out.println("PHOEBE: Initialization ...");
            KeyAgreement phoebeKeyAgree = KeyAgreement.getInstance("DH");
            phoebeKeyAgree.init(phoebeKeyPair.getPrivate());
            
            
        } //generateKeypair
        catch (NoSuchAlgorithmException | InvalidKeyException ex) {
            System.out.println(ex);
        } 
        return phoebeKeyPair;
    }
    public static byte[] encodePubKey(KeyPair kp){
        //Phoebe encodes her public key. and sends it over to Bob.
           return kp.getPublic().getEncoded();
    }
    
    
    public static void instantiateKeypair1(){
        
        try {
            /*
            * Tyson has recieved Phoebe's public key in encoded format
            * he instanciates a DH public key from the encoded key material
            */
            
            KeyFactory tysonKeyFac = KeyFactory.getInstance("DH");
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(phoebePubKeyEnc);
            
            PublicKey phoebePubKey = tysonKeyFac.generatePublic(x509KeySpec);
            
            /*
            Tyson gets the Dh parameters associated with Phoebe's public key/.
            He must use the same perameters when he generates is own keyu pair
            */
            DHParameterSpec dhParamFromPhoebePubKey = ((DHPublicKey)phoebePubKey).getParams();
        } //instantiateKeypair
        catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);        }
    }
    
    public static void generateKeypair2(){
        KeyPair tysonKeyPair = null;
        
        try {
            //Tyson creates his own DH key pair
            System.out.println("TYSON: Generate DH keypair ...");
            KeyPairGenerator tysonKeyPairGen = KeyPairGenerator.getInstance("DH");
            tysonKeyPairGen.initialize(dhParamFromPhoebePubKey);
            tysonKeyPairGen.generateKeyPair();
            
            //Tyson creates and initializes his DH KeyAgreement object
            System.out.println("TYSON: Initialization ...");
            KeyAgreement tysonKeyAgree = KeyAgreement.getInstance("DH");
            tysonKeyAgree.init(phoebeKeyPair.getPrivate());
            
            //Tyson encodes his public key, and sends it over to Phoebe.
            byte[] tysonPubKeyEnc = tysonKeyPair.getPublic().getEncoded();
        } //generateKeypair2
        catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
        
    }
    
    public static void instantiateKeypair2(){
        /*
        Phoebe uses Tyson's public key for the first(and only) phase
        of her version of the DH protocol.
        Before she can do so, she has to instantiate a DH public key
        from Tyson's encoded key material.
        */
        
        KeyFactory phoebeKeyFac = KeyFactory.getInstance("DH");
        x509KeySpec = new X509EncodedKeySpec(tysonPubKeyEnc);
        PublicKey tysonPubKey = phoebeKeyFac.generatePublic(x509KeySpec);
        System.out.println("PHOEBE: Execute PHASE1 ...");
        phoebeKeyAgree.doPhase(tysonPubKey, true);
        
    }//instantiateKeypair2
    
    public static void generateSharedSecret(){
         /* 
        At this stage, both Phoebe and Tyson have completed the DH key
        agreement protocol.
        both generate the same shared secret.                    
        */
        System.out.println("TYSON: Execute PHASE1 ...");
        tysonKeyAgree.doPhase(phoebePubKey, true);
        
        try {
            byte[] phoebeSharedSecret = phoebeKeyAgree.generateSecret();
            int phoebeLen = phoebeSharedSecret.length;
            byte[] tysonSharedSecret = new byte[phoebeLen];
            int tysonLen;
            
        } catch (ShortBufferException e) {
            System.out.println(e.getMessage());
        }       //provide output buffer for required size
        tysonLen = tysonKeyAgree.generateSecret (tysonSharedSecret = 0);
        System.out.println("Phoebe secret: " + toHexString(phoebeSharedSecret));
        System.out.println("Tyson secret: " + toHexString(tysonSharedSecret));
        if(!java.util.Arrays.equals(phoebeSharedSecret, tysonSharedSecret))
            throw new Exception("Shared secrets are different");
        System.out.println("Shared secrets are the same");
        
        System.out.println("Use shared secret as SecretKeyObject...");
        SecretKeySpec tysonAesKey = new SecretKeySpec(tysonSharedSecret, 0, 16, "AES");
        SecretKeySpec phoebeAesKey = new SecretKeySpec(phoebeSharedSecret, 0, 16, "AES");
    }//generateSharedSecret
    
    public static void decryptKeypair(){
        /*
        Tyson decrypts using AES in CBC mode
        */
        Cipher tysonCipher = Cipher.getInstance("AES/CBS/PKCS5Padding");
        tysonCipher.init(Cipher.ENCRYPT_MODE, tysonAesKey);
        byte[] cleartext = "Please Work".getBytes();
        byte[] ciphertext = tysonCipher.doFinal(cleartext);
        
        byte[] encodedParams = tysonCipher.getParameters().getEncoded();
        
        /*
        Phoebe decrypts using AES in CBC mode
        */
        
        //instantiate AlgorithmParaneters object from parameter encoding obtained from tyson
        AlgorithmParameters aesParams = AlgorithmParameters.getInstance("AES");
        aesParams.init(encodedParams);
        Cipher phoebeCipher = Cipher.getInstance("AES/CBC/PKCSPadding");
        phoebeCipher.init(Cipher.DECRYPT_MODE, phoebeAesKey, aesParams);
        byte[] recovered = phoebeCipher.doFinal(ciphertext);
        if(!java.util.Arrays.equals(cleartext, recovered))
            throw new Exception ("AES in CBC mode recovered text is " + "different from cleartext");
        System.out.println("AES in CBC mode recovered text is same as cleartext");
    }
    
    /*
        Converts a byte to hex digit and wrires to the supplied buffer
        */
        private static void byte2hex(byte b, StringBuffer buf) {
            char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
                'A', 'B', 'C', 'D', 'E', 'F' };
            int high = ((b & 0xf0) >> 4);
            int low = (b & 0x0f);
            buf.append(hexChars[high]);
            buf.append(hexChars[low]);            
            }
        
        /*
        Converts byte array to hex string
        */
        private static String toHexString(byte[] block) {
            StringBuffer buf = new StringBuffer();
            int len = block.length;
            for (int i = 0; i < len; i++) {
                byte2hex(block[i], buf);
                if (i < len-1) {
                    buf.append(":");
                    
                }
            }
            return buf.toString();
        }
    public static void main(String argv[]) throws Exception {
        generateKeypair1();
        
        
        
    }//main
}//class