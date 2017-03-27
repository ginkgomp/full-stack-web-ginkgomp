package edu.infsci2560.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.infsci2560.models.Post;
import edu.infsci2560.services.AuthorService;
import edu.infsci2560.services.PostService;



@Controller
public class AdminPostController {
	
	private PostService postService;
	private AuthorService authorService;
	
	@Autowired
	public AdminPostController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
	}
	
	@RequestMapping("/posts")
	public String list(Model model) {
		model.addAttribute("posts", postService.list());
		return "post/list";
	}
	
	@RequestMapping("/post/{id}")
	public String view(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		return "post/view";
	}
	
	// create | save
	
	@RequestMapping("/post/create")
	public String create(Model model) {
		model.addAttribute("post", new Post());
		model.addAttribute("authors", authorService.list());
		return "post/postForm";
	}
	
	@RequestMapping( value = "/post/save", method = RequestMethod.POST )
	public String save(@Valid Post post, BindingResult bindingResult, Model model) {
				
		if( bindingResult.hasErrors() ){
			model.addAttribute("authors", authorService.list());
			return "post/postForm";
		} else {
			Post savedPost = postService.save(post);
			return "redirect:/post/" + savedPost.getId();			
		}

	}
	
	@RequestMapping("/post/edit/{id}")
	public String edit(@PathVariable Long id, Model model) {
		model.addAttribute("post", postService.get(id));
		model.addAttribute("authors", authorService.list());		
		return "post/postForm";
	}
	
	@RequestMapping("/post/delete/{id}")
	public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
		postService.delete(id);
		redirectAttrs.addFlashAttribute("message", "Post was deleted!");
		return "redirect:/admin/posts";
	}

}
