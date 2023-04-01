package zoo.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import zoo.models.Animal;

public class GsonAnimal {

	public void writeJSON(Animal animal) {

		Collection<Animal> animals = readJSON();
		if (animals == null)
			animals = new ArrayList<Animal>();
		animals.add(animal);

		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter writer;
		try {
			writer = new FileWriter("src/zoo/json/animal.json");
			writer.write(gson.toJson(animals));
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Animal> readJSON() {
		List<Animal> resultado = new ArrayList<Animal>();
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		BufferedReader bufferedReader;

		try {
			bufferedReader = new BufferedReader(new FileReader("src/zoo/json/animal.json"));
			Type listType = new TypeToken<Collection<Animal>>() {
			}.getType();
			resultado = gson.fromJson(bufferedReader, listType);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return resultado;
	}

}
