import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import controller.CMAMhelper;
import model.CMAM;

public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static CMAMhelper lih = new CMAMhelper();

	private static void addAnItem() {
		System.out.print("Enter a make: ");
		String make = in.nextLine();
		System.out.print("Enter an model: ");
		String model = in.nextLine();
		System.out.print("Enter an year: ");
		String year = in.nextLine();
		CMAM toAdd = new CMAM(make, model, year);
		lih.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		System.out.print("Enter the make to delete: ");
		String make = in.nextLine();
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the year to delete: ");
		String year = in.nextLine();
	}

	private static void editAnItem() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by Make");
		System.out.println("2 : Search by Model");
		System.out.println("3 : Search by Year");
		int searchBy = in.nextInt();
		in.nextLine();
		List<CMAM> foundItems = new ArrayList();
		if (searchBy == 1) {
			System.out.print("Enter the Make name: ");
			String makeName = in.nextLine();
			foundItems = lih.searchForItemByMake(makeName);
		} else if (searchBy == 2) {
			System.out.print("Enter the model: ");
			String modelName = in.nextLine();
			foundItems = lih.searchForItemByMake(modelName);
		} else {
			System.out.print("Enter the Year: ");
			String yearName = in.nextLine();
			foundItems = lih.searchForItemByMake(yearName);
		}
		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (CMAM l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();
			CMAM toEdit = lih.searchForItemById(idToEdit);
			System.out.println(
					"Changed " + toEdit.getYear() + ". Changed " + toEdit.getModel() + ". Changed " + toEdit.getMake());
			System.out.println("1 : Update Make");
			System.out.println("2 : Update Model");
			System.out.println("3 : Update Year");
			int update = in.nextInt();
			in.nextLine();
			if (update == 1) {
				System.out.print("New Make: ");
				String newMake = in.nextLine();
				toEdit.setMake(newMake);
			} else if (update == 2) {
				System.out.print("New Model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			} else if (update == 3) {
				System.out.print("New Year: ");
				String newYear = in.nextLine();
				toEdit.setYear(newYear);
			}
			lih.updateItem(toEdit);
		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("--- Welcome to our car list!---");
		while (goAgain) {
			System.out.println("* Select an item:");
			System.out.println("* 1 -- Add an item");
			System.out.println("* 2 -- Edit an item");
			System.out.println("* 3 -- Delete an item");
			System.out.println("* 4 -- View the list");
			System.out.println("* 5 -- Exit the program");
			System.out.print("* Your selection: ");
			int selection = in.nextInt();
			in.nextLine();
			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				// lih.cleanUp();
				System.out.println(" Goodbye! ");
				goAgain = false;
			}
		}
	}

	private static void viewTheList() {
	}
}
