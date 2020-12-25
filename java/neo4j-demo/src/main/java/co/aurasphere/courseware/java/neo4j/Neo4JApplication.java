package co.aurasphere.courseware.java.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;

/**
 * Inserts a bunch of customers and their related assets nodes. Requires an
 * underlying Neo4J database.
 * 
 * @author Donato Rimenti
 *
 */
public class Neo4JApplication {

	private static int numCustomer = 35_000;

	private static int numAsset = 3;

	private static final Driver driver = GraphDatabase.driver("bolt://localhost:7687",
			AuthTokens.basic("neo4j", "root"));;

	public static void main(String... args) throws Exception {
		try (Session session = driver.session()) {
			session.writeTransaction(new TransactionWork<String>() {
				@Override
				public String execute(Transaction tx) {

					StringBuilder query = new StringBuilder("CREATE ");
					for (int c = 0; c < numCustomer; c++) {
						query.append("(c" + c + ":Customer {id : " + c + "}),");
						for (int a = 0; a < numAsset; a++) {
							query.append("(ass" + a + ":Asset {id : '" + a + "'}),");
						}
					}
					tx.run(query.deleteCharAt(query.length() - 1).toString());
					return null;
				}
			});
		}
	}

}