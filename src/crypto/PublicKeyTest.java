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


/**
 *
 * @author zachary.boburka
 */
public class PublicKeyTest {
    private PublicKeyTest() {}
    public static void main(String argv[]) throws Exception {
        
        /*
        * Phoebe creates her own DH key pair with 2048-it key size
        */
        
        System.out.println("PHOEBE: Generate DH keypair ...");
        KeyPairGenerator phoebeKeyPairGen = KeyPairGenerator.getInstance("DH");
        phoebeKeyPairGen.initialize(2048);
        KeyPair phoebeKeyPair = phoebeKeyPairGen.genKeyPair();
        
        //Phoebe creates and initializes her DH KeyAgreement object
        System.out.println("PHOEBE: Initialization ...");
        KeyAgreement phoebeKeyAgree = KeyAgreement.getInstance("DH");
        phoebeKeyAgree.init(phoebeKeyPair.getPrivate());
        
        //Phoebe encodes her public key. and sends it over to Bob.
        byte[] phoebePubKeyEnc = phoebeKeyPair.getPublic().getEncoded();
        
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
        
        //Tyson creates his own DH key pair
        System.out.println("TYSON: Generate DH keypair ...");
        KeyPairGenerator tysonKeyPairGen = KeyPairGenerator.getInstance("DH");
        tysonKeyPairGen.initialize(dhParamFromPhoebePubKey);
        KeyPair tysonKeyPair = tysonKeyPairGen.generateKeyPair();
        
        //Tyson creates and initializes his DH KeyAgreement object
        System.out.println("TYSON: Initialization ...");
        KeyAgreement tysonKeyAgree = KeyAgreement.getInstance("DH");
        tysonKeyAgree.init(phoebeKeyPair.getPrivate());
        
        //Tyson encodes his public key, and sends it over to Phoebe.
        byte[] tysonPubKeyEnc = tysonKeyPair.getPublic().getEncoded();
        
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
        
        /* 
        At this stage, both Phoebe and Tyson have completed the DH key
        agreement protocol.
        both generate the same shared secret.                    
        */
        
        try {
            byte[] phoebeSharedSecret = phoebeKeyAgree.generateSecret();
            int phoebeLen = phoebeSharedSecret.length;
            byte[] tysonSharedSecret = new byte[phoebeLen];
            int tysonLen;
            
        } catch (ShortBufferException e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
