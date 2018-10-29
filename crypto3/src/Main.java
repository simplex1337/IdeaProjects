import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, Exception {
        /*Hash hash = new Hash("src/file");
        int[] h = hash.getHash();
        for(int i = 0; i < h.length; i++) {
            System.out.println(h[i]);
        }*/
//        new Signature("src/file").rsa("src/sign");
        Signature sign = new Signature("src/file");
//        sign.rsa("src/sign_new");
//        sign.check_rsa("src/sign_new");
        sign.el_gamal("src/el_sign");
        sign.check_el_gamal("src/el_sign");

    }
}
