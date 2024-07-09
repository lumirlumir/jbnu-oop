import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class FileExplorer {
    private Path currentDir;

    public FileExplorer() {
        currentDir = Paths.get("C:\\");
    }

    public void listFiles() {
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(currentDir);
            System.out.println("\t [" + currentDir.toString() + "]");
            for (Path entry : stream) {
                BasicFileAttributes attrs = Files.readAttributes(entry, BasicFileAttributes.class);
                String type = attrs.isDirectory() ? "dir" : "file";
                String size = attrs.isDirectory() ? "0바이트" : attrs.size() + "바이트";
                System.out.printf("%-15s %-15s %s%n", type, size, entry.getFileName());
            }
        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        FileExplorer explorer = new FileExplorer();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("***** 파일 탐색기입니다. *****");
        
        while (true) {
            explorer.listFiles();
            
            while (true) {
            	System.out.print(">>");
                String command = scanner.nextLine().trim();

                if (command.equals("..")) {
                	if (!explorer.currentDir.equals(Paths.get("C:\\"))) 
                		explorer.currentDir = explorer.currentDir.getParent();
                	break;
                } else if (!command.isEmpty()) {
                    Path newPath = explorer.currentDir.resolve(command);

                    if (Files.isDirectory(newPath)) {
                    	explorer.currentDir = newPath;
                        break;
                    }        
                }

            }
        }
    }
}
