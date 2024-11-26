package hust.ite6.garbage;

public class GarbageCreator {
    public static void main(String[] args) throws Exception {
        String filename = "test.txt"; // test.exe is the name or path to an executable file
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        // Read all bytes from the specified file
        inputBytes = java.nio.file.Files.readAllBytes(java.nio.file.Paths.get(filename));

        // Measure time taken for byte-to-string conversion
        startTime = System.currentTimeMillis();
        String outputString = "";
        for (byte b : inputBytes) {
            outputString += (char) b;
        }
        endTime = System.currentTimeMillis();

        // Print the time elapsed
        System.out.println(endTime - startTime);
    }
}
