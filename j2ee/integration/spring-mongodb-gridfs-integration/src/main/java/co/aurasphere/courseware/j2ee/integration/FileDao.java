package co.aurasphere.courseware.j2ee.integration;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.UUID;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.client.gridfs.GridFSBucket;

/**
 * DAO for storing and retrieving files in Grid FS.
 * 
 * @author Donato Rimenti
 */
@Repository
public class FileDao {

	/**
	 * The Grid File System object.
	 */
	@Autowired
	private GridFSBucket gridFs;

	/**
	 * Saves a file to Grid FS.
	 * 
	 * @param inputStream the file to save
	 * @return the ID of the saved file
	 */
	public String saveFile(InputStream inputStream) {
		return gridFs.uploadFromStream(UUID.randomUUID().toString(), inputStream).toString();
	}

	/**
	 * Loads a file from the Grid FS.
	 * 
	 * @param id the ID of the file to retrieve
	 * @return the requested file
	 */
	public byte[] loadFile(String id) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		gridFs.downloadToStream(new ObjectId(id), bos);
		return bos.toByteArray();
	}

}