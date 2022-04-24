package learn.ggs.springboot.java.springboot;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class AppController {
	
	@Autowired
	private DocumentRepository repo;
	
	@GetMapping("/")
	public String viewHomePage (Model model) {
		
		List<Document> listDocs = repo.findAll();
		model.addAttribute("listDocs", listDocs);
		return "home";
	}
	
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("document") MultipartFile multipartFile,RedirectAttributes ra) throws IOException, SQLIntegrityConstraintViolationException {
		String fileName = org.springframework.util.StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		Document document = new Document();
		document.setName(fileName);
		document.setContent(multipartFile.getBytes());
		document.setSize(multipartFile.getSize());
		document.setUploadTime(new Date());
		
		repo.save(document);
		
		ra.addFlashAttribute("message", "The File has been Upload Successfully.");
		
		return"redirect:/";
	}

}
