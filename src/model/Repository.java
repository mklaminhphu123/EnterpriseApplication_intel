package model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public interface Repository {
	Scanner connect()  throws FileNotFoundException;
	void disconnect(Scanner scanner);	
	ArrayList read() throws FileNotFoundException;
}
