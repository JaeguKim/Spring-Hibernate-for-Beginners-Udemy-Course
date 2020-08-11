package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MyRandomFortuneService implements FortuneService {
	
	private ArrayList<String> randomFortunes;
	private String fileName = "fortune-data.txt";
	Random myRandom = new Random();

	public MyRandomFortuneService() {
		System.out.println(">> In MyRandomFortuneService constructor");
	}
	
	@PostConstruct
	public void readFile() {
		System.out.println(">> readFile()");
		File theFile = new File(fileName);
		System.out.println("Reading fortunes from file: "+theFile);
		System.out.println("File exists: "+theFile.exists());
		
		// initialize array list
		randomFortunes = new ArrayList<String>();
		
		// read fortunes from file
		try (BufferedReader br = new BufferedReader(new FileReader(theFile))){
			String tempLine;
			
			while ((tempLine = br.readLine()) != null) {
				randomFortunes.add(tempLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String getFortune() {
		int rndIdx = myRandom.nextInt(randomFortunes.size());
		String tempFortune = randomFortunes.get(rndIdx);
		return tempFortune;
	}

}
