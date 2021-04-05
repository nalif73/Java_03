package ru.geekbrains;

import java.io.*;

public class ClientHistory {
    private String username;
    private ClientHandler clientHandler;
    private File file;
    private BufferedReader reader;
    private BufferedWriter writer;

    public ClientHistory(String username, ClientHandler clientHandler) throws IOException {
        this.username = username;
        this.clientHandler = clientHandler;
        try {
            file = new File(username + ".txt");
            if (file.exists()) {
                clientHandler.sendMessage("История Вашей переписки");
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    clientHandler.sendMessage(line);
                    line = reader.readLine();
                }
            } else {
                file.createNewFile();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer = new BufferedWriter(new FileWriter(file, true));
        }

    }

    public void writeInFile(String message) {
        try {
            writer.write("\n" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


