package ru.example.homeWork;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class ReadWriteFile {
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static Student loadStudentFromFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.length() > 0) {
            try {
                if (fileName.endsWith(".json")) {
                    return objectMapper.readValue(file, Student.class);
                } else if (fileName.endsWith(".bin")) {
                    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                        return (Student) ois.readObject();
                    }
                } else if (fileName.endsWith(".xml")) {
                    return xmlMapper.readValue(file, Student.class);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void saveStudentToFile(Student student, String fileName) {
        File file = new File(fileName);
        try {
            if (fileName.endsWith(".json")) {
                objectMapper.writeValue(file, student);
            } else if (fileName.endsWith(".bin")) {
                try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                    oos.writeObject(student);
                }
            } else if (fileName.endsWith(".xml")) {
                xmlMapper.writeValue(file, student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveStudentToBIN(Student student, String fileName) throws Exception {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(student);
            }
        }
    }

    public static Student loadStudentFromBIN(String fileName) throws Exception {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            try (ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                return (Student) objectInputStream.readObject();
            }
        }
    }

}
