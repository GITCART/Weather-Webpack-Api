package com.example.web.servlet;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.UUID;

public class Prueba {
    public static HashMap<String, Model> _modelsDb = new HashMap<>();

    public Gson _gson = new Gson();

    //Adds some default models to our db
    public static void Models() {

        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        _modelsDb.put(id1,
                new Model(
                        id1,
                        "Engine",
                        "... base 64 URN ..."));

        _modelsDb.put(id2,
                new Model(
                        id2,
                        "Hairdryer",
                        "... base 64 URN ..."));

        _modelsDb.put(id3,
                new Model(
                        id3,
                        "Plane Engine",
                        "... base 64 URN ..."));
    }
}

class Model{
    public String name;
    public String urn;
    public String id;

    public Model(String _id, String _name, String _urn) {
        name = _name;
        urn = _urn;
        id = _id;
    }
}