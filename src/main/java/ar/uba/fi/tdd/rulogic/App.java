package ar.uba.fi.tdd.rulogic;

import ar.uba.fi.tdd.rulogic.model.KnowledgeBase;

import java.util.Scanner;

/**
 * Console application.
 *
 */
public class App
{
	public static void main(String[] args) {
		System.out.println("I shall answer all your questions! - \"*\" to exit");

		final KnowledgeBase knowledgeBase = new KnowledgeBase( "rules.db" );

		Scanner reader = new Scanner(System.in);

		while (true) {

			System.out.println("Enter your query: ");
			String query = reader.nextLine();

			if ( query.equals("*") )
				break;

			System.out.println("The answer is: ");
			System.out.println( knowledgeBase.answer( query ));
		}
		reader.close();
	}
}
