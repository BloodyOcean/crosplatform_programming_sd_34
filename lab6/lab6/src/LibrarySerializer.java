import java.io.*;

public class LibrarySerializer {
    private static final String path = "res.dat";
    public static void saveObject(Library lbr) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(lbr);
        objectOutputStream.close();
    }

    public static Library readObject() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Library lbr = (Library) objectInputStream.readObject();
        return lbr;
    }
}
