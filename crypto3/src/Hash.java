import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

    private String file;

    public Hash(String file) {
        this.file = file;
    }

    public int[] getHash() throws NoSuchAlgorithmException {
        byte[] bytes = byte_parse_file();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(bytes);
        int[] hash_int = byte_mod(hash);
        return hash_int;
    }

    public byte[] byte_parse_file() {
        byte[] buffer = new byte[0];
        try(FileInputStream fin = new FileInputStream(file))
        {
            buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return buffer;
    }

    private int[] byte_mod(byte[] bytes) {
        int buf[] = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
//            System.out.print(" " + bytes[i]);
            buf[i] = bytes[i] + 128;
//            System.out.print(" " + buf[i]);
        }
        return buf;
    }
}
