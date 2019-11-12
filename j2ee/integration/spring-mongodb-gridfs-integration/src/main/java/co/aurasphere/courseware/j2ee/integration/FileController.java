package co.aurasphere.courseware.j2ee.integration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * REST controller for the File servlet. Allows for saving and retrieving files.
 * 
 * @author Donato Rimenti
 */
@RestController
@RequestMapping("/files")
public class FileController {

	/**
	 * File database.
	 */
	@Autowired
	private FileDao fileDao;

	/**
	 * Saves a file to the Grid FS.
	 * 
	 * @param file the file to save
	 * @return the ID of the saved file
	 * @throws IOException if anything wrong occurs while receiving the file
	 */
	@PostMapping
	public String postFile(@RequestParam("file") MultipartFile file) throws IOException {
		return fileDao.saveFile(file.getInputStream());
	}

	/**
	 * Gets a file from the Grid FS.
	 * 
	 * @param id the ID of the file to retrieve
	 * @return the retrieved file
	 */
	@GetMapping("/{id}")
	public byte[] getFile(@PathVariable("id") String id) {
		return fileDao.loadFile(id);
	}

}
