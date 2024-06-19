package com.wipro.Product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.Product.entity.Product;
import com.wipro.Product.repo.ProductRepository;

@Controller
public class ProductController {
    @Autowired
	private ProductRepository repo;
	@GetMapping("/")
	public String loadForm(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}
	@PostMapping("/product")
	public String saveProduct(@Validated @ModelAttribute("product") Product p,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "index";
		}
		
		
		p=repo.save(p);
		if(p.getPid()!=null) {
			model.addAttribute("msg", "product saved");
		}
		return "index";
	}
	@GetMapping("/view")
	public String getAllProducts(Model model) {
		List<Product>list=repo.findAll();
		model.addAttribute("list", list);
		return "data";
		
	}
	@GetMapping("/delete")
	public String getDelete(@RequestParam("pid") Integer pid,Model model) {
		
		repo.deleteById(pid);
		model.addAttribute("product", repo.findAll());
		return "data";
		
	}
	@GetMapping("/edit")
	public String getEdit(@RequestParam("pid") Integer pid,Model model) {
		
		Optional<Product>findById=repo.findById(pid);
		if(findById.isPresent()) {
			Product product=findById.get();
			model.addAttribute("product", product);
		}
		
		return "index";
		
	}
	
}
