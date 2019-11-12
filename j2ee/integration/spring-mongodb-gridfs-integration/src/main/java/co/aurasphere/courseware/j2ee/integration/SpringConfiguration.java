package co.aurasphere.courseware.j2ee.integration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

/**
 * Spring Configuration for this application.
 * 
 * @author Donato Rimenti
 */
@Configuration
public class SpringConfiguration {

	/**
	 * MongoDB host.
	 */
	private static final String MONGO_HOST = "127.0.0.1";

	/**
	 * Grid FS.
	 * 
	 * @param db the MongoDB database
	 * @return the Grid FS
	 */
	@Bean
	public GridFSBucket gridFs(MongoDatabase db) {
		return GridFSBuckets.create(db);
	}

	/**
	 * Mongo client.
	 *
	 * @return the Mongo client
	 */
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient(Arrays.asList(new ServerAddress(MONGO_HOST, 27017)));
	}

	/**
	 * Mongo database report.
	 *
	 * @param mongoClient the mongo client
	 * @return the mongo database
	 */
	@Bean
	public MongoDatabase mongoDatabaseReport(MongoClient mongoClient) {
		return mongoClient.getDatabase("report");
	}

	/**
	 * Multipart resolver.
	 *
	 * @return the commons multipart resolver
	 */
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

}