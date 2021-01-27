package com.epam.firstTask.exeption;

public class FileExeption extends Exception {
    public FileExeption() {
    }

    public FileExeption(String message) {
        super(message);
    }

    public FileExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public FileExeption(Throwable cause) {
        super(cause);
    }
}
}
