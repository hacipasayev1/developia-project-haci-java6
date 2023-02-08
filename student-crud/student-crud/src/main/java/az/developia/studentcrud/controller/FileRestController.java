package az.developia.studentcrud.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/files")
public class FileRestController {
	@PostMapping(path = "/upload")
	public String uploadFile(@RequestParam(name = "file", required = false) MultipartFile file) {
		String fileName=file.getOriginalFilename();

		try {
			InputStream stream = file.getInputStream();
			File java1 = new File("C:/java1");
			if (java1.exists()) {

			} else {
				java1.mkdir();
			}
			UUID uuid = UUID.randomUUID();
			String randomName = uuid.toString();

			String format = fileName.substring(fileName.lastIndexOf("."));

			randomName += format;
			fileName=randomName;
			Files.copy(stream, Paths.get("C:/java1/" + randomName), StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception exc) {
			exc.printStackTrace();
		}

		return fileName;
	}
}
